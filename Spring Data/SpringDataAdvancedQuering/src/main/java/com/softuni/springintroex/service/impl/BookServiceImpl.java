package com.softuni.springintroex.service.impl;

import com.softuni.springintroex.entities.*;
import com.softuni.springintroex.exception.EntityDoestNotExistException;
import com.softuni.springintroex.repository.BookRepository;
import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.service.BookService;
import com.softuni.springintroex.service.CategoryService;

import static com.softuni.springintroex.constants.GlobalConstants.BOOKS_FILE_PATH;

import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private CategoryService categoryService;
    private FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }

    @Override
    public Set<Book> getAllBooks() {
        Set<Book> books = new LinkedHashSet<>();
        Iterator<Book> iterator = bookRepository.findAll().iterator();
        while (iterator.hasNext()) {
            books.add(iterator.next());
        }
        return books;
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityDoestNotExistException("Book with id " + id + "does not exist"));
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
        return bookRepository.findByReleaseDateAfter(LocalDate.of(2000, 1, 1));
    }

    @Override
    public Set<Book> getAllBooksByGPowell() {
        return bookRepository.findByAuthorName("George", "Powell");
    }

    @Transactional
    @Override
    public void addBooksFromFile() throws IOException {
        String[] lines = fileUtil.readFileContent(BOOKS_FILE_PATH);
        for (String line : lines) {
            String[] data = line.split("\\s+");
            Random random = new Random();
            long authorIndex = random.nextInt((int) authorService.size()) + 1;
            Author author = authorService.getAuthorById(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(data[1], formatter);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(data[3]));
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }

            String title = titleBuilder.toString().trim();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            Set<Category> categories = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                categories.add(categoryService.getCategoryById(random.nextInt((int) categoryService.size()) + 1));
            }
            book.setCategories(categories);
            bookRepository.save(book);

        }

    }

    @Override
    public Set<String> getAllBookTitlesByAgeRestriction(String ageRestriction) {
        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction.toUpperCase());
        return bookRepository.findAllByAgeRestriction(restriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllGoldenEditionBookTitlesWithLessThan5000Copies() {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllBooksWithPriceLessThan5AndMoreThan40() {
        return bookRepository.findAllByPriceLessThanOrPriceIsGreaterThan(BigDecimal.valueOf(5),BigDecimal.valueOf(40))
                .stream()
                .map(b-> String.format("%s - $%.2f",b.getTitle(),b.getPrice()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllBooksNotReleasedInYear(int year) {
        LocalDate start = LocalDate.of(year,1,1);
        LocalDate end = LocalDate.of(year,12,31);
        return bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(start,end)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllBooksReleasedBeforeDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate localDate = LocalDate.parse(date,formatter);
        return bookRepository.findAllByReleaseDateBefore(localDate)
                .stream()
                .map(b-> String.format("%s - %s $%.2f",b.getTitle(),b.getEditionType().toString(),b.getPrice()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllBooksContaining(String searchString) {
        return bookRepository.findAllByTitleContaining(searchString)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllBooksWithAuthorsStartingWith(String searchString) {
        return bookRepository.findAllByAuthorLastNameStartingWith(searchString)
                .stream()
                .map(b-> String.format("%s (%s %s)",b.getTitle(),b.getAuthor().getFirstName(),b.getAuthor().getLastName()))
                .collect(Collectors.toSet());
    }

    @Override
    public long getNumBooksWithTitleLongerThan(int length) {
        return bookRepository.findNumberOfBooksByTitleLength(length);
    }

    @Override
    public ReducedBook getBookByName(String name) {
        Book book = bookRepository.findByTitle(name);
        return new ReducedBook(book.getTitle(),book.getEditionType(),book.getAgeRestriction(),book.getPrice());
    }
}
