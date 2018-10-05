package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class Topic extends BaseModel {
    private final Integer id;
    private final String name;
    private final Category category;
    private final List<Resource> resources;

    Topic(Integer id, String name, Category category, List<Resource> resources, LocalDateTime createdOn, LocalDateTime updatedOn) {
        super(createdOn, updatedOn);
        this.id = id;
        this.name = name;
        this.category = category;
        this.resources = resources;
    }

    public static TopicBuilder builder() {
        return new TopicBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Optional<List<Resource>> getResources() {
        return Optional.ofNullable(resources);
    }
}
