import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {BookService} from "../../services/bookService/book.service";
import {Book} from "../../model/book";

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();
  constructor(private bookService: BookService,
              private router: Router) { }

  ngOnInit(): void {
  }

  saveBook(){
    this.bookService.createBook(this.book).subscribe( data =>{
      console.log(data);
      this.goToBookList();
    },
    error => console.log(error));
  }

  goToBookList(){
    this.router.navigate(['/books']).then(r => this.book);
  }
  onSubmit(){
    console.log(this.book);
    this.saveBook();
  }
}
