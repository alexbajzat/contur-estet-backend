package com.bjz.conturestet.service;

import com.bjz.conturestet.persistence.model.Category;
import com.bjz.conturestet.persistence.repository.api.CategoryRepository;
import com.bjz.conturestet.service.request.CreateCategoryRequest;
import com.bjz.conturestet.service.api.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/1/2018.
 */
@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CompletableFuture<Category> findCategory(@NotNull Integer id) {
        Objects.requireNonNull(id);
        return categoryRepository.findCategory(id);
    }

    @Override
    public CompletableFuture<Category> createCategory(@NotNull CreateCategoryRequest request) {
        Objects.requireNonNull(request);
        return categoryRepository.createCategory(request);
    }

    @Override
    public CompletableFuture<Void> deleteCategory(@NotNull Integer id) {
        Objects.requireNonNull(id);
        return categoryRepository.deleteCategory(id);
    }

    @Override
    public CompletableFuture<Stream<Category>> findCategories() {
        return categoryRepository.findAll();
    }
}
