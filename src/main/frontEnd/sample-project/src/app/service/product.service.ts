import { Observable } from "rxjs";
import { Product } from "../models/product";
import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { environment } from "src/environments/environment";



@Injectable ({
    providedIn: 'root'
})

export class ProductService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }
    public getProducts() : Observable<Product[] >{
        return this.http.get<Product[]>(`${this.apiServerUrl}/products`)
    }

    public addProducts(product: Product) : Observable<Product> {
        return this.http.post<Product>(`${this.apiServerUrl}/products`, product)
    }

    public updateProducts(product: Product) : Observable<Product> {
        return this.http.put<Product>(`${this.apiServerUrl}/products`, product)
    }

    public deleteProducts(employeeId: number) {
        return this.http.delete<Product>(`${this.apiServerUrl}/products/${employeeId}`)
    }

    public sampleProducts(sampleSize: number) : Observable<Product[]> {
        return this.http.get<Product[]>(`${this.apiServerUrl}/sampler/${sampleSize}`)
    }
}