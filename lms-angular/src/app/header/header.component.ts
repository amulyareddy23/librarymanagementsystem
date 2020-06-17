import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  isAdmin() {
    const userDetails = JSON.parse(localStorage.getItem('userInfo'));
    if (userDetails && userDetails.userInfo.role === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  isStudent() {
    const userDetails = JSON.parse(localStorage.getItem('userInfo'));
    if (userDetails && userDetails.userInfo.role === 'student') {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.removeItem('userInfo');
    this.router.navigateByUrl('/login');
  }

}
