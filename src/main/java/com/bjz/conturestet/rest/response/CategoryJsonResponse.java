package com.bjz.conturestet.rest.response;

import java.time.LocalDateTime;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CategoryJsonResponse {
    private final Integer id;
    private final String name;
    private final LocalDateTime createdOn;
    private final LocalDateTime updatedOn;


    CategoryJsonResponse(Integer id, String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public static CategoryJsonResponseBuilder builder() {
        return new CategoryJsonResponseBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
