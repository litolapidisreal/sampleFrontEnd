import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { Validators } from '@angular/forms';
let AddValueComponent = class AddValueComponent {
    constructor(fb, productService) {
        this.fb = fb;
        this.productService = productService;
        this.productForm = fb.group({
            title: ['', [Validators.required, Validators.minLength(10)]],
            description: ['', [Validators.required, Validators.minLength(25)]],
            productType: ['', Validators.required],
            price: ['', Validators.required],
            available: ['', Validators.required],
            outdated: [!Validators.requiredTrue],
        });
        this.product = {
            id: 0,
            title: '',
            productType: '',
            description: '',
            price: 0.0,
            available: true,
            outdated: false,
        };
    }
    ngOnInit() { }
    onSubmit() {
        console.log(this.productForm.value);
        this.product.title = this.productForm.value.title;
        this.product.productType = this.productForm.value.productType;
        this.product.description = this.productForm.value.description;
        this.product.outdated = this.productForm.value.outdated;
        this.product.available = this.productForm.value.available;
        this.product.price = this.productForm.value.price;
        console.log(this.product);
        this.productService.addProducts(this.product).subscribe((response) => {
            alert("Success");
        }, (error) => {
            alert(error.message);
        });
        window.location.reload();
    }
};
AddValueComponent = __decorate([
    Component({
        selector: 'app-add-value',
        templateUrl: './add-value.component.html',
        styleUrls: ['./add-value.component.css'],
    })
], AddValueComponent);
export { AddValueComponent };
//# sourceMappingURL=add-value.component.js.map