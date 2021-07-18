package com.example.springdataintro.service.impl;

import com.example.springdataintro.exception.EntityDoestNotExistException;
import com.example.springdataintro.model.Author;
import com.example.springdataintro.repository.AuthorRepository;
import com.example.springdataintro.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Set<Author> getAllAuthors() {
        Set<Author> authors = new LinkedHashSet<>();
        Iterator<Author> iterator = authorRepository.findAll().iterator();
        while (iterator.hasNext()){
            authors.add(iterator.next());
        }
        return authors;
    }

    @Override
    public Author getAuthorById(long id) {
        return authorRepository.findById(id).orElseThrow(()->new EntityDoestNotExistException("Author with id " + id + "does not exist"));
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void addAuthorsCollection(Set<Author> authors) {
        authorRepository.saveAll(authors);
    }

    @Override
    public long size() {
        return authorRepository.count();
    }

    @Override
    public Set<Author> getAllAuthorsWithBooksBefore90s() {
        return authorRepository.findByReleaseDateBefore(LocalDate.of(1990,1,1));
    }

    @Override
    public List<Author> getAllAuthorsSortedByBooks() {
        return authorRepository.findAllOrderByBooks();
    }
}
