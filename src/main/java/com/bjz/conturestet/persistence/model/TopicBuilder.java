package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class TopicBuilder {
    private Integer id;
    private String name;
    private Category category;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    TopicBuilder() {
    }

    public Topic build() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(category);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);

        return new Topic(id, name, category, createdOn, updatedOn);
    }

    public TopicBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public TopicBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TopicBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    public TopicBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public TopicBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
