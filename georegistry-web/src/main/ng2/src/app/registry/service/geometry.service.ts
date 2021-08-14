import { Injectable, Output, EventEmitter } from "@angular/core";

import MapboxDraw from "@mapbox/mapbox-gl-draw";
import { Map } from "mapbox-gl";

import { Layer } from "../component/geoobject-shared-attribute-editor/manage-versions-model";

// eslint-disable-next-line no-unused-vars
declare let acp: any;

/**
 * This is a generic service used for rendering layers from ValueOverTime objects
 */
@Injectable()
export class GeometryService {

  map: Map;

  layers: Layer[] = [];

  geometryType: String;

  readOnly: boolean;

  // @Output() layersChange: EventEmitter<VersionOverTimeLayer[]> = new EventEmitter();

  editingControl: any = null;

  simpleEditControl: any = null;

  editingLayer: Layer;

  @Output() geometryChange = new EventEmitter<any>();

  // eslint-disable-next-line no-useless-constructor
  constructor() { }

  initialize(map: Map, geometryType: String, readOnly: boolean) {
    this.map = map;
    this.geometryType = geometryType;
    // this.editingControl = null;

    this.addLayers();

    this.map.on("draw.create", () => {
      this.saveEdits();
    });
    this.map.on("draw.delete", () => {
      this.saveEdits();
    });
    this.map.on("draw.update", () => {
      this.saveEdits();
    });
  }

  destroy(): void {
    this.map = null;
    this.editingLayer = null;
    this.editingControl = null;
  }

  addEditButton(): void {
    this.simpleEditControl.editEmitter.subscribe(versionObj => {
      // this.onClickEdit.emit();
    });

    this.map.addControl(this.simpleEditControl);
  }

  startEditing(layer: Layer) {
    if (this.isEditing()) {
      this.stopEditing();
    }

    this.editingLayer = layer;
    this.editingLayer.isEditing = true;

    if (!this.readOnly) {
      this.enableEditing();
    } else {
      this.addEditButton();
    }

    this.addEditingLayers();
  }

  stopEditing(rerender: boolean = true) {

    if (this.isEditing()) {
      this.saveEdits(rerender);

      this.editingLayer.isEditing = false;
      this.editingLayer = null;

      this.editingControl.deleteAll();
    }
  }

  isEditing(): boolean {
    return this.editingLayer != null;
  }

  setPointCoordinates(lat: any, long: any) {
    if (this.editingLayer != null) {
      this.editingControl.set({
        type: "FeatureCollection",
        features: [{
          id: this.editingLayer.oid,
          type: "Feature",
          properties: {},
          geometry: { type: "Point", coordinates: [long, lat] }
        }]
      });

      this.editingControl.changeMode("simple_select", { featureIds: this.editingLayer.oid });

      this.saveEdits();

      /*
      this.editingLayer.value = {
        type: 'FeatureCollection',
        features: [{
        id: this.editingLayer.oid,
          type: 'Feature',
          properties: {},
          geometry: { type: 'Point', coordinates: [ long, lat ] }
        }]
      };
      */

      /*
      this.editingLayer.value.coordinates = [ -97.4870830718814, 41.84836050415993 ];

      this.editingControl.set(this.editingLayer.value);

      this.removeLayers();
      this.addLayers();

      this.editingControl.changeMode( 'simple_select', { featureIds: this.editingLayer.oid } );
      */
    }
  }

  isValid(): boolean {
    if (!this.readOnly) {
      let isValid: boolean = false;

      if (this.editingControl != null) {
        let featureCollection: any = this.editingControl.getAll();

        if (featureCollection.features.length > 0) {
          isValid = true;
        }
      }

      return isValid;
    }

    return true;
  }

  saveEdits(rerender: boolean = true): void {
    if (this.editingLayer != null) {
      let geoJson = this.getDrawGeometry();

      this.editingLayer.editPropagator.value = geoJson;

      if (rerender) {
        this.removeLayers();
        this.addLayers();
      }
    }
  }

  public reload(): void {
    if (this.map != null) {
      this.removeLayers();
      this.addLayers();
      this.editingControl.deleteAll();
      this.addEditingLayers();
    }
  }

