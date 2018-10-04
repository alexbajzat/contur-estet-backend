package com.bjz.conturestet.service.request;

import java.util.Objects;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class CreateTopicRequestBuilder {
    private String name;
    private Integer categoryId;

    CreateTopicRequestBuilder() {
    }

    public CreateTopicRequest build() {
        Objects.requireNonNull(categoryId);
        Objects.requireNonNull(name);

        return new CreateTopicRequest(name, categoryId);
    }

    public CreateTopicRequestBuilder setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public CreateTopicRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
