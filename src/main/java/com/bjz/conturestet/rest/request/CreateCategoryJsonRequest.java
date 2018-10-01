package com.bjz.conturestet.rest.request;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CreateCategoryJsonRequest {
    private String name;

    public String getName() {
        return name;
    }

    public CreateCategoryJsonRequest setName(String name) {
        this.name = name;
        return this;
    }
}
