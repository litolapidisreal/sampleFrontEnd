import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { NewUser } from 'src/app/models/new-user';
import { LoginService } from 'src/app/service/login.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-new-user-form',
  templateUrl: './new-user-form.component.html',
  styleUrls: ['./new-user-form.component.css']
})
export class NewUserFormComponent implements OnInit{
  private feDevUrl = environment.feDevUrl;
  public opts = [
    { key: "", value: Array(0).fill(0).map((x,i)=>i+1) },
    { key: "JAN", value: Array(31).fill(0).map((x,i)=>i+1) },
    { key: "FEB", value: Array(28).fill(0).map((x,i)=>i+1) },
    { key: "MAR", value: Array(31).fill(0).map((x,i)=>i+1) },
    { key: "APR", value: Array(30).fill(0).map((x,i)=>i+1) },
    { key: "MAY", value: Array(31).fill(0).map((x,i)=>i+1) },
    { key: "JUN", value: Array(31).fill(0).map((x,i)=>i+1) },
    { key: "JUL", value: Array(30).fill(0).map((x,i)=>i+1) },
    { key: "AUG", value: Array(31).fill(0).map((x,i)=>i+1) },
    { key: "SEP", value: Array(30).fill(0).map((x,i)=>i+1) },
    { key: "OCT", value: Array(31).fill(0).map((x,i)=>i+1) },
    { key: "NOV", value: Array(30).fill(0).map((x,i)=>i+1) },
    { key: "DEC", value: Array(31).fill(0).map((x,i)=>i+1) }

  ];

  userInfoForm: FormGroup;
  newUser: NewUser;
  newDate: Date;
  dateString = '1968-Dec-29' ;
  numberDays: number[];
  constructor( private fb : FormBuilder,
    private loginService: LoginService) {
    this.userInfoForm = fb.group({
      inputFirstName:['',Validators.required],
      inputMiddleName:'',
      inputLastName:['',Validators.required],
      inputUserName:['',[Validators.required, Validators.minLength(5),
        Validators.pattern("^([A-Za-z0-9]+)$")]],
      inputEmail:['',
      [Validators.required, 
        Validators.pattern("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")]],
      inputPassword:['',
      [Validators.required, 
        Validators.minLength(8),
         Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{8,}$")]],
      inputGender:['',Validators.required],
      inputUserType:['',Validators.required],
      inputMobile:['',[Validators.required, Validators.pattern("^09[0-9]{9}$")]],
      inputMonth:['',Validators.required],
      inputDay:['',Validators.required],
      inputYear:['',[Validators.required, Validators.min(1920), Validators.maxLength(4)]],
      inputAddress1:['',Validators.required],
      inputAddress2:['',Validators.required],
      inputProvince:['',Validators.required],
      inputCity:['',Validators.required],
      inputZip:['',Validators.required],
      gridCheck:''
      // inputBusAddress1: '',
      // inputBusAddress2: '',
      // inputBusCity: '',
      // inputBusState: '',
      // inputBusZip: ''
    });
    this.newUser ={
      firstName: '',
      middleName: '',
      lastName: '',
      email: '',
      passWord: '',
      userName: '',
      gender: '',
      userType: '',
      birthDate: new Date(),
      mobileNo: '',
      addressId: 1
    },
    this.newDate = new Date(Date.parse(this.dateString));
    this.numberDays = Array(31).fill(0).map((x,i)=>i+1);

   }

  ngOnInit(): void {
    this.newDate = new Date(Date.parse(this.dateString));
  }

  public createArray(valueNum: number){
    return this.numberDays = Array(valueNum).fill(0).map((x,i)=>i+1);

  }
  createUser() {
    console.log(this.userInfoForm.value);
    this.newUser.firstName = this.userInfoForm.value.inputFirstName;
    this.newUser.middleName = this.userInfoForm.value.inputMiddleName;
    this.newUser.lastName = this.userInfoForm.value.inputLastName;
    this.newUser.email = this.userInfoForm.value.inputEmail;
    this.newUser.passWord = this.userInfoForm.value.inputPassword;
    this.newUser.userName = this.userInfoForm.value.inputUserName;
    this.newUser.gender = this.userInfoForm.value.inputGender;
    this.newUser.userType = this.userInfoForm.value.inputUserType;
    this.newUser.birthDate = new Date(Date.parse(
      this.userInfoForm.value.inputYear + '-' +
      this.userInfoForm.value.inputMonth + '-' +
      this.userInfoForm.value.inputDay));
    this.newUser.mobileNo = this.userInfoForm.value.inputMobile;
    this.newUser.addressId = 1;

    console.log(this.newUser);
    this.loginService.addUser(this.newUser).subscribe(
      (response) => {
        alert("Success");
        window.location.replace(`${this.feDevUrl}login`);
      }, 
      (error: HttpErrorResponse) => {
          alert(error.message)
        }
      );
    window.location.reload();  
  }

}
