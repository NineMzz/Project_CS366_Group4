package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    // Method to find books by their title
    public List<Book> searchByTitle(String title) {
        return repo.findByTitle(title);
    }

    // Method to find a book by its ID
    public Optional<Book> findById(Integer id) {
        return repo.findById(id);
    }

    public List<Book> findByStatus(String status) {
        return repo.findByStatus(status);
    }
    
    // Method to save a book into the database
    public Book save(Book book) {
        return repo.save(book);
    }

    
}
