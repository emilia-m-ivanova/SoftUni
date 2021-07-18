package com.softuni.springintroex.service.impl;

import com.softuni.springintroex.entities.Author;
import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.exception.EntityDoestNotExistException;
import com.softuni.springintroex.repository.AuthorRepository;
import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.softuni.springintroex.constants.GlobalConstants.AUTHORS_FILE_PATH;
import static com.softuni.springintroex.constants.GlobalConstants.BOOKS_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
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

    @Override
    public void addAuthorsFromFile() throws IOException {
        String[] lines = fileUtil.readFileContent(AUTHORS_FILE_PATH);
        Set<Author> authors = Arrays.stream(lines)
                .map(l -> {
                    String[] details = l.split("\\s+");
                    return new Author(details[0], details[1]);
                }).collect(Collectors.toSet());
        this.addAuthorsCollection(authors);
    }

    @Override
    public Set<String> getAllAuthorsEndingWith(String endsWith) {
        return authorRepository.findAllByFirstNameEndingWith(endsWith)
                .stream()
                .map(a-> String.format("%s %s",a.getFirstName(),a.getLastName()))
                .collect(Collectors.toSet());
    }

    @Override
    public List<String> getAllAuthorsByBookCopies() {
        Iterable<Author> authors = authorRepository.findAll();
        Map<Author,Integer> authorCopies = new HashMap<>();
        for (Author author : authors) {
            int copies = 0;
            Set<Book> books = author.getBooks();
            for (Book book : books) {
                copies+=book.getCopies();
            }
            authorCopies.put(author,copies);
        }
        return authorCopies.entrySet()
                .stream()
                .sorted((e1,e2)->Integer.compare(e2.getValue(),e1.getValue()))
                .map(e->String.format("%s %s - %d",e.getKey().getFirstName(),e.getKey().getLastName(),e.getValue()))
                .collect(Collectors.toList());
    }
}
