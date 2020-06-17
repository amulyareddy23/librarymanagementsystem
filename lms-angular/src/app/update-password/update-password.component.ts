import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookserviceService } from '../bookservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.css']
})
export class UpdatePasswordComponent implements OnInit {

  error;
  message;
  constructor(private bookService : BookserviceService,private route : Router ) { 
    
  }

  ngOnInit(): void {
  }

  resetPassword(form :NgForm){
    this.bookService.updatePassword(form.value).subscribe(response =>{
      console.log('edit form value', form.value);
      console.log(response);
      form.reset();
      if (response.error) {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
        this.message = response.message;
        setTimeout(() => {
          this.message = null;
        }, 5000);
        this.route.navigateByUrl('/login');
      }
    })
  }

}
