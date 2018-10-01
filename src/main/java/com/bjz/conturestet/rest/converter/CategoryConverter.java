package com.bjz.conturestet.rest.converter;

import com.bjz.conturestet.persistence.model.Category;
import com.bjz.conturestet.persistence.request.CreateCategoryRequest;
import com.bjz.conturestet.rest.request.CreateCategoryJsonRequest;
import com.bjz.conturestet.rest.response.CategoryJsonResponse;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CategoryConverter {
    public static CategoryJsonResponse mapToJson(Category category) {
        return CategoryJsonResponse.builder()
                .setId(category.getId())
                .setName(category.getName())
                .setCreatedOn(category.getCreatedOn())
                .setUpdatedOn(category.getUpdatedOn())
                .build();
    }

    public static CreateCategoryRequest mapFromJson(CreateCategoryJsonRequest json) {
        return CreateCategoryRequest.builder()
                .setName(json.getName())
                .build();
    }
}
