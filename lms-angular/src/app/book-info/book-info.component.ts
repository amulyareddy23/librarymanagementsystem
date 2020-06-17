import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-info',
  templateUrl: './book-info.component.html',
  styleUrls: ['./book-info.component.css']
})
export class BookInfoComponent implements OnInit {

  booksInfo;
  message: string;
  error: string;
  search;
  constructor(private bookService: BookserviceService, private router: Router,
    private route: Router) {
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

  deleteBook(bid: number) {

    this.bookService.deleteData(bid).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.message = 'Failed to delete the book';
      } else {
        this.message = 'book deleted successfully';
      }
      this.getBooks();
      setTimeout(() => {
        this.message = null;
      }, 5000);
    });
    this.router.navigateByUrl('/booksInfo');
  }

  selectBook(book) {
    this.route.navigate(['/updateBook'], { queryParams: book });
  }

}
