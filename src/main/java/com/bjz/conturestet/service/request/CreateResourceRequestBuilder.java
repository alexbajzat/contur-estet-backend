package com.bjz.conturestet.service.request;

import com.bjz.conturestet.persistence.model.Resource;

import java.util.Objects;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class CreateResourceRequestBuilder {
    private String name;
    private Resource.Type type;

    CreateResourceRequestBuilder() {
    }

    public CreateResourceRequest build() {
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);

        return new CreateResourceRequest(name, type);
    }

    public CreateResourceRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CreateResourceRequestBuilder setType(Resource.Type type) {
        this.type = type;
        return this;
    }
}
