package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name="book_status")  // Changed to match your table name for books
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming ID is auto-increment in the database
    private Integer bookId;

    @Column(nullable = false)  // Assuming title must be non-null
    private String title;
    private String category;
    private String status;

    @Column(nullable = true)  // This allows null values, adjust based on your constraints
    private Integer quantity;

    public Book() {
    }

    public Book(Integer bookId, String title, String category, String status, Integer quantity) {
        this.bookId = bookId;
        this.title = title;
        this.category = category;
        this.status = status;
        this.quantity = quantity;
    }

    // Getters and setters
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
