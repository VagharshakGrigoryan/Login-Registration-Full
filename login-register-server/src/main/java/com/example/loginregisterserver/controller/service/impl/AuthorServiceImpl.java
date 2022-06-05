package com.example.loginregisterserver.controller.service.impl;

import com.example.loginregisterserver.controller.service.AuthorService;
import com.example.loginregisterserver.exception.ResourceNotFoundException;
import com.example.loginregisterserver.model.Author;
import com.example.loginregisterserver.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not exist with id :" + id));
        return authorRepository.findById(author.getId());    }

    @Override
    public Author updateAuthor(Author authorDetail, Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not exist with id :" + id));
        author.setFirstName(authorDetail.getFirstName());
        author.setLastName(authorDetail.getLastName());
        author.setBirthDate(authorDetail.getBirthDate());
        return authorRepository.save(author);
    }

    @Override
    public Author deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not exist with id :" + id));

        authorRepository.delete(author);
        return author;
    }
}
