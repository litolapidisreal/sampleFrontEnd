import { Observable } from "rxjs";
import { Product } from "../models/product";
import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { environment } from "src/environments/environment";



@Injectable ({
    providedIn: 'root'
})

export class ProductService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }
    public getProducts(token: string) : Observable<Product[] >{
        let headerValue = new HttpHeaders().set("Authorization", token);
        return this.http.get<Product[]>(`${this.apiServerUrl}/products`, {headers: headerValue})
    }

    public addProducts(product: Product, token: string) : Observable<Product> {
        let headerValue = new HttpHeaders().set("Authorization", token);
        return this.http.post<Product>(`${this.apiServerUrl}/products`, product, {headers: headerValue})
    }

    public updateProducts(product: Product, token: string) : Observable<Product> {
        let headerValue = new HttpHeaders().set("Authorization", token);
        return this.http.put<Product>(`${this.apiServerUrl}/products`, product, {headers: headerValue})
    }

    public deleteProducts(employeeId: number, token: string) {
        let headerValue = new HttpHeaders().set("Authorization", token);
        return this.http.delete<Product>(`${this.apiServerUrl}/products/${employeeId}`, {headers: headerValue})
    }

    public sampleProducts(sampleSize: number, token: string) : Observable<Product[]> {
        let headerValue = new HttpHeaders().set("Authorization", token);
        return this.http.get<Product[]>(`${this.apiServerUrl}/sampler/${sampleSize}`, {headers: headerValue})
    }
}