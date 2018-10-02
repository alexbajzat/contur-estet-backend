package com.bjz.conturestet.rest.request;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class CreateTopicJsonRequest {
    private String name;
    private Integer categoryId;

    public String getName() {
        return name;
    }

    public CreateTopicJsonRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public CreateTopicJsonRequest setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
