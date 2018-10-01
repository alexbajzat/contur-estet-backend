package com.bjz.conturestet.service.api;

import com.bjz.conturestet.persistence.model.Category;
import com.bjz.conturestet.persistence.request.CreateCategoryRequest;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public interface ICategoryService {
    CompletableFuture<Category> findCategory(@NotNull Integer id);

    CompletableFuture<Category> createCategory(@NotNull CreateCategoryRequest request);

    CompletableFuture<Void> deleteCategory(@NotNull Integer id);
}
