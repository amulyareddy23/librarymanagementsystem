import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class BookserviceService {

  constructor(private http: HttpClient) { }
  myURL = 'http://localhost:8080/librarymanagementsystemspringrest/';

  getData() {
    return this.http.get<any>(`${this.myURL}getBooksInfo`);
  }
  postData(bookbean) {
    return this.http.post<any>(`${this.myURL}addBook`, bookbean);
  }
  deleteData(bid) {
    return this.http.delete<any>(`${this.myURL}deleteBook/` + bid);
  }

  getRequestData() {
    return this.http.get<any>(`${this.myURL}showRequests`);
  }

  getUserData() {
    return this.http.get<any>(`${this.myURL}showUsers`);
  }

  getIssuedData() {
    return this.http.get<any>(`${this.myURL}showIssuedBooks`);
  }


  getBorrowedData(bean) {
    return this.http.post<any>(`${this.myURL}getBorrowedBooks`, bean);
  }

  updateData(bookbean) {
    return this.http.put<any>(`${this.myURL}updateBook`, bookbean);
  }

  requestData(bookbean) {
    return this.http.post<any>(`${this.myURL}requestBook`, bookbean);
  }

  issueData(bookbean) {
    return this.http.post<any>(`${this.myURL}issueBook`, bookbean);
  }

  returnData(bookbean) {
    return this.http.post<any>(`${this.myURL}returnBook`, bookbean);
  }

  cancelRequest(bookbean) {
    return this.http.post<any>(`${this.myURL}cancelRequest`, bookbean);
  }

  updatePassword(bean) {
    return this.http.post<any>(`${this.myURL}updatePassword`, bean);
  }
}
