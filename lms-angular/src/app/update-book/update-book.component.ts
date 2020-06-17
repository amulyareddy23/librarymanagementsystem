import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookserviceService } from '../bookservice.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  bookToBeUpdated;
  error: string;

  constructor(private router: ActivatedRoute,
    private bookService: BookserviceService,
    private route: Router) {
    this.router.queryParams.subscribe(data => {
      console.log('Book to be updated', data);
      this.bookToBeUpdated = data;
    }
    );
  }

  ngOnInit(): void {
  }

  editBook(form: NgForm) {
    this.bookService.updateData(form.value).subscribe(response => {
      console.log('edit form value', form.value);
      console.log(response);
      form.reset();
      if (response.error) {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
        this.route.navigateByUrl('/booksInfo');
      }
    });
  }

}
