package com.example.springdataintro.service;

import com.example.springdataintro.model.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getAllCategories();
    Category getCategoryById(long id);
    void addCategory(Category Category);
    void addCategoriesCollection(Set<Category> Categories);
    long size();
}
