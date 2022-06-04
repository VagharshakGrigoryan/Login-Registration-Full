import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';


import { httpInterceptorProviders } from './auth/auth-interceptor';
import {BookListComponent} from "./book/book-list/book-list.component";
import {CreateBookComponent} from "./book/create-book/create-book.component";
import {UpdateBookComponent} from "./book/update-book/update-book.component";
import {BookDetailsComponent} from "./book/book-details/book-details.component";
import {AuthorListComponent} from "./author/author-list/author-list.component";
import {AuthorDetailsComponent} from "./author/author-details/author-details.component";
import {CreateAuthorComponent} from "./author/create-author/create-author.component";
import {UpdateAuthorComponent} from "./author/update-author/update-author.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    RegisterComponent,
    BookListComponent,
    CreateBookComponent,
    UpdateBookComponent,
    BookDetailsComponent,
    AuthorListComponent,
    AuthorDetailsComponent,
    CreateAuthorComponent,
    UpdateAuthorComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
