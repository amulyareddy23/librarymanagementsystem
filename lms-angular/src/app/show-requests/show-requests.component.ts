import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-requests',
  templateUrl: './show-requests.component.html',
  styleUrls: ['./show-requests.component.css']
})
export class ShowRequestsComponent implements OnInit {

  requests;
  error;
  message: string;
  constructor(private bookService: BookserviceService,
    private router: Router) {
    this.getRequestDetails();
  }

  ngOnInit(): void {
  }

  getRequestDetails() {
    this.bookService.getRequestData().subscribe(response => {
      console.log(response);
      this.requests = response.requests;
    }, error => {
      console.log(error);
    }
    );
  }

  bookIssue(request) {
    this.bookService.issueData({ uid: request.uid, bid: request.bid }).subscribe(response => {
      console.log(response);
      if (!response.error) {
        this.message = 'Book Issued to the user';
      } else {
        this.error = 'Book is not Issued';
      }
      this.getRequestDetails();
      setTimeout(() => {
        this.message = null;
      }, 5000);
    });

  }

  rejectRequest(request) {
    this.bookService.cancelRequest({ uid: request.uid, bid: request.bid }).subscribe(response => {
      if (!response.error) {
        this.message = 'Request rejected';
      } else {
        this.error = 'Request is not rejected';
      }
      this.getRequestDetails();
      setTimeout(() => {
        this.message = null;
      }, 5000);
    })
  }

}
