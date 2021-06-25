import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-add-value',
  templateUrl: './add-value.component.html',
  styleUrls: ['./add-value.component.css'],
})
export class AddValueComponent implements OnInit {
  product: Product;
  productForm: FormGroup;
  @Input() tokenValue: string;


  constructor(private fb: FormBuilder,
    private productService: ProductService) {
    this.tokenValue = "";
    this.productForm = fb.group({
      title: ['',[Validators.required, Validators.minLength(10)]],
      description:  ['',[Validators.required, Validators.minLength(25)]],
      productType:  ['',Validators.required],
      price: ['',Validators.required],
      available: ['',Validators.required],
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

  ngOnInit(): void {}

  onSubmit() {
    console.log(this.productForm.value);
    this.product.title = this.productForm.value.title;
    this.product.productType = this.productForm.value.productType;
    this.product.description = this.productForm.value.description;
    this.product.outdated = this.productForm.value.outdated;
    this.product.available = this.productForm.value.available;
    this.product.price = this.productForm.value.price;
    console.log(this.product);
    this.productService.addProducts(this.product, this.tokenValue).subscribe(
      (response) => {
        alert("Success");
      }, 
      (error: HttpErrorResponse) => {
          alert(error.message)
        }
      );
    window.location.reload();  
  }

}
