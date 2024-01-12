package com.springboot.services;

import com.springboot.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    private static List<Book> list= new ArrayList<>();

    static{
        list.add(new Book(12,"Java Developer","ABC"));
        list.add(new Book(24,"Spring Boot","DEF"));
        list.add(new Book(36,"My SQL","GHI"));
    }

    //get all books
    public List<Book> getALlBooks()
    {
        return list;
    }

    //get single book by id
    public Book getBookById(int id)
    {
        Book book= null;
        book = list.stream().filter(e -> e.getId()==id).findFirst().get();
        return book;
    }

    //Adding the Book
    public Book addBook(Book b)
    {
        list.add(b);
    }
    //Deleting Book
    public void deleteBook(int bid)
    {
        list=list.stream().filter(book ->book.getId()!=bid).collect(Collectors.toList());
    }
}
