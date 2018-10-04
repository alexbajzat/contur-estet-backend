package com.bjz.conturestet.rest.response;

import com.bjz.conturestet.persistence.model.Resource;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceResponseJsonBuilder {
    private Integer id;
    private String name;
    private Resource.Type type;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    ResourceResponseJsonBuilder() {
    }

    public ResourceJsonResponse build() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);

        return new ResourceJsonResponse(id, name, type, createdOn, updatedOn);
    }

    public ResourceResponseJsonBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ResourceResponseJsonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ResourceResponseJsonBuilder setType(Resource.Type type) {
        this.type = type;
        return this;
    }

    public ResourceResponseJsonBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public ResourceResponseJsonBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
