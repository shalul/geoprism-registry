import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { BsModalService } from 'ngx-bootstrap/modal';
import { Subject } from 'rxjs';
import { HttpErrorResponse } from "@angular/common/http";

import { StepConfig } from '../../../../shared/model/modal';
import { ConfirmModalComponent } from '../../../../shared/component/modals/confirm-modal.component';
import { ModalStepIndicatorService } from '../../../../shared/service/modal-step-indicator.service';
import { LocalizationService } from '../../../../shared/service/localization.service';

import { GeoObjectType, ManageGeoObjectTypeModalState, GeoObjectTypeModalStates } from '../../../model/registry';
import { RegistryService } from '../../../service/registry.service';
import { HierarchyService } from '../../../service/hierarchy.service';
import { GeoObjectTypeManagementService } from '../../../service/geoobjecttype-management.service'


@Component( {
    selector: 'geoobjecttype-input',
    templateUrl: './geoobjecttype-input.component.html',
    styleUrls: ['./geoobjecttype-input.css']
} )
export class GeoObjectTypeInputComponent implements OnInit {

    @Input() geoObjectType: GeoObjectType;
    @Output() geoObjectTypeChange:  EventEmitter<GeoObjectType> = new EventEmitter<GeoObjectType>();
    editGeoObjectType: GeoObjectType;
    
    @Input('setGeoObjectType') 
    set in(geoObjectType: GeoObjectType){
        if(geoObjectType){
          this.editGeoObjectType = JSON.parse(JSON.stringify(geoObjectType));
        //   this.geoObjectType = geoObjectType;
        }
    }
    message: string = null;
    modalState: ManageGeoObjectTypeModalState = {"state":GeoObjectTypeModalStates.manageGeoObjectType, "attribute":"", "termOption":""};

    modalStepConfig: StepConfig = {"steps": [
        {"label":this.localizationService.decode("modal.step.indicator.manage.geoobjecttype"), "active":true, "enabled":true}
    ]};

    constructor( private hierarchyService: HierarchyService, public bsModalRef: BsModalRef, public confirmBsModalRef: BsModalRef, private modalService: BsModalService, 
        private modalStepIndicatorService: ModalStepIndicatorService, private geoObjectTypeManagementService: GeoObjectTypeManagementService, 
        private localizationService: LocalizationService, private registryService: RegistryService ) {
    
    }

    ngOnInit(): void {

        this.modalStepIndicatorService.setStepConfig(this.modalStepConfig);
        this.geoObjectTypeManagementService.setModalState(this.modalState);
    }

    ngAfterViewInit() {
    }

    ngOnDestroy(){
    }

    manageAttributes(): void {
        this.geoObjectTypeManagementService.setModalState({"state":GeoObjectTypeModalStates.manageAttributes, "attribute":"", "termOption":""})
    }

    onModalStateChange(state: ManageGeoObjectTypeModalState): void {
        this.modalState = state;
    }

    update(): void {
        this.registryService.updateGeoObjectType( this.editGeoObjectType ).then( geoObjectType => {

            // emit the persisted geoobjecttype to the parent widget component (manage-geoobjecttype.component)
            // so that the change can be updated in the template
            this.geoObjectTypeChange.emit(geoObjectType);

            this.close();

        } ).catch(( err: HttpErrorResponse ) => {
            this.error( err );
        } );
    }

    // resetGeoObjectType(): void {
    //     this.geoObjectType = this.geoObjectTypeOriginal;
    // }

    close(): void {
        // this.resetGeoObjectType();
        this.bsModalRef.hide();
    }


    isValid(): boolean {
        // if(this.attribute.code && this.attribute.label) {

        //     // if code has a space
        //     if(this.attribute.code.indexOf(" ") !== -1){
        //         return false;
        //     }

        //     // If label is only spaces
        //     if(this.attribute.label.replace(/\s/g, '').length === 0) {
        //         return false
        //     }

        //     return true;
        // }
        
        // return false;

        return true;
    }

    error( err: HttpErrorResponse ): void {
        // Handle error
        if ( err !== null ) {
            this.message = ( err.error.localizedMessage || err.error.message || err.message );
            
            console.log(this.message);
        }
    }

}
