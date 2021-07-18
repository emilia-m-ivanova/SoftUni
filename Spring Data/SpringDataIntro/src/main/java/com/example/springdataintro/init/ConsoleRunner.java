package com.example.springdataintro.init;

import com.example.springdataintro.model.*;
import com.example.springdataintro.service.AuthorService;
import com.example.springdataintro.service.BookService;
import com.example.springdataintro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        addAuthorsFromFile();
        addCategoriesFromFile();
        addBooksFromFile();
        System.out.println("All books after the year 2000.");
        bookService.getAllBooksAfter2000().forEach(b->
                System.out.println(b.getTitle()));
        System.out.println("--------------------------------------------------------------");
        System.out.println("All authors with at least one book with release date before 1990:");
        authorService.getAllAuthorsWithBooksBefore90s().forEach(a->
                System.out.println(a.getFirstName() + " " + a.getLastName()));
        System.out.println("--------------------------------------------------------------");
        System.out.println("All authors, ordered by the number of their books(descending):");
        authorService.getAllAuthorsSortedByBooks().forEach(a->
                System.out.println(a.getFirstName() + " " + a.getLastName() + " number of books " + a.getBooks().size()));
        System.out.println("--------------------------------------------------------------");
        System.out.println("All books from author George Powell");
        bookService.getAllBooksByGPowell().forEach(b->
                System.out.println(b.getTitle() + " release date: " + b.getReleaseDate() + " copies: " + b.getCopies()));
    }

    private List<String> readFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        String line = bf.readLine();
        while (line!=null){
            if(!line.trim().isEmpty()){
                lines.add(line);
            }
            line = bf.readLine();
        }
        return lines;
    }

    private void addAuthorsFromFile() throws IOException {
        List<String> lines = readFromFile("src/main/resources/files/authors.txt");
        Set<Author> authors = lines.stream()
                .map(l -> {
                    String[] details = l.split("\\s+");
                    return new Author(details[0], details[1]);
                }).collect(Collectors.toSet());
        authorService.addAuthorsCollection(authors);
    }

    private void addCategoriesFromFile() throws IOException {
        List<String> lines = readFromFile("src/main/resources/files/categories.txt");
        Set<Category> categories = lines.stream()
                .map(Category::new)
                .collect(Collectors.toSet());
        categoryService.addCategoriesCollection(categories);
    }

    private void addBooksFromFile() throws IOException {
        List<String> lines = readFromFile("src/main/resources/files/books.txt");
        for (String line : lines) {
            String[] data = line.split("\\s+");
            Random random = new Random();
            long authorIndex = random.nextInt((int)authorService.size())+1;
            Author author = authorService.getAuthorById(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(data[1], formatter);
            int copies = Integer.parseInt(data[2]);
            double price = Double.parseDouble(data[3]);
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
                categories.add(categoryService.getCategoryById(random.nextInt((int)categoryService.size())+1));
            }
            book.setCategories(categories);
            bookService.addBook(book);

        }

    }
}
