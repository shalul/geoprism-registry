
import { Component, ElementRef, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'simple-edit-control',
  templateUrl: './simple-edit-control.component.html',
})
export class SimpleEditControl {
  elRef: ElementRef
  
  @Input() visible:boolean = true;
  
  @Output() editEmitter = new EventEmitter<void>();
  
  constructor(elRef: ElementRef) {
    this.elRef = elRef;
  }

  onAdd(map): any {
    this.visible = true;
    return this.elRef.nativeElement;
  }
  
  onRemove(map): void {
    this.elRef.nativeElement.remove();
  }
  
  onClick(): void {
    this.editEmitter.emit();
  }
}
