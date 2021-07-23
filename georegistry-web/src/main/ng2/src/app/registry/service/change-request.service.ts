import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient, HttpParams } from "@angular/common/http";
import { finalize } from "rxjs/operators";

import { ChangeRequest, UpdateAttributeAction, CreateGeoObjectAction } from "@registry/model/crtable";
import { EventService } from "@shared/service";
import { GeoObject } from "@registry/model/registry";

import { ImportConfiguration } from "@registry/model/io";

declare var acp: any;

@Injectable()
export class ChangeRequestService {

    // eslint-disable-next-line no-useless-constructor
    constructor(private http: HttpClient, private eventService: EventService) { }

    applyAction(action: any): Promise<void> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http
            .post<void>(acp + "/changerequest/applyAction", JSON.stringify({ action: action }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    applyActionStatusProperties(action: any): Promise<void> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http
            .post<void>(acp + "/changerequest/applyActionStatusProperties", JSON.stringify({ action: action }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    lockAction(actionId: string): Promise<void> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http
            .post<void>(acp + "/changerequest/lockAction", JSON.stringify({ actionId: actionId }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    unlockAction(actionId: string): Promise<void> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http
            .post<void>(acp + "/changerequest/unlockAction", JSON.stringify({ actionId: actionId }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

//    getAllRequests(filter: string): Promise<ChangeRequest[]> {
//      let params: HttpParams = new HttpParams();
//
//      params = params.set('filter', filter );
//
//        return this.http.get<ChangeRequest[]>( acp + '/changerequest/get-all-requests', { params: params } )
//            .toPromise();
//    }
    getAllRequests(filter: string): any {

        // eslint-disable-next-line quotes
        return JSON.parse('{ "count":2, "pageNumber":1, "pageSize":10, "resultSet":[ { "email":"blah@gmail.com", "phoneNumber":"999-999-9999", "contributorNotes":"blah blah blah...", "oid":"82069f12-ee9e-4913-aff9-fb91410005cd", "createDate":"2021-07-13", "approvalStatus":"PENDING", "maintainerNotes":"", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "actions":[ { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"displayLabel", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":{ "localizedValue":"FASTCambodia", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCambodia" } ] }, "newValue":{ "localizedValue":"NEW FASTCambodia", "localeValues":[ { "locale":"defaultLocale", "value":"NEW FASTCambodia" } ] }, "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } }, { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"NationalAnthem", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":"Nokor Reach", "newValue":"NEW_ANTHEM", "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } }, { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"DateOfFormation", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":"2020-05-04", "newValue":"2021-05-04", "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } }, { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"Religion", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":"Christian", "newValue":"Muslim", "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } }, { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"UnMember", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":"true", "newValue":"false", "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } }, { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"PhoneCountryCode", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":"855", "newValue":"999", "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } }, { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"GDP", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":"26.73", "newValue":"99.99", "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } }, { "oid":"cadcd4ac-20c2-4972-a608-2181890005d0", "actionType":"UpdateAttributeAction", "actionLabel":"Update Attribute", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "attributeName":"status", "attributeDiff":{ "valuesOverTime":[ { "oid":"78948945-fbd6-442d-8685-3a56bdc70631", "action":"UPDATE", "oldValue":"CGR:Status-Active", "newValue":"CGR:Status-Inactive", "newStartDate":"2020-05-04", "newEndDate":"2021-05-04", "oldStartDate":"2020-04-04", "oldEndDate":"2021-04-04" } ] } } ], "current": { "geoObjectType":{ "code":"FASTCountry", "label":{ "localizedValue":"FASTCountry", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCountry" } ] }, "description":{ "localizedValue":"FASTCountry", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCountry" } ] }, "geometryType":"MULTIPOLYGON", "isGeometryEditable":true, "isPrivate":false, "organizationCode":"FAST_CGOV", "superTypeCode":"", "attributes":[ { "code":"displayLabel", "type":"local", "label":{ "localizedValue":"Display Label", "localeValues":[ ] }, "description":{ "localizedValue":"Label of the location", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"code", "type":"character", "label":{ "localizedValue":"Code", "localeValues":[ { "locale":"defaultLocale", "value":"Code" } ] }, "description":{ "localizedValue":"Human readable unique identified", "localeValues":[ { "locale":"defaultLocale", "value":"Human readable unique identified" } ] }, "isDefault":true, "required":true, "unique":true, "isChangeOverTime":false }, { "code":"DateOfFormation", "type":"date", "label":{ "localizedValue":"Date Of Formation", "localeValues":[ { "locale":"defaultLocale", "value":"Date Of Formation" } ] }, "description":{ "localizedValue":"Description for DateOfFormation", "localeValues":[ { "locale":"defaultLocale", "value":"Description for DateOfFormation" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"lastUpdateDate", "type":"date", "label":{ "localizedValue":"Date Last Updated", "localeValues":[ ] }, "description":{ "localizedValue":"The date the object was updated", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"Religion", "type":"term", "label":{ "localizedValue":"Religion", "localeValues":[ { "locale":"defaultLocale", "value":"Religion" } ] }, "description":{ "localizedValue":"Description for Religion", "localeValues":[ { "locale":"defaultLocale", "value":"Description for Religion" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true, "rootTerm":{ "code":"CLASS_FASTCountry_Religion", "label":{ "localizedValue":"FASTCountry", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCountry" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ { "code":"FAST_Buddhism", "label":{ "localizedValue":"Buddhism", "localeValues":[ { "locale":"defaultLocale", "value":"Buddhism" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] }, { "code":"FAST_Islam", "label":{ "localizedValue":"Islam", "localeValues":[ { "locale":"defaultLocale", "value":"Islam" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] }, { "code":"FAST_Christianity", "label":{ "localizedValue":"Christianity", "localeValues":[ { "locale":"defaultLocale", "value":"Christianity" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] }, { "code":"FAST_Other", "label":{ "localizedValue":"Other", "localeValues":[ { "locale":"defaultLocale", "value":"Other" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] } ] } }, { "code":"UnMember", "type":"boolean", "label":{ "localizedValue":"UN Member", "localeValues":[ { "locale":"defaultLocale", "value":"UN Member" } ] }, "description":{ "localizedValue":"Description for UnMember", "localeValues":[ { "locale":"defaultLocale", "value":"Description for UnMember" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"type", "type":"character", "label":{ "localizedValue":"Type", "localeValues":[ ] }, "description":{ "localizedValue":"The type of the GeoObject", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"PhoneCountryCode", "type":"integer", "label":{ "localizedValue":"Phone Country Code", "localeValues":[ { "locale":"defaultLocale", "value":"Phone Country Code" } ] }, "description":{ "localizedValue":"Description for PhoneCountryCode", "localeValues":[ { "locale":"defaultLocale", "value":"Description for PhoneCountryCode" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"uid", "type":"character", "label":{ "localizedValue":"UID", "localeValues":[ ] }, "description":{ "localizedValue":"The internal globally unique identifier ID", "localeValues":[ ] }, "isDefault":true, "required":true, "unique":false, "isChangeOverTime":false }, { "code":"sequence", "type":"integer", "label":{ "localizedValue":"Sequence", "localeValues":[ ] }, "description":{ "localizedValue":"The sequence number of the GeoObject that is incremented when the object is updated", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"GDP", "type":"float", "label":{ "localizedValue":"Gross Domestic Product", "localeValues":[ { "locale":"defaultLocale", "value":"Gross Domestic Product" } ] }, "description":{ "localizedValue":"Description for GDP", "localeValues":[ { "locale":"defaultLocale", "value":"Description for GDP" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true, "precision":32, "scale":8 }, { "code":"NationalAnthem", "type":"character", "label":{ "localizedValue":"National Anthem", "localeValues":[ { "locale":"defaultLocale", "value":"National Anthem" } ] }, "description":{ "localizedValue":"Description for NationalAnthem", "localeValues":[ { "locale":"defaultLocale", "value":"Description for NationalAnthem" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"createDate", "type":"date", "label":{ "localizedValue":"Date Created", "localeValues":[ ] }, "description":{ "localizedValue":"The date the object was created", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"status", "type":"term", "label":{ "localizedValue":"Status", "localeValues":[ { "locale":"defaultLocale", "value":"Status" } ] }, "description":{ "localizedValue":"The status of the GeoObject", "localeValues":[ { "locale":"defaultLocale", "value":"The status of the GeoObject" } ] }, "isDefault":true, "required":true, "unique":false, "isChangeOverTime":true, "rootTerm":{ "code":"CGR:Status-Root", "label":{ "localizedValue":"GeoObject Status", "localeValues":[ ] }, "description":{ "localizedValue":"The status of a GeoObject changes during the governance lifecycle.", "localeValues":[ ] }, "children":[ { "code":"CGR:Status-New", "label":{ "localizedValue":"New", "localeValues":[ ] }, "description":{ "localizedValue":"A newly created GeoObject that has not been submitted for approval.", "localeValues":[ ] }, "children":[ ] }, { "code":"CGR:Status-Active", "label":{ "localizedValue":"Active", "localeValues":[ ] }, "description":{ "localizedValue":"The GeoObject is a part of the master list.", "localeValues":[ ] }, "children":[ ] }, { "code":"CGR:Status-Pending", "label":{ "localizedValue":"Pending", "localeValues":[ ] }, "description":{ "localizedValue":"Edits to the GeoObject are pending approval", "localeValues":[ ] }, "children":[ ] }, { "code":"CGR:Status-Inactive", "label":{ "localizedValue":"Inactive", "localeValues":[ ] }, "description":{ "localizedValue":"The object is not considered a source of truth", "localeValues":[ ] }, "children":[ ] } ] } } ] }, "geoObjectJson":{ "attributes":{ "displayLabel":{ "name":"displayLabel", "type":"local", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":{ "localizedValue":"FASTCambodia", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCambodia" } ] } } ] }, "PhoneCountryCode":{ "name":"PhoneCountryCode", "type":"integer", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"855" } ] }, "GDP":{ "name":"GDP", "type":"float", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"26.73" } ] }, "DateOfFormation":{ "name":"DateOfFormation", "type":"date", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":1626214811382 } ] }, "Religion":{ "name":"Religion", "type":"term", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":[ "FAST_Buddhism" ] } ] }, "geometry":{ "name":"geometry", "type":"geometry", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":{ "type":"MultiPolygon", "coordinates":[ [ [ [ 1.0, 1.0 ], [ 5.0, 1.0 ], [ 5.0, 5.0 ], [ 1.0, 5.0 ], [ 1.0, 1.0 ] ], [ [ 2.0, 2.0 ], [ 3.0, 2.0 ], [ 3.0, 3.0 ], [ 2.0, 3.0 ], [ 2.0, 2.0 ] ] ] ] } } ] }, "UnMember":{ "name":"UnMember", "type":"boolean", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":true } ] }, "NationalAnthem":{ "name":"NationalAnthem", "type":"character", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"Nokor Reach" } ] }, "status":{ "name":"status", "type":"term", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":[ "CGR:Status-Active" ] } ] }, "uid":"5e8728e8-e52c-4c5d-a557-551a1cbcac4d", "code":"FASTCambodia", "lastUpdateDate":1626214811623, "type":"FASTCountry", "createDate":1626214811623 } } } }, { "oid":"bf4ad271-19a7-4233-a1c7-a95d510005cd", "createDate":"2021-07-13", "approvalStatus":"PENDING", "maintainerNotes":"", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "actions":[ { "oid":"fef8350a-e39d-4093-a6e1-ca110d00066e", "actionType":"CreateGeoObjectAction", "actionLabel":"Create Geo-Object", "createActionDate":"2021-07-13", "contributorNotes":"", "maintainerNotes":"", "additionalNotes":"", "approvalStatus":"PENDING", "statusLabel":"PENDING", "createdBy":"SYSTEM", "documents":[ ], "permissions":[ "SUBMIT", "WRITE_DOCUMENTS", "WRITE", "WRITE_MAINTAINER_NOTES", "READ_APPROVAL_STATUS", "READ_CONTRIBUTOR_NOTES", "EXECUTE", "READ_DOCUMENTS", "READ_DETAILS", "WRITE_APPROVAL_STATUS", "READ", "READ_MAINTAINER_NOTES" ], "geoObjectJson":{ "attributes":{ "displayLabel":{ "name":"displayLabel", "type":"local", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":{ "localizedValue":"FASTCambodia", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCambodia" } ] } } ] }, "PhoneCountryCode":{ "name":"PhoneCountryCode", "type":"integer", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"855" } ] }, "GDP":{ "name":"GDP", "type":"float", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"26.73" } ] }, "DateOfFormation":{ "name":"DateOfFormation", "type":"date", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":1626214811382 } ] }, "Religion":{ "name":"Religion", "type":"term", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":[ "FAST_Buddhism" ] } ] }, "geometry":{ "name":"geometry", "type":"geometry", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":{ "type":"MultiPolygon", "coordinates":[ [ [ [ 1.0, 1.0 ], [ 5.0, 1.0 ], [ 5.0, 5.0 ], [ 1.0, 5.0 ], [ 1.0, 1.0 ] ], [ [ 2.0, 2.0 ], [ 3.0, 2.0 ], [ 3.0, 3.0 ], [ 2.0, 3.0 ], [ 2.0, 2.0 ] ] ] ] } } ] }, "UnMember":{ "name":"UnMember", "type":"boolean", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":true } ] }, "NationalAnthem":{ "name":"NationalAnthem", "type":"character", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"Nokor Reach" } ] }, "status":{ "name":"status", "type":"term", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":[ "CGR:Status-Active" ] } ] }, "uid":"5e8728e8-e52c-4c5d-a557-551a1cbcac4d", "code":"FASTCambodia", "lastUpdateDate":1626214811623, "type":"FASTCountry", "createDate":1626214811623 } } } ], "current":{ "geoObjectType":{ "code":"FASTCountry", "label":{ "localizedValue":"FASTCountry", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCountry" } ] }, "description":{ "localizedValue":"FASTCountry", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCountry" } ] }, "geometryType":"MULTIPOLYGON", "isGeometryEditable":true, "isPrivate":false, "organizationCode":"FAST_CGOV", "superTypeCode":"", "attributes":[ { "code":"displayLabel", "type":"local", "label":{ "localizedValue":"Display Label", "localeValues":[ ] }, "description":{ "localizedValue":"Label of the location", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"code", "type":"character", "label":{ "localizedValue":"Code", "localeValues":[ { "locale":"defaultLocale", "value":"Code" } ] }, "description":{ "localizedValue":"Human readable unique identified", "localeValues":[ { "locale":"defaultLocale", "value":"Human readable unique identified" } ] }, "isDefault":true, "required":true, "unique":true, "isChangeOverTime":false }, { "code":"DateOfFormation", "type":"date", "label":{ "localizedValue":"Date Of Formation", "localeValues":[ { "locale":"defaultLocale", "value":"Date Of Formation" } ] }, "description":{ "localizedValue":"Description for DateOfFormation", "localeValues":[ { "locale":"defaultLocale", "value":"Description for DateOfFormation" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"lastUpdateDate", "type":"date", "label":{ "localizedValue":"Date Last Updated", "localeValues":[ ] }, "description":{ "localizedValue":"The date the object was updated", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"Religion", "type":"term", "label":{ "localizedValue":"Religion", "localeValues":[ { "locale":"defaultLocale", "value":"Religion" } ] }, "description":{ "localizedValue":"Description for Religion", "localeValues":[ { "locale":"defaultLocale", "value":"Description for Religion" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true, "rootTerm":{ "code":"CLASS_FASTCountry_Religion", "label":{ "localizedValue":"FASTCountry", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCountry" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ { "code":"FAST_Buddhism", "label":{ "localizedValue":"Buddhism", "localeValues":[ { "locale":"defaultLocale", "value":"Buddhism" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] }, { "code":"FAST_Islam", "label":{ "localizedValue":"Islam", "localeValues":[ { "locale":"defaultLocale", "value":"Islam" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] }, { "code":"FAST_Christianity", "label":{ "localizedValue":"Christianity", "localeValues":[ { "locale":"defaultLocale", "value":"Christianity" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] }, { "code":"FAST_Other", "label":{ "localizedValue":"Other", "localeValues":[ { "locale":"defaultLocale", "value":"Other" } ] }, "description":{ "localizedValue":"", "localeValues":[ ] }, "children":[ ] } ] } }, { "code":"UnMember", "type":"boolean", "label":{ "localizedValue":"UN Member", "localeValues":[ { "locale":"defaultLocale", "value":"UN Member" } ] }, "description":{ "localizedValue":"Description for UnMember", "localeValues":[ { "locale":"defaultLocale", "value":"Description for UnMember" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"type", "type":"character", "label":{ "localizedValue":"Type", "localeValues":[ ] }, "description":{ "localizedValue":"The type of the GeoObject", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"PhoneCountryCode", "type":"integer", "label":{ "localizedValue":"Phone Country Code", "localeValues":[ { "locale":"defaultLocale", "value":"Phone Country Code" } ] }, "description":{ "localizedValue":"Description for PhoneCountryCode", "localeValues":[ { "locale":"defaultLocale", "value":"Description for PhoneCountryCode" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"uid", "type":"character", "label":{ "localizedValue":"UID", "localeValues":[ ] }, "description":{ "localizedValue":"The internal globally unique identifier ID", "localeValues":[ ] }, "isDefault":true, "required":true, "unique":false, "isChangeOverTime":false }, { "code":"sequence", "type":"integer", "label":{ "localizedValue":"Sequence", "localeValues":[ ] }, "description":{ "localizedValue":"The sequence number of the GeoObject that is incremented when the object is updated", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"GDP", "type":"float", "label":{ "localizedValue":"Gross Domestic Product", "localeValues":[ { "locale":"defaultLocale", "value":"Gross Domestic Product" } ] }, "description":{ "localizedValue":"Description for GDP", "localeValues":[ { "locale":"defaultLocale", "value":"Description for GDP" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true, "precision":32, "scale":8 }, { "code":"NationalAnthem", "type":"character", "label":{ "localizedValue":"National Anthem", "localeValues":[ { "locale":"defaultLocale", "value":"National Anthem" } ] }, "description":{ "localizedValue":"Description for NationalAnthem", "localeValues":[ { "locale":"defaultLocale", "value":"Description for NationalAnthem" } ] }, "isDefault":false, "required":false, "unique":false, "isChangeOverTime":true }, { "code":"createDate", "type":"date", "label":{ "localizedValue":"Date Created", "localeValues":[ ] }, "description":{ "localizedValue":"The date the object was created", "localeValues":[ ] }, "isDefault":true, "required":false, "unique":false, "isChangeOverTime":false }, { "code":"status", "type":"term", "label":{ "localizedValue":"Status", "localeValues":[ { "locale":"defaultLocale", "value":"Status" } ] }, "description":{ "localizedValue":"The status of the GeoObject", "localeValues":[ { "locale":"defaultLocale", "value":"The status of the GeoObject" } ] }, "isDefault":true, "required":true, "unique":false, "isChangeOverTime":true, "rootTerm":{ "code":"CGR:Status-Root", "label":{ "localizedValue":"GeoObject Status", "localeValues":[ ] }, "description":{ "localizedValue":"The status of a GeoObject changes during the governance lifecycle.", "localeValues":[ ] }, "children":[ { "code":"CGR:Status-New", "label":{ "localizedValue":"New", "localeValues":[ ] }, "description":{ "localizedValue":"A newly created GeoObject that has not been submitted for approval.", "localeValues":[ ] }, "children":[ ] }, { "code":"CGR:Status-Active", "label":{ "localizedValue":"Active", "localeValues":[ ] }, "description":{ "localizedValue":"The GeoObject is a part of the master list.", "localeValues":[ ] }, "children":[ ] }, { "code":"CGR:Status-Pending", "label":{ "localizedValue":"Pending", "localeValues":[ ] }, "description":{ "localizedValue":"Edits to the GeoObject are pending approval", "localeValues":[ ] }, "children":[ ] }, { "code":"CGR:Status-Inactive", "label":{ "localizedValue":"Inactive", "localeValues":[ ] }, "description":{ "localizedValue":"The object is not considered a source of truth", "localeValues":[ ] }, "children":[ ] } ] } } ] }, "geoObjectJson":{ "attributes":{ "displayLabel":{ "name":"displayLabel", "type":"local", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":{ "localizedValue":"FASTCambodia", "localeValues":[ { "locale":"defaultLocale", "value":"FASTCambodia" } ] } } ] }, "PhoneCountryCode":{ "name":"PhoneCountryCode", "type":"integer", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"855" } ] }, "GDP":{ "name":"GDP", "type":"float", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"26.73" } ] }, "DateOfFormation":{ "name":"DateOfFormation", "type":"date", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":1626214811382 } ] }, "Religion":{ "name":"Religion", "type":"term", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":[ "FAST_Buddhism" ] } ] }, "geometry":{ "name":"geometry", "type":"geometry", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":{ "type":"MultiPolygon", "coordinates":[ [ [ [ 1.0, 1.0 ], [ 5.0, 1.0 ], [ 5.0, 5.0 ], [ 1.0, 5.0 ], [ 1.0, 1.0 ] ], [ [ 2.0, 2.0 ], [ 3.0, 2.0 ], [ 3.0, 3.0 ], [ 2.0, 3.0 ], [ 2.0, 2.0 ] ] ] ] } } ] }, "UnMember":{ "name":"UnMember", "type":"boolean", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":true } ] }, "NationalAnthem":{ "name":"NationalAnthem", "type":"character", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":"Nokor Reach" } ] }, "status":{ "name":"status", "type":"term", "values":[ { "startDate":"2020-04-04", "endDate":"5000-12-31", "value":[ "CGR:Status-Active" ] } ] }, "uid":"5e8728e8-e52c-4c5d-a557-551a1cbcac4d", "code":"FASTCambodia", "lastUpdateDate":1626214811623, "type":"FASTCountry", "createDate":1626214811623 } } } } ] }');

    }

    getRequestDetails(requestId: string): Promise<ChangeRequest> {

        let params: HttpParams = new HttpParams();
        params = params.set("requestId", requestId);

        this.eventService.start();

        return this.http.get<ChangeRequest>(acp + "/changerequest/get-request-details", { params: params })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    confirmChangeRequest(requestId: string): Promise<ChangeRequest> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http.post<ChangeRequest>(acp + "/changerequest/confirm-change-request", JSON.stringify({ requestId: requestId }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    execute(requestId: string): Promise<ChangeRequest> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http.post<ChangeRequest>(acp + "/changerequest/execute-actions", JSON.stringify({ requestId: requestId }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    delete(requestId: string): Promise<string> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http.post<string>(acp + "/changerequest/delete", JSON.stringify({ requestId: requestId }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    rejectAllActions(requestId: string, actions:any): Promise<UpdateAttributeAction[] | CreateGeoObjectAction[]> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http.post<UpdateAttributeAction[] | CreateGeoObjectAction[]>(acp + "/changerequest/reject-all-actions", JSON.stringify({ requestId: requestId, actions: actions }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    approveAllActions(requestId: string, actions:any): Promise<UpdateAttributeAction[] | CreateGeoObjectAction[]> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http.post<UpdateAttributeAction[] | CreateGeoObjectAction[]>(acp + "/changerequest/approve-all-actions", JSON.stringify({ requestId: requestId, actions: actions }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    submitChangeRequest(actions: string): Promise<GeoObject> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

//        let params: HttpParams = new HttpParams();
//        params = params.set("actions", actions)

        this.eventService.start();

        return this.http.post<GeoObject>(acp + "/cgr/submitChangeRequest", { actions: actions }, { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

    deleteFile(actionId: string, fileId: string): Promise<ImportConfiguration> {

        let headers = new HttpHeaders({
            "Content-Type": "application/json"
        });

        this.eventService.start();

        return this.http
            .post<ImportConfiguration>(acp + "/changerequest/delete-file-action", JSON.stringify({ actionOid: actionId, vfOid: fileId }), { headers: headers })
            .pipe(finalize(() => {

                this.eventService.complete();

            }))
            .toPromise();

    }

}
