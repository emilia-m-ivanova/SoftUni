package com.example.springdataintro.service;

import com.example.springdataintro.model.Book;

import java.util.Set;

public interface BookService {
    Set<Book> getAllBooks();
    Book getBookById(long id);
    void addBook(Book book);
    void addBooksCollection(Set<Book> books);

    Set<Book> getAllBooksAfter2000();

    Set<Book> getAllBooksByGPowell();
}
