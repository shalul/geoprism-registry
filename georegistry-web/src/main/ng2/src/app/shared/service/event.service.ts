import { Injectable } from "@angular/core";
import { HttpErrorResponse } from "@angular/common/http";

import { GeoRegistryConfiguration } from "@core/model/registry"; declare let registry: GeoRegistryConfiguration;

export interface IEventListener {
    start(): void;
    complete(): void;
}

@Injectable()
export class EventService {

    private listeners: IEventListener[] = [];

    public registerListener(listener: IEventListener): void {
        this.listeners.push(listener);
    }

    public deregisterListener(listener: IEventListener): boolean {
        let indexOfItem = this.listeners.indexOf(listener);

        if (indexOfItem === -1) {
            return false;
        }

        this.listeners.splice(indexOfItem, 1);

        return true;
    }

    public start(): void {
        for (const listener of this.listeners) {
            listener.start();
        }
    }

    public complete(): void {
        for (const listener of this.listeners) {
            listener.complete();
        }
    }
}
