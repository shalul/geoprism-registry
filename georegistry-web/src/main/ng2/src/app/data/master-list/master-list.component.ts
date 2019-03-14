import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

import { MasterList } from '../../model/registry';

import { PublishModalComponent } from './publish-modal.component';

import { RegistryService } from '../../service/registry.service';
import { LocalizationService } from '../../core/service/localization.service';


@Component( {
    selector: 'master-list',
    templateUrl: './master-list.component.html',
    styleUrls: []
} )
export class MasterListComponent implements OnInit {
    message: string = null;
    list: MasterList = null;
    p: number = 1;
    current: string = '';
    filter: string = '';
    page: any = {
        count: 0,
        pageNumber: 1,
        pageSize: 10,
        results: []
    };

    /*
     * Reference to the modal current showing
    */
    private bsModalRef: BsModalRef;


    constructor( public service: RegistryService, private route: ActivatedRoute, private router: Router, private modalService: BsModalService ) { }

    ngOnInit(): void {
        const oid = this.route.snapshot.paramMap.get( 'oid' );

        this.service.getMasterList( oid ).then( list => {
            this.list = list;

            this.onPageChange( 1 );
        } );
    }

    onPageChange( pageNumber: number ): void {
        this.service.data( this.list.oid, pageNumber, this.page.pageSize, this.filter ).then( page => {
            this.page = page;
        } ).catch(( err: Response ) => {
            this.error( err.json() );
        } );
    }

    onSearch(): void {
        this.filter = this.current;

        this.onPageChange( 1 );
    }

    onPublish(): void {
        this.service.publishMasterList( this.list.oid ).then( list => {
            this.list = list;

            // Refresh the resultSet
            this.onPageChange( 1 );
        } ).catch(( err: Response ) => {
            this.error( err.json() );
        } );
    }

    onView( event: any ): void {
        event.preventDefault();

        this.bsModalRef = this.modalService.show( PublishModalComponent, {
            animated: true,
            backdrop: true,
            ignoreBackdropClick: true,
        } );
        this.bsModalRef.content.readonly = true;
        this.bsModalRef.content.master = this.list;

    }



    error( err: any ): void {
        // Handle error
        if ( err !== null ) {
            this.message = ( err.localizedMessage || err.message );
        }
    }

}
