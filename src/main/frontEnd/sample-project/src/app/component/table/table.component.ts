import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  
  public displayedColumns: string[] = ['#', 'Title', 'Description', 'Product Type', 'Price', 'isAvailable', 'isOutdated', "Action"];

  public products : Product[];

  public samplingSize : number = 0;
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

  public deleteData(product: Product): void {
    console.log(product);
    this.productService.deleteProducts(product.id).subscribe(
      (response ) => {
        alert("Success");
        this.getProducts();

      }, 
      (error: HttpErrorResponse) => {
          alert(error.message)
        }
      );
  }

}
