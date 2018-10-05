package com.bjz.conturestet.rest.response;

import com.bjz.conturestet.persistence.model.Resource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class TopicJsonResponseBuilder {
    private Integer id;
    private String name;
    private CategoryJsonResponse category;
    private List<ResourceJsonResponse> resources;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    TopicJsonResponseBuilder() {
    }

    public TopicJsonResponse build() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(category);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);

        return new TopicJsonResponse(id, name, category, resources, createdOn, updatedOn);
    }

    public TopicJsonResponseBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public TopicJsonResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TopicJsonResponseBuilder setCategory(CategoryJsonResponse category) {
        this.category = category;
        return this;
    }

    public TopicJsonResponseBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public TopicJsonResponseBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public TopicJsonResponseBuilder setResources(List<ResourceJsonResponse> resources) {
        this.resources = resources;
        return this;
    }
}
