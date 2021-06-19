import { __decorate } from "tslib";
import { Component, EventEmitter, } from '@angular/core';
let InitializerComponent = class InitializerComponent {
    constructor(productService) {
        this.productService = productService;
        this.sampleSize = 0;
        this.showValue = '0 values to be added!';
        this.sampleSizeEvent = new EventEmitter();
        this.products = [];
    }
    click(value) {
        console.log('Value = ' + parseInt(value));
        this.getSampleProducts(parseInt(value));
        this.sampleSizeEvent.emit(this.products);
    }
    onType(value) {
        console.log('Value = ' + parseInt(value));
        if (value != null)
            this.showValue = value + ' values to be added!';
    }
    ngOnInit() { }
    getSampleProducts(sampleSize) {
        this.productService.sampleProducts(sampleSize).subscribe((response) => {
            this.products = response;
            console.log(response.length);
        }, (error) => {
            alert(error.message);
        });
        window.location.reload();
    }
};
InitializerComponent = __decorate([
    Component({
        selector: 'app-initializer',
        templateUrl: './initializer.component.html',
        styleUrls: ['./initializer.component.css'],
        inputs: [],
        outputs: [`sampleSizeEvent`],
    })
], InitializerComponent);
export { InitializerComponent };
//# sourceMappingURL=initializer.component.js.map