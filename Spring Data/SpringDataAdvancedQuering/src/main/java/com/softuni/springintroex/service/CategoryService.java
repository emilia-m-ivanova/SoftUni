package com.softuni.springintroex.service;


import com.softuni.springintroex.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    Set<Category> getAllCategories();
    Category getCategoryById(long id);
    void addCategory(Category Category);
    void addCategoriesCollection(Set<Category> Categories);
    long size();
    void addCategoriesFromFile() throws IOException;
}
