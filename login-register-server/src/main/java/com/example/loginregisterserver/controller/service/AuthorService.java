package com.example.loginregisterserver.controller.service;

import com.example.loginregisterserver.model.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuthorService {

    Optional<Author> getAuthorById(Long id);

    Author updateAuthor(Author authorDetail, Long id);

    Author deleteAuthor(Long id);
}
