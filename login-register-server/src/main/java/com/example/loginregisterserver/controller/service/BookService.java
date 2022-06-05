package com.example.loginregisterserver.controller.service;

import com.example.loginregisterserver.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {

    Optional<Book> getBookById(Long id);

    Book updateBook(Book bookDetails, Long id);

    Book deleteBooks(Long id);
}
