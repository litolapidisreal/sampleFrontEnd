import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthenticationModel } from '../models/authentication-model';
import { NewUser } from '../models/new-user';
import { Userlogin } from '../models/userlogin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiServerUrl = environment.apiDevUrl;
  constructor(private http: HttpClient) { }

  public login(userlogin: Userlogin) : Observable<AuthenticationModel>{
    return this.http.post<AuthenticationModel>(`${this.apiServerUrl}authenticate`, userlogin)
  }
  public addUser(newUser: NewUser) {
    return this.http.post(`${this.apiServerUrl}/addUser`, newUser)
  }

  public validate() {
    return this.http.get(`${this.apiServerUrl}/validate`)
  }

}
