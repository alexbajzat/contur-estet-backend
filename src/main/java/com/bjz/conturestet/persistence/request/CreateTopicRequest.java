package com.bjz.conturestet.persistence.request;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class CreateTopicRequest {
    private final String name;
    private final Integer categoryId;

    CreateTopicRequest(String name, Integer categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public static CreateTopicRequestBuilder builder() {
        return new CreateTopicRequestBuilder();
    }


    public String getName() {
        return name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
