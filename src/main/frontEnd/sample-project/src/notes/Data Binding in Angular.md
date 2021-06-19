#Data Binding
##**Property Binding**   
###**Static Property Binding**   
> Makes an Generic Component <img> consider <src="sample text"> as possibly changing value
> HTML Catching Static Value from TS

    <p> {{valueInTsConsideredAsStringAndConstant}} </p>
> HTML Setting Static Value "valueInTsConsideredAsStringAndConstant" to component property class

    <p class="valueInTsConsideredAsStringAndConstant"> </p>

### **Dynamic Property Binding**
* Makes an Generic Component <img> consider <src="sample text"> as possibly changing value

> HTML

    <img [src]="itemImageUrl">
    
> TS File
    
    itemImageUrl = '../assets/phone.png';
* Can also be used for passing value to "Created" Component 

> HTML for Main Component 

    <sample-component [srcDetail]="itemImageUrl">
    
> TS File from main-component
    
    itemImageUrl = '../assets/phone.png';
> TS File from sample-component
    
    @Input() srcDetail = '';
# **Event Binding**   
## **Basic Event Binding**
| Event | Description |
|    sample|    |
>HTML

    <button (click)="delete()">Save</button>
>TS 
    
    delete() {
      this.deleteRequest.emit(this.item);
      this.displayNone = this.displayNone ? '' : 'none';
      this.lineThrough = this.lineThrough ? '' : 'line-through';
    }
        
## **EventEmitter Event Binding**
> Html Main Component
 
    <app-item-detail (deleteRequest)="deleteItem($event)" [item]="currentItem"></app-item-detail>
> TS Sub Component

    // This component makes a request but it can't actually delete a hero.
    @Output() deleteRequest = new EventEmitter<Item>();
    
    delete() {
      this.deleteRequest.emit(this.item);
      this.displayNone = this.displayNone ? '' : 'none';
      this.lineThrough = this.lineThrough ? '' : 'line-through';
    }
# **Pipe**
> Static Property binding that can be used for formatting/converting data into html

    {{ exp | myPipe }}
    {{ variableWithValue | formatter }}

>   Create your pipe

    ng generate pipe nameOfPipe      

