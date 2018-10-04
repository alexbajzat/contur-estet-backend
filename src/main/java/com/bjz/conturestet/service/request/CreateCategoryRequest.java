package com.bjz.conturestet.service.request;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CreateCategoryRequest {
    private final String name;

    CreateCategoryRequest(String name) {
        this.name = name;
    }

    public static CreateCategoryRequestBuilder builder() {
        return new CreateCategoryRequestBuilder();
    }

    public String getName() {
        return name;
    }
}
