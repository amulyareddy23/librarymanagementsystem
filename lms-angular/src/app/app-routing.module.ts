import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { AddBookComponent } from './add-book/add-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { ShowUsersComponent } from './show-users/show-users.component';
import { ShowRequestsComponent } from './show-requests/show-requests.component';
import { IssuedBooksComponent } from './issued-books/issued-books.component';
import { RequestBookComponent } from './request-book/request-book.component';
import { ReturnBookComponent } from './return-book/return-book.component';
import { BookInfoComponent } from './book-info/book-info.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './authguard';
import { UpdatePasswordComponent } from './update-password/update-password.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard], data: { role: ['admin'] } },
  { path: 'addBook', component: AddBookComponent, canActivate: [AuthGuard], data: { role: ['admin'] } },
  { path: 'updateBook', component: UpdateBookComponent, canActivate: [AuthGuard], data: { role: ['admin'] } },
  { path: 'showUsers', component: ShowUsersComponent, canActivate: [AuthGuard], data: { role: ['admin'] } },
  { path: 'showRequests', component: ShowRequestsComponent, canActivate: [AuthGuard], data: { role: ['admin'] } },
  { path: 'issuedBooks', component: IssuedBooksComponent, canActivate: [AuthGuard], data: { role: ['admin'] } },
  { path: 'requestBook', component: RequestBookComponent, canActivate: [AuthGuard], data: { role: ['student'] } },
  { path: 'returnBook', component: ReturnBookComponent, canActivate: [AuthGuard], data: { role: ['student'] } },
  { path: 'booksInfo', component: BookInfoComponent, canActivate: [AuthGuard], data: { role: ['admin'] } },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'updatePassword', component:UpdatePasswordComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
