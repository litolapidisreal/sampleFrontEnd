import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductService } from './service/product.service';
import { TableComponent } from './component/table/table.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InitializerComponent } from './component/initializer/initializer.component';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    InitializerComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, BrowserAnimationsModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
