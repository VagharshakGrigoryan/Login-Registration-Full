import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AuthorService} from "../../services/authorService/author.service";
import {Author} from "../../model/Author";

@Component({
  selector: 'app-author-details',
  templateUrl: './author-details.component.html',
  styleUrls: ['./author-details.component.css']
})
export class AuthorDetailsComponent implements OnInit {

  id: number
  author: Author

  constructor(private route: ActivatedRoute, private authorService: AuthorService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.author = new Author();
    this.authorService.getAuthorById(this.id).subscribe(data => {
      this.author = data;
    });
  }}
