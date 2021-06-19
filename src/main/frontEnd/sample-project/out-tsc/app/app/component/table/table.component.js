import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { Validators } from '@angular/forms';
let TableComponent = class TableComponent {
    constructor(productService, fb) {
        this.productService = productService;
        this.fb = fb;
        this.displayedColumns = ['#', 'Title', 'Description', 'Product Type', 'Price', 'isAvailable', 'isOutdated', "Action"];
        this.idValue = 0;
        this.samplingSize = 0;
        this.products = [];
        this.updateProduct = {
            id: 0,
            title: '',
            productType: '',
            description: '',
            price: 0.0,
            available: true,
            outdated: false,
        };
        this.updateForm = fb.group({
            id: [''],
            title: ['', [Validators.required, Validators.minLength(10)]],
            description: ['', [Validators.required, Validators.minLength(25)]],
            productType: ['', Validators.required],
            price: ['', Validators.required],
            available: ['', Validators.required],
            outdated: ['', Validators.required],
        });
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
    deleteData(product) {
        console.log(product);
        this.productService.deleteProducts(product.id).subscribe((response) => {
            alert("Success");
            this.getProducts();
        }, (error) => {
            alert(error.message);
        });
    }
    passProduct(product) {
        this.updateForm.patchValue({
            id: product.id,
            title: product.title,
            productType: product.productType,
            outdated: product.outdated,
            description: product.description,
            available: product.available,
            price: product.price,
        });
        this.idValue = product.id;
        console.log(this.updateForm.value);
    }
};
TableComponent = __decorate([
    Component({
        selector: 'app-table',
        templateUrl: './table.component.html',
        styleUrls: ['./table.component.css']
    })
], TableComponent);
export { TableComponent };
//# sourceMappingURL=table.component.js.map