import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Book} from "../../model/book";
import {Author} from "../../model/Author";
import {BookService} from "../../services/bookService/book.service";
@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books!: Book[];
  author!:Author;

  constructor(private bookService: BookService,
    private router: Router
             ) { }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks(){
    this.bookService.getBookList().subscribe(data => {
      this.books = data;
    });
  }

  bookDetails(id: number){
    this.router.navigate(['book-details', id]).then(r => this.getBooks());
  }

  updateBook(id: number){
    this.router.navigate(['update-book', id]).then(r => this.getBooks());
  }

  deleteBook(id: number) {
    this.bookService.deleteBook(id).subscribe(data => {
      console.log("user deleted" + data);
      this.getBooks();
    },(err)=>{
      console.log("unable to deleted user" + err)
      }
    )

  }

}
