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
