import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from './models/product';

import { ProductService } from './service/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'sample-project';
  public products : Product[];
  constructor (private productService: ProductService){
    this.products = []
  }; 
  
  ngOnInit () {
  }
}
