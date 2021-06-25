import { HttpErrorResponse } from '@angular/common/http';
import {
  Component,
  ElementRef,
  EventEmitter,
  Input,
  OnInit,
  ViewChild,
} from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-initializer',
  templateUrl: './initializer.component.html',
  styleUrls: ['./initializer.component.css'],
  inputs: [],
  outputs: [`sampleSizeEvent`],
})
export class InitializerComponent implements OnInit {
  public products: Product[];
  public sampleSize: number = 0;
  public showValue: string = '0 values to be added!';
  @Input() tokenValue: string;


  public sampleSizeEvent = new EventEmitter<Product[]>();
  public click(value: string): void {
    console.log('Value = ' + parseInt(value));
    this.getSampleProducts(parseInt(value));
    this.sampleSizeEvent.emit(this.products);
  }
  public onType(value: string): void {
    console.log('Value = ' + parseInt(value));
    if (value != null) this.showValue = value + ' values to be added!';
  }

  constructor(private productService: ProductService) {
    this.tokenValue = "";
    this.products = [];
  }

  ngOnInit() {}

  public getSampleProducts(sampleSize: number): void {
    this.productService.sampleProducts(sampleSize, this.tokenValue).subscribe(
      (response: Product[]) => {
        this.products = response;
        console.log(response.length);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    window.location.reload();
  }
}
