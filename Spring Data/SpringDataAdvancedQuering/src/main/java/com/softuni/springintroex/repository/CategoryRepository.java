package com.softuni.springintroex.repository;
import com.softuni.springintroex.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
