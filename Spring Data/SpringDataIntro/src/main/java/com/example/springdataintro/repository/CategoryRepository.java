package com.example.springdataintro.repository;

import com.example.springdataintro.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
