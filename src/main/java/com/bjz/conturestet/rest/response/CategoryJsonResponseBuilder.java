package com.bjz.conturestet.rest.response;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CategoryJsonResponseBuilder {
    private Integer id;
    private String name;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    CategoryJsonResponseBuilder() {
    }

    public CategoryJsonResponse build() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);
        return new CategoryJsonResponse(id, name, createdOn, updatedOn);
    }

    public CategoryJsonResponseBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public CategoryJsonResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryJsonResponseBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public CategoryJsonResponseBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
