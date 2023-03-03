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

import { TestBed, ComponentFixture, async } from "@angular/core/testing";
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NO_ERRORS_SCHEMA } from "@angular/core";
import { ModalModule, BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

import { ErrorModalComponent } from "@shared/component/modals/error-modal.component";
import { LocalizationService } from "@shared/service/localization.service";

describe("ErrorModalComponent", () => {
	let component: ErrorModalComponent;
	let fixture: ComponentFixture<ErrorModalComponent>;
	let mockService: LocalizationService;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [ErrorModalComponent],
			schemas: [NO_ERRORS_SCHEMA],
			imports: [
				HttpClientTestingModule,
				ModalModule.forRoot()
			],
			providers: [
				BsModalService,
				BsModalRef,
				LocalizationService
			]
		}).compileComponents();
	}));

	beforeEach(() => {
		// mock response
		mockService = TestBed.inject(LocalizationService);
		mockService.decode = jasmine.createSpy().and.returnValue('Test Message');

		// initialize component
		fixture = TestBed.createComponent(ErrorModalComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});

	it(`should have a title 'Test Message'`, async(() => {
		expect(component.message).toEqual('Test Message');
	}));
});
