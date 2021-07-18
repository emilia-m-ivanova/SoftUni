package com.softuni.springintroex.repository;

import com.softuni.springintroex.entities.AgeRestriction;
import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.entities.EditionType;
import com.softuni.springintroex.entities.ReducedBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public interface BookRepository extends CrudRepository<Book, Long> {
    Set<Book> findByReleaseDateAfter(LocalDate date);

    @Query("SELECT b FROM Book b JOIN Author a ON b.author.firstName = ?1 AND b.author.lastName = ?2 " +
            "ORDER BY b.releaseDate DESC, b.title ASC ")
    Set<Book> findByAuthorName(String firstName, String lastName);

    Set<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    Set<Book> findAllByPriceLessThanOrPriceIsGreaterThan(BigDecimal lessThan, BigDecimal moreThan);

    Set<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate start, LocalDate end);

    Set<Book> findAllByReleaseDateBefore(LocalDate date);

    Set<Book> findAllByTitleContaining(String searchString);

    Set<Book> findAllByAuthorLastNameStartingWith(String searchString);

    @Query("SELECT COUNT(id) FROM Book WHERE LENGTH(title) >?1")
    long findNumberOfBooksByTitleLength(int length);

    Book findByTitle(String title);
}
