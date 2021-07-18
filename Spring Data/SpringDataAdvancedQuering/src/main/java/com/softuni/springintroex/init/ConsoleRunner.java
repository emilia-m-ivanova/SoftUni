package com.softuni.springintroex.init;

import com.softuni.springintroex.entities.*;
import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.service.BookService;
import com.softuni.springintroex.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private AuthorService authorService;
    private CategoryService categoryService;
    private BookService bookService;

    @Autowired
    public ConsoleRunner(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        authorService.addAuthorsFromFile();
        categoryService.addCategoriesFromFile();
        bookService.addBooksFromFile();

        // ex 1
        bookService.getAllBookTitlesByAgeRestriction("teEn")
        .forEach(System.out::println);
        // ex 2
//        bookService.getAllGoldenEditionBookTitlesWithLessThan5000Copies()
//        .forEach(System.out::println);
        // ex 3
//        bookService.getAllBooksWithPriceLessThan5AndMoreThan40()
//                .forEach(System.out::println);
        // ex 4
//        bookService.getAllBooksNotReleasedInYear(2000)
//                .forEach(System.out::println);
        // ex 5
//        bookService.getAllBooksReleasedBeforeDate("12-04-1992")
//                .forEach(System.out::println);
        // ex 6
//        authorService.getAllAuthorsEndingWith("e")
//                .forEach(System.out::println);
        // ex 7
//        bookService.getAllBooksContaining("sK")
//                .forEach(System.out::println);
        // ex 8
//        bookService.getAllBooksWithAuthorsStartingWith("Ric")
//                .forEach(System.out::println);
        // ex 9
//        System.out.println(bookService.getNumBooksWithTitleLongerThan(40));

        // ex 10
//        authorService.getAllAuthorsByBookCopies()
//                .forEach(System.out::println);

        // ex 11
//        System.out.println(bookService.getBookByName("Things Fall Apart"));
    }

}
