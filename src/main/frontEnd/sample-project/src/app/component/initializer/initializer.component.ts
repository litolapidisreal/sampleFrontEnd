import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-initializer',
  templateUrl: './initializer.component.html',
  styleUrls: ['./initializer.component.css']
})
export class InitializerComponent implements OnInit {
  public products : Product[];
  constructor (private productService: ProductService){
    this.products = []
  }; 
  
  ngOnInit () {
    this.getProducts();
  }
  public getProducts(): void {
    this.productService.getProducts().subscribe(
    (response : Product[]) => {
      this.products = response;
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

}
