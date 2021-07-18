package com.softuni.springintroex.service;

import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.entities.ReducedBook;

import java.io.IOException;
import java.util.Set;

public interface BookService {
    Set<Book> getAllBooks();

    Book getBookById(long id);

    void addBook(Book book);

    void addBooksCollection(Set<Book> books);

    Set<Book> getAllBooksAfter2000();

    Set<Book> getAllBooksByGPowell();

    void addBooksFromFile() throws IOException;

    Set<String> getAllBookTitlesByAgeRestriction(String ageRestriction);

    Set<String> getAllGoldenEditionBookTitlesWithLessThan5000Copies();

    Set<String> getAllBooksWithPriceLessThan5AndMoreThan40();

    Set<String> getAllBooksNotReleasedInYear(int year);

    Set<String> getAllBooksReleasedBeforeDate(String date);

    Set <String> getAllBooksContaining(String searchString);

    Set<String> getAllBooksWithAuthorsStartingWith(String searchString);

    long getNumBooksWithTitleLongerThan(int i);

    ReducedBook getBookByName(String name);
}
