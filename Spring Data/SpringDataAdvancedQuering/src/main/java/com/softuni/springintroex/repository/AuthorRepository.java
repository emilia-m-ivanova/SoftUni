package com.softuni.springintroex.repository;

import com.softuni.springintroex.entities.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AuthorRepository extends CrudRepository<Author,Long> {
    @Query("SELECT a FROM Author a JOIN Book b ON a.id = b.author.id where b.releaseDate < ?1")
    Set<Author> findByReleaseDateBefore(LocalDate date);

    @Query("SELECT a FROM Author a JOIN Book b ON a.id = b.author.id GROUP BY a.id ORDER BY COUNT (b.id) DESC")
    List<Author> findAllOrderByBooks();

    List<Author> findAllByFirstNameEndingWith(String endsWith);

}
