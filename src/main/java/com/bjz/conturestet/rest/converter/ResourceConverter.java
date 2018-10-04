package com.bjz.conturestet.rest.converter;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.rest.response.ResourceJsonResponse;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceConverter {
    public static ResourceJsonResponse mapToJson(Resource resource) {
        return ResourceJsonResponse.builder()
                .setId(resource.getId())
                .setName(resource.getName())
                .setUrl(resource.getUrl()
                        .orElseThrow(() -> new InvalidArgumentException("No resource URL present")))
                .setType(resource.getType())
                .setCreatedOn(resource.getCreatedOn())
                .setUpdatedOn(resource.getUpdatedOn())
                .build();
    }
}
