import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  
  myURL='http://localhost:8080/librarymanagementsystemspringrest/';
  constructor(private http: HttpClient) { }

  register(userInfo){
    return this.http.post<any>(`${this.myURL}addUser`,userInfo);
  }

  login(userInfo){
    return this.http.post<any>(`${this.myURL}login`,userInfo);
  }
}
