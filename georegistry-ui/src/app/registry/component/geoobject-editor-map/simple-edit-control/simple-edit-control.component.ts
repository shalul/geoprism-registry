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


import { Component, ElementRef, Input, Output, EventEmitter } from "@angular/core";

@Component({
    selector: "simple-edit-control",
    templateUrl: "./simple-edit-control.component.html",
    styleUrls: ["./simple-edit-control.css"]
})
export class SimpleEditControl {

    elRef: ElementRef

    @Output() editEmitter = new EventEmitter<void>();

    @Input() visible: boolean = true;
    @Input() editSessionEnabled: boolean = false;
    @Input() save: boolean = false;

    constructor(elRef: ElementRef) {
        this.elRef = elRef;
    }

    onAdd(map): any {
        return this.elRef.nativeElement;
    }

    onRemove(map): void {
        this.elRef.nativeElement.remove();
    }

    onClick(): void {
        this.editEmitter.emit();
    }
}
