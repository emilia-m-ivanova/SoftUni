package com.example.springdataintro.repository;

import com.example.springdataintro.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Set;

public interface BookRepository extends CrudRepository<Book,Long> {
    Set<Book> findByReleaseDateAfter(LocalDate date);

    @Query("SELECT b FROM Book b JOIN Author a ON b.author.firstName = ?1 AND b.author.lastName = ?2 " +
            "ORDER BY b.releaseDate DESC, b.title ASC ")
    Set<Book> findByAuthorName(String firstName, String lastName);
}
