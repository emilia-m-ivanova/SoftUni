package com.softuni.springintroex.service;


import com.softuni.springintroex.entities.Author;

import java.io.IOException;
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
    void addAuthorsFromFile() throws IOException;

    Set<String> getAllAuthorsEndingWith(String endsWith);

    List<String> getAllAuthorsByBookCopies();
}
