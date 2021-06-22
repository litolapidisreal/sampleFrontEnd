import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbCalendar, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { NgbDateStructAdapter } from '@ng-bootstrap/ng-bootstrap/datepicker/adapters/ngb-date-adapter';

@Component({
  selector: 'app-new-user-form',
  templateUrl: './new-user-form.component.html',
  styleUrls: ['./new-user-form.component.css']
})
export class NewUserFormComponent implements OnInit {
  userInfoForm: FormGroup;
  constructor( private fb : FormBuilder) {
    this.userInfoForm = fb.group({
      inputFirstName:['',Validators.required],
      inputMiddleName:['',Validators.required],
      inputLastName:['',Validators.required],
      inputUserName:['',Validators.required],
      inputEmail:['',Validators.required],
      inputPassword:['',Validators.required],
      inputGender:['',Validators.required],
      inputUserType:['',Validators.required],
      inputMobile:['',Validators.required],
      inputMonth:['',Validators.required],
      inputDay:['',Validators.required],
      inputYear:['',Validators.required],
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

   }

  ngOnInit(): void {
    
  }

}
