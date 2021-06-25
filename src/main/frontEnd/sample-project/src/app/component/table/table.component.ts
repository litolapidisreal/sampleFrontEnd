import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { LoginService } from 'src/app/service/login.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  public tokenValue: string = '';
  public displayedColumns: string[] = ['#', 'Title', 'Description', 'Product Type', 'Price', 'isAvailable', 'isOutdated', "Action"];

  public products: Product[];
  public updateProduct: Product;
  public updateForm: FormGroup;
  public idValue: number = 0;
  public samplingSize: number = 0;
  constructor(private productService: ProductService,
    private fb: FormBuilder,
    private router: ActivatedRoute,
    private loginService: LoginService,
    private errorRouter: Router,
    ) {
    this.products = []
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
    this.tokenValue = "";
  };

  ngOnInit() {
    this.router.paramMap.subscribe(param => {
      const token = param.get('token');
      if (token!) {
        this.tokenValue = 'Bearer ' + window.atob(token);
      }
    });
    this.authenticate();
  }
  ngAfterViewInit() {
    this.getProducts();
  }

  public getProducts(): void {
    this.productService.getProducts(this.tokenValue).subscribe(
      (response: Product[]) => {
        this.products = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  public deleteData(product: Product): void {
    console.log(product);
    this.productService.deleteProducts(product.id, this.tokenValue).subscribe(
      (response) => {
        alert("Success");
        this.getProducts();

      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  public passProduct(product: Product) {
    this.updateForm.patchValue({
      id: product.id,
      title: product.title,
      productType: product.productType,
      outdated: product.outdated,
      description: product.description,
      available: product.available,
      price: product.price,

    })
    this.idValue = product.id;
    console.log(this.updateForm.value);

  }

  public authenticate(): void {
    this.loginService.validate(this.tokenValue).subscribe(
      (responsive) => {
        console.log("Validation Passed! Proceed in transaction");
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        this.errorRouter.navigate(["/login"]);
      }
    )
  }


}
