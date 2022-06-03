package com.example.loginregisterserver.service;

import com.example.loginregisterserver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    public BookService(BookRepository bookRepository) {
    }
}
