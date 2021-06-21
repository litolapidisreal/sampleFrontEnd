import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { MainComponent } from './webpage/main/main.component';
import { LoginComponent } from './webpage/login/login.component';
import { NewUserComponent } from './webpage/new-user/new-user.component';
import { NewUserFormComponent } from './component/new-user-form/new-user-form.component';


const routes: Routes = [
  { path: '', component: AppComponent},
  { path: 'home', component: MainComponent},
  { path: 'login', component: LoginComponent},
  { path: 'signUp', component: NewUserComponent},
  { path: 'display', component: NewUserFormComponent}

];

@NgModule({
  declarations: [],
  imports: [
    CommonModule, 
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
