package com.bjz.conturestet.service.request;

import com.bjz.conturestet.persistence.model.Resource;

import java.util.Optional;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class CreateResourceRequest {
    private final String name;
    private final Resource.Type type;
    private final String endpoint;

    public CreateResourceRequest(String name, Resource.Type type, String endpoint) {
        this.name = name;
        this.type = type;
        this.endpoint = endpoint;
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

    public Optional<String> getEndpoint() {
        return Optional.ofNullable(endpoint);
    }
}
