package com.bjz.conturestet.rest.response;

import java.time.LocalDateTime;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class TopicJsonResponse {
    private final Integer id;
    private final String name;
    private final CategoryJsonResponse category;
    private final LocalDateTime createdOn;
    private final LocalDateTime updatedOn;

    TopicJsonResponse(Integer id, String name, CategoryJsonResponse category, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public static TopicJsonResponseBuilder builder() {
        return new TopicJsonResponseBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryJsonResponse getCategory() {
        return category;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
