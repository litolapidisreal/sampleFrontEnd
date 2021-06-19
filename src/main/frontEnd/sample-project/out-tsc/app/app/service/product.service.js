import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
import { environment } from "src/environments/environment";
let ProductService = class ProductService {
    constructor(http) {
        this.http = http;
        this.apiServerUrl = environment.apiBaseUrl;
    }
    getProducts() {
        return this.http.get(`${this.apiServerUrl}/products`);
    }
    addProducts(product) {
        return this.http.post(`${this.apiServerUrl}/products`, product);
    }
    updateProducts(product) {
        return this.http.put(`${this.apiServerUrl}/products`, product);
    }
    deleteProducts(employeeId) {
        return this.http.delete(`${this.apiServerUrl}/products/${employeeId}`);
    }
    sampleProducts(sampleSize) {
        return this.http.get(`${this.apiServerUrl}/sampler/${sampleSize}`);
    }
};
ProductService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], ProductService);
export { ProductService };
//# sourceMappingURL=product.service.js.map