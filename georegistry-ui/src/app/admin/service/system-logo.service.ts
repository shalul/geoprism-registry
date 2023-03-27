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

import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { finalize } from 'rxjs/operators';

import { EventService } from '@shared/service'

import { SystemLogo } from '@admin/model/system-logo';

import { environment } from 'src/environments/environment';

@Injectable()
export class SystemLogoService {

	constructor(private http: HttpClient, private eventService: EventService) { }

	getIcons(): Promise<{ icons: SystemLogo[] }> {
		this.eventService.start();

		return this.http
			.get<{ icons: SystemLogo[] }>(environment.apiUrl + '/api/asset/get-all')
			.pipe(finalize(() => {
				this.eventService.complete();
			}))
			.toPromise();
	}

	remove(oid: string): Promise<void> {

		let headers = new HttpHeaders({
			'Content-Type': 'application/json'
		});

		this.eventService.start();

		return this.http
			.post<void>(environment.apiUrl + '/api/asset/remove', JSON.stringify({ oid: oid }), { headers: headers })
			.pipe(finalize(() => {
				this.eventService.complete();
			}))
			.toPromise();
	}
}
