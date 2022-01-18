import { Component, Input, Output, EventEmitter, ChangeDetectorRef, OnChanges, SimpleChanges } from "@angular/core";
import {
    trigger,
    state,
    style,
    animate,
    transition
} from "@angular/animations";

import { GeoObjectType, AttributeType } from "@registry/model/registry";
import { ClassificationTypeService } from "@registry/service/classification-type.service";
import { ClassificationType } from "@registry/model/classification-type";

@Component({
    selector: "attribute-input",
    templateUrl: "./attribute-input.component.html",
    styleUrls: ["./attribute-input.css"],
    animations: [
        trigger("toggleInputs", [
            state("none, void",
                style({ opacity: 0 })
            ),
            state("show",
                style({ opacity: 1 })
            ),
            transition("none => show", animate("300ms"))
            // transition('show => none', animate('100ms'))
        ])
    ]
})
export class AttributeInputComponent implements OnChanges {

    @Input() isNew: boolean = false;
    @Input() excludeDescription: boolean = false;
    @Input() type: string = null;
    @Input() geoObjectType: GeoObjectType;
    @Input() attribute: AttributeType;
    @Output() attributeChange = new EventEmitter<AttributeType>();
    message: string = null;

    state: string = "none";
    classifications: ClassificationType[] = [];

    constructor(private service: ClassificationTypeService, private cdr: ChangeDetectorRef) { }

    ngOnInit(): void {
    }

    ngAfterViewInit() {
        this.state = "show";
        this.cdr.detectChanges();
    }

    ngOnChanges(changes: SimpleChanges): void {
        if (changes.type != null && this.attribute.type === "classification") {
            this.service.page({}).then((page) => {
                this.classifications = page.resultSet;
            });
        }
    }

    ngOnDestroy() {

    }

    handleOnSubmit(): void {

    }

    toggleIsUnique(): void {
        this.attribute.unique = !this.attribute.unique;
    }

    animate(): void {
        this.state = "none";
    }

    onAnimationDone(event: AnimationEvent): void {
        this.state = "show";
    }

    isValid(): boolean {
        if (this.attribute.code) {
            // if code has a space
            if (this.attribute.code.indexOf(" ") !== -1) {
                return false;
            }

            if (this.attribute.label.localeValues[0].value.length === 0) {
                return false;
            }

            if (this.type === "float" && (this.attribute.precision == null || this.attribute.precision.toString() === "")) {
                return false;
            }

            if (this.type === "float" && (this.attribute.scale == null || this.attribute.scale.toString() === "")) {
                return false;
            }

            return true;
        }

        return false;
    }

}
