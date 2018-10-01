package com.bjz.conturestet.rest;

import com.bjz.conturestet.rest.converter.CategoryConverter;
import com.bjz.conturestet.rest.request.CreateCategoryJsonRequest;
import com.bjz.conturestet.rest.response.CategoryJsonResponse;
import com.bjz.conturestet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 10/1/2018.
 */
@RestController
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public CompletableFuture<ResponseEntity<CategoryJsonResponse>> createCategory(
            @RequestBody CreateCategoryJsonRequest request) {
        return categoryService.createCategory(CategoryConverter.mapFromJson(request))
                .thenApply(CategoryConverter::mapToJson)
                .thenApply(category -> new ResponseEntity<>(category, HttpStatus.CREATED));
    }

    @RequestMapping(value = "/category", method = RequestMethod.DELETE)
    public CompletableFuture<ResponseEntity<Void>> deleteCategory(
            @RequestParam(value = "ID") Integer id) {
        return categoryService.deleteCategory(id)
                .thenApply(empty -> new ResponseEntity<Void>(HttpStatus.OK));
    }
}

