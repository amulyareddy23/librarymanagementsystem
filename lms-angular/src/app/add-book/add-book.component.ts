import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookserviceService } from '../bookservice.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  message: string;
  error : string;
  constructor(private bookService: BookserviceService,
    private route: Router,
    private router: ActivatedRoute) { }

  ngOnInit(): void {
  }

  postBook(form: NgForm) {
    this.bookService.postData(form.value).subscribe(response => {
      console.log(response);
      form.reset();
      if (!response.error) {
        this.message = 'Book added successfully';
        setTimeout(() => {
          this.message = null;
        }, 5000);
        this.route.navigateByUrl('/booksInfo');
      } 
    }, error => {
      console.log(error);
    }
    );
  }

}
