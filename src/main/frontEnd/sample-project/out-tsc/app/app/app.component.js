import { __decorate } from "tslib";
import { Component } from '@angular/core';
let AppComponent = class AppComponent {
    constructor(productService) {
        this.productService = productService;
        this.title = 'sample-project';
        this.products = [];
    }
    ;
    ngOnInit() {
        this.getProducts();
    }
    getProducts() {
        this.productService.getProducts().subscribe((response) => {
            this.products = response;
        }, (error) => {
            alert(error.message);
        });
    }
};
AppComponent = __decorate([
    Component({
        selector: 'app-root',
        templateUrl: './app.component.html',
        styleUrls: ['./app.component.css']
    })
], AppComponent);
export { AppComponent };
//# sourceMappingURL=app.component.js.map