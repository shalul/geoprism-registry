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

import { Component, Input, Output, EventEmitter } from "@angular/core";
import { LayerRecord } from "@registry/model/list-type";

@Component({
    selector: "record-popup",
    templateUrl: "./record-popup.component.html",
    styleUrls: ["./dataset-location-manager.css"]
})
export class RecordPopupComponent {

    @Input() public record: LayerRecord;
    @Input() public canEdit: boolean = false;

    @Output() public edit = new EventEmitter<void>();

    onEdit(): void {
        this.edit.emit();
    }

}
