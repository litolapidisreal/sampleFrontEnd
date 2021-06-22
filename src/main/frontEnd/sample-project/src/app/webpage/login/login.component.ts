import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';
import { environment } from 'src/environments/environment';
import { Userlogin } from 'src/app/models/userlogin';
import { AuthenticationModel } from 'src/app/models/authentication-model';

import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  feServerUrl = environment.feDevUrl + '/signUp';
  loginForm: FormGroup;
  loginUser: Userlogin;
  constructor(private fb: FormBuilder,
    private loginService: LoginService) {
    this.loginForm = fb.group({
      inputEmail: ['', Validators.required],
      inputPassword: ['', Validators.required]
    },
      this.loginUser = {
        username: '',
        password: ''
      })
  };



  ngOnInit(): void {
    console.log("hello there")
  }

  public authenticate(): void {
    console.log(this.loginForm.value);
    this.loginUser.password = this.loginForm.value.inputPassword;
    this.loginUser.username = this.loginForm.value.inputEmail;
    this.loginService.login(this.loginUser)
    .subscribe(
      (response : AuthenticationModel)=> {
        console.log(response.message)
        alert("Success");
        window.location.replace(this.feServerUrl);
      }, 
      (error: HttpErrorResponse) => {
          alert(error.message)
          this.loginForm.reset;
        }
      );
  }

}
