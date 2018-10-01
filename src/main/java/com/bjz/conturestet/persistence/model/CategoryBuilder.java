package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CategoryBuilder {
    private Integer id;
    private String name;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public Category build() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);

        return new Category(id, name, createdOn, updatedOn);
    }

    public CategoryBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public CategoryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public CategoryBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
