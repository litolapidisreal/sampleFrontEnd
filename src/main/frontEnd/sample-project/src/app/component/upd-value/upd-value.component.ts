import { HttpErrorResponse } from '@angular/common/http';
import { templateJitUrl } from '@angular/compiler';
import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'upd-value',
  templateUrl: './upd-value.component.html',
  styleUrls: ['./upd-value.component.css'],
})
export class UpdValueComponent implements OnInit {
  title: string = 'Updating Product#';
  product: Product
  @Input() updateForm: FormGroup;
  @Input() idValue: number = 0;


  constructor(private fb: FormBuilder, private productService: ProductService) {
    this.updateForm = fb.group({
      id: [''],
      title: ['', [Validators.required, Validators.minLength(10)]],
      description: ['', [Validators.required, Validators.minLength(25)]],
      productType: ['', Validators.required],
      price: ['', Validators.required],
      available: [true, Validators.required],
      outdated: [false,Validators.required],
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

  ngOnInit() : void {
    this.title = 'Updating Product#' + this.idValue;
    console.log(this.updateForm.value.id)
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
    this.productService.updateProducts(this.product).subscribe(
      (response) => {
        alert("Success");
      },
      (error: HttpErrorResponse) => {
          alert(error.message)
        }
      );
  }
}
