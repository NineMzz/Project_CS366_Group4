package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;

@RestController
@RequestMapping("/api")
public class BookController {
    
    @Autowired
    private BookService service;  // Ensure that BookService is implemented similar to CustomerService but for Book entities
    
    public BookController() {}
    
    public BookController(BookService service) {
        this.service = service;
    }
    
    // Endpoint to search books by title
    // http://localhost:8080/api/books?title=someTitle
    @GetMapping("/books")
    public List<Book> searchBooks(@RequestParam("title") String title) {     
        return service.searchByTitle(title);
    }
    
    // Endpoint to fetch a book by its ID
    // http://localhost:8080/api/books/id
    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }
    
    // Endpoint to create a new book
    // http://localhost:8080/api/books
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book savedBook = service.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
