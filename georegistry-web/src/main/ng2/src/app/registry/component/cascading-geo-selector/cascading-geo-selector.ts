import { Component, OnInit, Input, EventEmitter, Output, ViewChild, OnChanges, SimpleChanges } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { ParentTreeNode, GeoObject, HierarchyOverTime } from '../../model/registry';
import { RegistryService } from '../../service/registry.service';

import { ManageParentVersionsModalComponent } from './manage-parent-versions-modal.component';

import { LocalizedValue } from '../../../shared/model/core';
import { ErrorModalComponent } from '../../../shared/component/modals/error-modal.component';

@Component( {

    selector: 'cascading-geo-selector',
    templateUrl: './cascading-geo-selector.html',
} )
export class CascadingGeoSelector {

    @Input() hierarchies: HierarchyOverTime[];

    @Output() valid = new EventEmitter<boolean>();

    @Input() isValid: boolean = true;

    @ViewChild( "mainForm" ) mainForm;

    @Input() forDate: Date = new Date();

    dateStr: string;

    cHierarchies: any[] = [];

    parentMap: any = {};

    bsModalRef: BsModalRef;

    constructor( private modalService: BsModalService, private registryService: RegistryService ) {

    }

    ngOnInit(): void {
        const day = this.forDate.getUTCDate();

        this.dateStr = this.forDate.getUTCFullYear() + "-" + ( this.forDate.getUTCMonth() + 1 ) + "-" + ( day < 10 ? "0" : "" ) + day;

        // Truncate any hours/minutes/etc which may be part of the date
        this.forDate = new Date( Date.parse( this.dateStr ) );

        this.calculate();
    }

    ngOnChanges( changes: SimpleChanges ) {

        if ( changes['forDate'] ) {
            this.calculate();
        }
    }

    calculate(): any {
        const time = this.forDate.getTime();

        this.isValid = true;

        this.cHierarchies = [];
        this.hierarchies.forEach( hierarchy => {
            const object = {};
            object['label'] = hierarchy.label;
            object['code'] = hierarchy.code;

            this.isValid = this.isValid && ( this.hierarchies.length > 0 );

            hierarchy.entries.forEach( pot => {
                const startDate = Date.parse( pot.startDate );
                const endDate = Date.parse( pot.endDate );

                if ( time >= startDate && time <= endDate ) {
                    let parents = [];

                    hierarchy.types.forEach( type => {
                        let parent: any = {
                            code: type.code,
                            label: type.label
                        }

                        if ( pot.parents[type.code] != null ) {
                            parent.text = pot.parents[type.code].text;
                            parent.geoObject = pot.parents[type.code].geoObject;
                        }

                        parents.push( parent );
                    } );

                    object['parents'] = parents;
                }
            } );

            this.cHierarchies.push( object );

        } );

        this.valid.emit();
    }

    public getIsValid(): boolean {
        return true;
    }

    public getHierarchies(): any {
        return this.hierarchies;
    }

    onManageVersions( code: string ): void {

        const hierarchy = this.hierarchies.find( h => h.code === code );

        this.bsModalRef = this.modalService.show( ManageParentVersionsModalComponent, {
            animated: true,
            backdrop: true,
            ignoreBackdropClick: true,
        } );
        this.bsModalRef.content.init( hierarchy );
        this.bsModalRef.content.onVersionChange.subscribe( hierarchy => {
            this.calculate();
        } );
    }

    public error( err: HttpErrorResponse ): void {
        // Handle error
        if ( err !== null ) {
            let bsModalRef = this.modalService.show( ErrorModalComponent, { backdrop: true } );
            bsModalRef.content.message = ( (err.error && (err.error.localizedMessage || err.error.message)) || err.message || "An unspecified error has occurred" );
        }
    }

}
