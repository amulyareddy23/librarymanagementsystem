import { Component, OnInit } from '@angular/core';

import { BookserviceService } from '../bookservice.service';


@Component({
  selector: 'app-return-book',
  templateUrl: './return-book.component.html',
  styleUrls: ['./return-book.component.css']
})
export class ReturnBookComponent implements OnInit {

  constructor(private bookService: BookserviceService) {
    this.getBooks();
  }

  ngOnInit(): void {
  }
  message;
  borrowedBooks;
  error;

  getBooks() {
    let userDetails = JSON.parse(localStorage.getItem('userInfo'));
    this.bookService.getBorrowedData({ uid: userDetails.userInfo.uid }).subscribe(response => {
      console.log(response);
      this.borrowedBooks = response.borrowedBooks;
    }, error => {
      console.log(error);
    }
    );
  }

  bookReturn(book) {
    this.bookService.returnData({ bid: book.bid, uid: book.uid }).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.error = 'Book is not Returned';
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
        this.message = 'Book returned to the library';
      }
      setTimeout(() => {
        this.message = null;
      }, 5000);
    });

  }
}
