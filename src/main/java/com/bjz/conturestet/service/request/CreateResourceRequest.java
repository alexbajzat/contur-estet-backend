package com.bjz.conturestet.service.request;

import com.bjz.conturestet.persistence.model.Resource;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class CreateResourceRequest {
    private final String name;
    private final Resource.Type type;

    public CreateResourceRequest(String name, Resource.Type type) {
        this.name = name;
        this.type = type;
    }

    public static CreateResourceRequestBuilder builder() {
        return new CreateResourceRequestBuilder();
    }

    public String getName() {
        return name;
    }

    public Resource.Type getType() {
        return type;
    }
}
