package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class Category extends BaseModel {
    private final Integer id;
    private final String name;

    Category(Integer id, String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
        super(createdOn, updatedOn);
        this.id = id;
        this.name = name;
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
