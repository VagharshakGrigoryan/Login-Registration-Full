package com.example.loginregisterserver.service.impl;

import com.example.loginregisterserver.service.BookService;
import com.example.loginregisterserver.exception.ResourceNotFoundException;
import com.example.loginregisterserver.model.Book;
import com.example.loginregisterserver.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));
        return bookRepository.findById(book.getId());
    }


    @Override
    public Book updateBook(Book bookDetails, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));

        book.setTitle(bookDetails.getTitle());
        book.setLanguage(bookDetails.getLanguage());
        book.setPrice(bookDetails.getPrice());
        book.setDescription(bookDetails.getDescription());
        return bookRepository.save(book);
    }

    @Override
    public Book deleteBooks(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));

        bookRepository.delete(book);
        return book;
    }
}
