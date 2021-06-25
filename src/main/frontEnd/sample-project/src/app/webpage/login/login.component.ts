import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';
import { environment } from 'src/environments/environment';
import { Userlogin } from 'src/app/models/userlogin';
import { AuthenticationModel } from 'src/app/models/authentication-model';
import { Router} from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  feServerUrl = environment.feDevUrl + '/home';
  loginForm: FormGroup;
  loginUser: Userlogin;
  constructor(private fb: FormBuilder,
    private loginService: LoginService,
    private router: Router) {
    this.loginForm = fb.group({
      inputEmail: ['', [Validators.required, Validators.minLength(5)]],
      inputPassword: ['', [Validators.required, Validators.minLength(8)]]
    }),
      this.loginUser = {
        username: '',
        password: ''
      }
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
        this.loginService.validate('Bearer '+ response.message).subscribe(
          (responsive)=> {
            alert("Success");
            this.router.navigate(["/home", window.btoa(response.message)]);
          },
          (error: HttpErrorResponse) =>{
            alert(error.message)
            this.loginForm.reset;  
            window.location.reload();

          }
        )
      }, 
      (error: HttpErrorResponse) => {
          alert(error.message)
          window.location.reload();

        }
      );
  }

}
