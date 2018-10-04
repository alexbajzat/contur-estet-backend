package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceBuilder {
    private Integer id;
    private String name;
    private String url;
    private Resource.Type extension;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    ResourceBuilder() {
    }

    public Resource build() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(extension);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);

        return new Resource(id, name, extension, url, createdOn, updatedOn);
    }

    public ResourceBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ResourceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ResourceBuilder setExtension(Resource.Type extension) {
        this.extension = extension;
        return this;
    }

    public ResourceBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public ResourceBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public ResourceBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
