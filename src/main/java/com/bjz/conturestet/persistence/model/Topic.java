package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class Topic extends BaseModel {
    private final Integer id;
    private final String name;
    private final Category category;

    Topic(Integer id, String name, Category category, LocalDateTime createdOn, LocalDateTime updatedOn) {
        super(createdOn, updatedOn);
        this.id = id;
        this.name = name;
        this.category = category;
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
}
