import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  public displayedColumns: string[] = ['#', 'Username', 'Product name', 'Quantity', 'Total Price', 'isShipped?', 'isSale?', "Date Created","Last Updated","isClosed", "Comments"];

  public products : Product[];
  // public updateProduct : Product;
  // public updateForm: FormGroup;
  public idValue: number = 0;
  public samplingSize : number = 0;
  constructor (private productService: ProductService, private fb: FormBuilder){
    this.products = []
    // this.updateProduct = {
    //   id: 0,
    //   title: '',
    //   productType: '',
    //   description: '',
    //   price: 0.0,
    //   available: true,
    //   outdated: false,
    // };
    // this.updateForm = fb.group({
    //   id: [''],
    //   title: ['', [Validators.required, Validators.minLength(10)]],
    //   description: ['', [Validators.required, Validators.minLength(25)]],
    //   productType: ['', Validators.required],
    //   price: ['', Validators.required],
    //   available: ['', Validators.required],
    //   outdated: ['',Validators.required],
    //   date: [null]
    // });
  }; 
  
  ngOnInit () {
    // this.getProducts();

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

  public passProduct(product: Product){
    // this.updateForm.patchValue({
    //   id: product.id,
    //   title: product.title,
    //   productType: product.productType,
    //   outdated: product.outdated,
    //   description: product.description,
    //   available: product.available,
    //   price: product.price,

    // })
    // this.idValue = product.id;
    // console.log(this.updateForm.value);

  }
}
