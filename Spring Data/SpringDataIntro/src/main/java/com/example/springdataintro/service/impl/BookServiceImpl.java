package com.example.springdataintro.service.impl;

import com.example.springdataintro.exception.EntityDoestNotExistException;
import com.example.springdataintro.model.Book;
import com.example.springdataintro.repository.BookRepository;
import com.example.springdataintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> getAllBooks() {
        Set<Book> books = new LinkedHashSet<>();
        Iterator<Book> iterator = bookRepository.findAll().iterator();
        while (iterator.hasNext()){
            books.add(iterator.next());
        }
        return books;
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(()->new EntityDoestNotExistException("Book with id " + id + "does not exist"));
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void addBooksCollection(Set<Book> books) {
        bookRepository.saveAll(books);
    }

    @Override
    public Set<Book> getAllBooksAfter2000() {
        return bookRepository.findByReleaseDateAfter(LocalDate.of(2000,1,1));
    }

    @Override
    public Set<Book> getAllBooksByGPowell() {
        return bookRepository.findByAuthorName("George","Powell");
    }
}
