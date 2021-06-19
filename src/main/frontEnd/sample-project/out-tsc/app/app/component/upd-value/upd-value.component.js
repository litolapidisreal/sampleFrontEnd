import { __decorate } from "tslib";
import { Component, Input } from '@angular/core';
import { Validators, } from '@angular/forms';
let UpdValueComponent = class UpdValueComponent {
    constructor(fb, productService) {
        this.fb = fb;
        this.productService = productService;
        this.title = 'Updating Product#';
        this.idValue = 0;
        this.updateForm = fb.group({
            id: [''],
            title: ['', [Validators.required, Validators.minLength(10)]],
            description: ['', [Validators.required, Validators.minLength(25)]],
            productType: ['', Validators.required],
            price: ['', Validators.required],
            available: [true, Validators.required],
            outdated: [false, Validators.required],
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
    ngOnInit() {
        this.title = 'Updating Product#' + this.idValue;
        console.log(this.updateForm.value.id);
    }
    onSubmit() {
        console.log(this.updateForm.value);
        this.product.id = this.updateForm.value.id;
        this.product.title = this.updateForm.value.title;
        this.product.productType = this.updateForm.value.productType;
        this.product.description = this.updateForm.value.description;
        this.product.outdated = this.updateForm.value.outdated;
        this.product.available = this.updateForm.value.available;
        this.product.price = this.updateForm.value.price;
        this.product.outdated = this.updateForm.value.outdated;
        this.product.available = this.updateForm.value.available;
        console.log(this.product);
        this.productService.updateProducts(this.product).subscribe((response) => {
            alert("Success");
        }, (error) => {
            alert(error.message);
        });
    }
};
__decorate([
    Input()
], UpdValueComponent.prototype, "updateForm", void 0);
__decorate([
    Input()
], UpdValueComponent.prototype, "idValue", void 0);
UpdValueComponent = __decorate([
    Component({
        selector: 'upd-value',
        templateUrl: './upd-value.component.html',
        styleUrls: ['./upd-value.component.css'],
    })
], UpdValueComponent);
export { UpdValueComponent };
//# sourceMappingURL=upd-value.component.js.map