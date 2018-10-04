package com.bjz.conturestet.persistence.repository.api;

import com.bjz.conturestet.persistence.model.Category;
import com.bjz.conturestet.service.request.CreateCategoryRequest;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public interface CategoryRepository {
    CompletableFuture<Category> findCategory(@NotNull Integer id);

    CompletableFuture<Category> createCategory(@NotNull CreateCategoryRequest request);

    CompletableFuture<Void> deleteCategory(@NotNull Integer id);

    CompletableFuture<Stream<Category>> findAll();
}
