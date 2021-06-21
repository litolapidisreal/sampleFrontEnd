import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductService } from './service/product.service';
import { TableComponent } from './component/table/table.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InitializerComponent } from './component/initializer/initializer.component';
import { AddValueComponent } from './component/add-value/add-value.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdValueComponent } from './component/upd-value/upd-value.component';
import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './webpage/main/main.component';
import { LoginComponent } from './webpage/login/login.component';
import { NewUserComponent } from './webpage/new-user/new-user.component';
import { NewUserFormComponent } from './component/new-user-form/new-user-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    InitializerComponent,
    AddValueComponent,
    UpdValueComponent,
    MainComponent,
    LoginComponent,
    NewUserComponent,
    NewUserFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    NgbModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
