///
/// Copyright (c) 2022 TerraFrame, Inc. All rights reserved.
///
/// This file is part of Geoprism Registry(tm).
///
/// Geoprism Registry(tm) is free software: you can redistribute it and/or modify
/// it under the terms of the GNU Lesser General Public License as
/// published by the Free Software Foundation, either version 3 of the
/// License, or (at your option) any later version.
///
/// Geoprism Registry(tm) is distributed in the hope that it will be useful, but
/// WITHOUT ANY WARRANTY; without even the implied warranty of
/// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
/// GNU Lesser General Public License for more details.
///
/// You should have received a copy of the GNU Lesser General Public
/// License along with Geoprism Registry(tm).  If not, see <http://www.gnu.org/licenses/>.
///

/* eslint-disable padded-blocks */
import { GeoObjectType, GeoObject } from "./registry";
import { HierarchyType } from "./hierarchy";

export class LocationInformation {
    types: GeoObjectType[];
    hierarchies: HierarchyType[];
    hierarchy?: string;
    entity?: GeoObject;
    childType?: string;
    geojson: {
        type: string;
        features: GeoObject[]
    }
}

export class ModalState {
    SEARCH: number;
    VIEW: number;
}

export const PANEL_SIZE_STATE = {
    MINIMIZED: 0,
    WINDOWED: 1,
    FULLSCREEN: 2
};
