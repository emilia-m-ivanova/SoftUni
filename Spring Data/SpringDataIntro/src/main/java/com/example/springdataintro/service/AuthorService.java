package com.example.springdataintro.service;

import com.example.springdataintro.model.Author;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    Set<Author> getAllAuthors();
    Author getAuthorById(long id);
    void addAuthor(Author author);
    void addAuthorsCollection(Set<Author> authors);
    long size();

    Set<Author> getAllAuthorsWithBooksBefore90s();

    List<Author> getAllAuthorsSortedByBooks();
}
