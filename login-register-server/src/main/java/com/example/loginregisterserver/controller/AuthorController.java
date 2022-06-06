package com.example.loginregisterserver.controller;

import com.example.loginregisterserver.service.AuthorService;
import com.example.loginregisterserver.exception.ResourceNotFoundException;
import com.example.loginregisterserver.model.Author;
import com.example.loginregisterserver.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author Vagharhak Grigoryan
 */


@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    public AuthorController(AuthorRepository userRepository, AuthorService authorService) {
        this.authorRepository = userRepository;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not exist with id :" + id));
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long authorId, @Valid @RequestBody Author authorDetail) throws ResourceNotFoundException {
        Author updateAuthor = authorService.updateAuthor(authorDetail, authorId);
        return ResponseEntity.ok(updateAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        Author author = authorService.deleteAuthor(authorId);
        return ResponseEntity.ok(author);
    }
}
