import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-request-book',
  templateUrl: './request-book.component.html',
  styleUrls: ['./request-book.component.css']
})
export class RequestBookComponent implements OnInit {

  booksInfo;
  message;
  searchTerm;
  error;
  constructor(private bookService: BookserviceService,
    private router: Router, private route: ActivatedRoute) {
    this.getBooks();
  }

  ngOnInit(): void {
  }

  getBooks() {
    this.bookService.getData().subscribe(response => {
      console.log(response);
      this.booksInfo = response.booksInfo;
    }, error => {
      console.log(error);
    }
    );
  }

  userRequest(bookId) {
    let userDetails = JSON.parse(localStorage.getItem('userInfo'));
    let userId = userDetails.userInfo.uid;
    this.bookService.requestData({ uid: userId, bid: bookId }).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
        this.message = 'Request placed to Admin';
        setTimeout(() => {
          this.message = null;
        }, 5000);
      }
    });
  }
}
