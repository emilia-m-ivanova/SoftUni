package com.softuni.springintroex.service.impl;

import com.softuni.springintroex.entities.Category;
import com.softuni.springintroex.exception.EntityDoestNotExistException;
import com.softuni.springintroex.repository.CategoryRepository;
import com.softuni.springintroex.service.CategoryService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.softuni.springintroex.constants.GlobalConstants.BOOKS_FILE_PATH;
import static com.softuni.springintroex.constants.GlobalConstants.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository CategoryRepository;
    private FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository CategoryRepository, FileUtil fileUtil) {
        this.CategoryRepository = CategoryRepository;
        this.fileUtil = fileUtil;
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

    @Override
    public void addCategoriesFromFile() throws IOException {
        String[] lines = fileUtil.readFileContent(CATEGORIES_FILE_PATH);
        Set<Category> categories = Arrays.stream(lines)
                .map(Category::new)
                .collect(Collectors.toSet());
        this.addCategoriesCollection(categories);
    }
}