  setEditing(isEditing: boolean, layer: Layer) {
    if (this.isEditing()) {
      this.stopEditing();
    }

    layer.isEditing = isEditing;

    if (isEditing) {
      this.startEditing(layer);
    }
  }

  setRendering(isRendering: boolean, layer: Layer) {
    layer.isRendering = isRendering;
    this.addLayer(layer);
  }

  addLayer(newLayer: Layer) {
    let existingIndex = this.layers.findIndex((findLayer: Layer) => { return findLayer.oid === newLayer.oid });

    if (existingIndex != -1) {
      this.layers.splice(existingIndex, 1);
      this.layers.push(newLayer);
    }
    else {
      this.layers.push(newLayer);
    }

    if (newLayer.isEditing) {
      this.startEditing(newLayer);
    }

    this.layers = this.layers.sort((a, b) => { return a.zindex - b.zindex; });

    this.removeLayers();
    this.addLayers();
  }

  getLayers(): Layer[] {
    return this.layers;
  }

  getRenderedLayers(): Layer[] {
    return this.layers.filter(layer => layer.isRendering);
  }

  setLayers(layers: Layer[]): void {
    this.removeLayers();

    this.layers = layers.sort((a, b) => { return a.zindex - b.zindex; });

    this.addLayers();
  }

  enableEditing(): void {
    if (this.editingControl == null) {
      if (this.geometryType === "MULTIPOLYGON" || this.geometryType === "POLYGON") {
        this.editingControl = new MapboxDraw({
          controls: {
            point: false,
            line_string: false,
            polygon: true,
            trash: true,
            combine_features: false,
            uncombine_features: false
          }
        });
      } else if (this.geometryType === "POINT" || this.geometryType === "MULTIPOINT") {
        this.editingControl = new MapboxDraw({
          userProperties: true,
          controls: {
            point: true,
            line_string: false,
            polygon: false,
            trash: true,
            combine_features: false,
            uncombine_features: false
          },
          styles: [
            {
              id: "highlight-active-points",
              type: "circle",
              filter: ["all",
                ["==", "$type", "Point"],
                ["==", "meta", "feature"],
                ["==", "active", "true"]],
              paint: {
                "circle-radius": 13,
                "circle-color": "#33FFF9",
                "circle-stroke-width": 4,
                "circle-stroke-color": "white"
              }
            },
            {
              id: "points-are-blue",
              type: "circle",
              filter: ["all",
                ["==", "$type", "Point"],
                ["==", "meta", "feature"],
                ["==", "active", "false"]],
              paint: {
                "circle-radius": 10,
                "circle-color": "#800000",
                "circle-stroke-width": 2,
                "circle-stroke-color": "white"
              }
            }
          ]
        });
      } else if (this.geometryType === "LINE" || this.geometryType === "MULTILINE") {
        this.editingControl = new MapboxDraw({
          controls: {
            point: false,
            line_string: true,
            polygon: false,
            trash: true,
            combine_features: false,
            uncombine_features: false
          }
        });
      }

      if (this.map.getSource("mapbox-gl-draw-cold") == null) {
        this.map.addControl(this.editingControl);
      }
    }
  }

  addEditingLayers(): void {
    if (this.editingLayer != null && this.editingControl != null) {
      let val = this.editingLayer.editPropagator.value;

      if (val) {
        this.editingControl.add(this.editingLayer.editPropagator.value);
      }
    }
  }

  removeSource(prefix: string): void {
    if (!this.map) {
      return;
    }

    let sourceName: string = prefix + "-geoobject";

    if (this.geometryType === "MULTIPOLYGON" || this.geometryType === "POLYGON") {
      if (this.map.getLayer(sourceName + "-polygon") != null) {
        this.map.removeLayer(sourceName + "-polygon");
      }
    } else if (this.geometryType === "POINT" || this.geometryType === "MULTIPOINT") {
      if (this.map.getLayer(sourceName + "-point") != null) {
        this.map.removeLayer(sourceName + "-point");
      }
    } else if (this.geometryType === "LINE" || this.geometryType === "MultiLine") {
      if (this.map.getLayer(sourceName + "-line") != null) {
        this.map.removeLayer(sourceName + "-line");
      }
    }

    if (this.map.getSource(sourceName) != null) {
      this.map.removeSource(sourceName);
    }
  }

