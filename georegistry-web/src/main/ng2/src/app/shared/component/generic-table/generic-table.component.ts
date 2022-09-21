import { Component, OnInit, Input, Output, EventEmitter, OnDestroy, ViewChild, AfterViewInit } from "@angular/core";
import { FilterMetadata, LazyLoadEvent } from "primeng/api";
import { Table } from "primeng/table";

import { Subject } from "rxjs";
import { GenericTableColumn, GenericTableConfig, TableEvent } from "@shared/model/generic-table";
import { PageResult } from "@shared/model/core";
import { LocalizationService } from "@shared/service";

@Component({
    selector: "generic-table",
    templateUrl: "./generic-table.component.html",
    styleUrls: ["./generic-table.css"]
})
export class GenericTableComponent implements OnInit, OnDestroy, AfterViewInit {

    page: PageResult<Object> = {
        resultSet: [],
        count: 0,
        pageNumber: 1,
        pageSize: 30
    };

    @Input() cols: GenericTableColumn[] = [];

    @Input() pageConfig: any = null;

    @Input() config: GenericTableConfig;

    @Input() refresh: Subject<void>;

    @Input() initialState: LazyLoadEvent = null;

    @Output() click = new EventEmitter<TableEvent>();
    @Output() onLoadEvent = new EventEmitter<LazyLoadEvent>();

    @ViewChild("dt") dt: Table;

    first: number = 0;

    loading: boolean = true;

    booleanOptions: any = [];

    event: LazyLoadEvent = null;

    constructor(private localizationService: LocalizationService) {
        this.booleanOptions = [
            { label: "", value: null },
            { value: true, label: this.localizationService.decode("change.request.boolean.option.true") },
            { value: false, label: this.localizationService.decode("change.request.boolean.option.false") }
        ];
    }

    ngOnInit(): void {
        if (this.initialState != null) {
            this.first = this.initialState.first != null ? this.initialState.first : 0;

            if (this.initialState.multiSortMeta != null) {
                this.config.sort = this.initialState.multiSortMeta;
            }
        }

        if (this.refresh != null) {
            this.refresh.subscribe(() => {
                if (this.event != null) {
                    this.onPageChange(this.event);
                }
            });
        }

        if (this.config.baseZIndex == null) {
            this.config.baseZIndex = 0;
        }
    }

    ngAfterViewInit(): void {
        if (this.dt != null && this.initialState != null) {
            if (this.initialState.filters != null) {
                const keys = Object.keys(this.initialState.filters);

                keys.forEach(key => {
                    const metadata: FilterMetadata = this.initialState.filters[key];

                    this.dt.filter(metadata.value, key, metadata.matchMode);
                });
            }
        }
    }

    ngOnDestroy(): void {
        if (this.refresh != null) {
            this.refresh.unsubscribe();
        }
    }

    onPageChange(event: LazyLoadEvent): void {
        this.loading = true;
        this.event = event;

        setTimeout(() => {
            this.config.service.page(event, this.pageConfig).then(page => {
                this.page = page;

                this.onLoadEvent.emit(event);
            }).finally(() => {
                this.loading = false;
            });
        }, 1000);
    }

    onClick(type: string, row: Object, col: GenericTableColumn): void {
        this.click.emit({
            type: type,
            row: row,
            col: col
        });
    }

    onComplete(col: GenericTableColumn, event: LazyLoadEvent): void {
        col.onComplete();
    }

    getColumnType(row: Object, col: GenericTableColumn): string {
        if (col.columnType != null) {
            return col.columnType(row);
        }

        return col.type;
    }

    handleFilter(event: LazyLoadEvent): void {
        this.onLoadEvent.emit(event);
    }

}
