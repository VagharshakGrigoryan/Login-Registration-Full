package com.example.loginregisterserver.controller;

import com.example.loginregisterserver.service.BookService;
import com.example.loginregisterserver.model.Book;
import com.example.loginregisterserver.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;
/**
 * @author Vagharhak Grigoryan
 */

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping( "/books" )
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updateBook = bookService.updateBook(bookDetails, id);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.deleteBooks(id);
        return ResponseEntity.ok(book);
    }
}
