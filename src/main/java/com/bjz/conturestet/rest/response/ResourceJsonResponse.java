package com.bjz.conturestet.rest.response;

import com.bjz.conturestet.persistence.model.Resource;

import java.time.LocalDateTime;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceJsonResponse {
    private final Integer id;
    private final String name;
    private final Resource.Type type;
    private final LocalDateTime createdOn;
    private final LocalDateTime updatedOn;


    ResourceJsonResponse(Integer id, String name, Resource.Type type, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public static ResourceResponseJsonBuilder builder() {
        return new ResourceResponseJsonBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Resource.Type getType() {
        return type;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