  removeLayers(): void {
    if (this.layers != null && this.layers.length > 0) {
      let len = this.layers.length;

      for (let i = 0; i < len; ++i) {
        let layer = this.layers[i];
        this.removeSource(layer.oid);
      }
    }
  }

  addLayers(): void {
    if (this.layers != null && this.layers.length > 0) {
      let len = this.layers.length;
      for (let i = 0; i < len; ++i) {
        let layer = this.layers[i];

        if (layer.isRendering) {
          this.renderGeometryAsLayer(layer.editPropagator == null ? layer.geojson : layer.editPropagator.value, layer.oid, layer.color);
        }
      }
    }
  }

  renderGeometryAsLayer(geometry: any, sourceName: string, color: string) {
    let finalSourceName: string = sourceName + "-geoobject";

    if (!this.map) {
      return;
    }
    if (!geometry) {
      return;
    }

    this.map.addSource(finalSourceName, {
      type: "geojson",
      data: {
        type: "FeatureCollection",
        features: []
      }
    });

    if (this.geometryType === "MULTIPOLYGON" || this.geometryType === "POLYGON") {
      // Polygon Layer
      this.map.addLayer({
        id: finalSourceName + "-polygon",
        type: "fill",
        source: finalSourceName,
        paint: {
          "fill-color": color,
          "fill-outline-color": "black",
          "fill-opacity": 0.7
        }
      });
    } else if (this.geometryType === "POINT" || this.geometryType === "MULTIPOINT") {
      // Point layer
      this.map.addLayer({
        id: finalSourceName + "-point",
        type: "circle",
        source: finalSourceName,
        paint: {
          "circle-radius": 3,
          "circle-color": color,
          "circle-stroke-width": 2,
          "circle-stroke-color": "#FFFFFF"
        }
      });
    } else if (this.geometryType === "LINE" || this.geometryType === "MULTILINE") {
      this.map.addLayer({
        id: finalSourceName + "-line",
        source: finalSourceName,
        type: "line",
        layout: {
          "line-join": "round",
          "line-cap": "round"
        },
        paint: {
          "line-color": color,
          "line-width": 2
        }
      });
    }

    (<any>this.map.getSource(finalSourceName)).setData(geometry);
  }

  getDrawGeometry(): any {
    if (this.editingControl != null) {
      let featureCollection: any = this.editingControl.getAll();

      if (featureCollection.features.length > 0) {
        // The first Feature is our GeoObject.

        // Any additional features were created using the draw editor. Combine them into the GeoObject if its a multi-polygon.
        if (this.geometryType === "MULTIPOLYGON") {
          let polygons = [];

          for (let i = 0; i < featureCollection.features.length; i++) {
            let feature = featureCollection.features[i];

            if (feature.geometry.type === "MultiPolygon") {
              for (let j = 0; j < feature.geometry.coordinates.length; j++) {
                polygons.push(feature.geometry.coordinates[j]);
              }
            } else {
              polygons.push(feature.geometry.coordinates);
            }
          }

          return {
            coordinates: polygons,
            type: "MultiPolygon"
          };
        } else if (this.geometryType === "MULTIPOINT") {
          let points = [];

          for (let i = 0; i < featureCollection.features.length; i++) {
            let feature = featureCollection.features[i];

            if (feature.geometry.type === "MultiPoint") {
              for (let j = 0; j < feature.geometry.coordinates.length; j++) {
                points.push(feature.geometry.coordinates[j]);
              }
            } else {
              points.push(feature.geometry.coordinates);
            }
          }

          return {
            coordinates: points,
            type: "MultiPoint"
          };
        } else if (this.geometryType === "MULTILINE") {
          let lines = [];

          for (let i = 0; i < featureCollection.features.length; i++) {
            let feature = featureCollection.features[i];

            if (feature.geometry.type === "MultiLineString") {
              for (let j = 0; j < feature.geometry.coordinates.length; j++) {
                lines.push(feature.geometry.coordinates[j]);
              }
            } else {
              lines.push(feature.geometry.coordinates);
            }
          }

          return {
            coordinates: lines,
            type: "MultiLineString"
          };
        } else {
          return featureCollection.features[0].geometry;
        }
      }
    }

    return null;
  }

}
