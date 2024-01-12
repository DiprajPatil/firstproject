package com.springboot.controllers;

import com.springboot.entities.Book;
import com.springboot.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getALlBooks();
    }

    @GetMapping("books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        this.bookService.addBook(book);
        return book;
    }

    @DeleteMapping("books/{bookId}")
    public void deleteBook(@PathVariable ("bookId") int bookId)
    {
        this.bookService.deleteBook(bookId);
    }
}
