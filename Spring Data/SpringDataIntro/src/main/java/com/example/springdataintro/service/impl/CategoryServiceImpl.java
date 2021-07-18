package com.example.springdataintro.service.impl;

import com.example.springdataintro.exception.EntityDoestNotExistException;
import com.example.springdataintro.model.Category;
import com.example.springdataintro.repository.CategoryRepository;
import com.example.springdataintro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository CategoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository CategoryRepository) {
        this.CategoryRepository = CategoryRepository;
    }

    @Override
    public Set<Category> getAllCategories() {
        Set<Category> categories = new LinkedHashSet<>();
        Iterator<Category> iterator = CategoryRepository.findAll().iterator();
        while (iterator.hasNext()){
            categories.add(iterator.next());
        }
        return categories;
    }

    @Override
    public Category getCategoryById(long id) {
        return CategoryRepository.findById(id).orElseThrow(()->new EntityDoestNotExistException("Category with id " + id + "does not exist"));
    }

    @Override
    public void addCategory(Category Category) {
        CategoryRepository.save(Category);
    }

    @Override
    public void addCategoriesCollection(Set<Category> categories) {
        CategoryRepository.saveAll(categories);
    }

    @Override
    public long size() {
        return CategoryRepository.count();
    }
}
