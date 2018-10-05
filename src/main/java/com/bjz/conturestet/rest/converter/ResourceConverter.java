package com.bjz.conturestet.rest.converter;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.rest.response.ResourceJsonResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceConverter {
    public static ResourceJsonResponse mapToJson(Resource resource) {
        return ResourceJsonResponse.builder()
                .setId(resource.getId())
                .setName(resource.getName())
                .setEndpoint(resource.getEndpoint()
                        .orElseThrow(() -> new InvalidArgumentException("No resource endpoint present")))
                .setType(resource.getType())
                .setCreatedOn(resource.getCreatedOn())
                .setUpdatedOn(resource.getUpdatedOn())
                .build();
    }

    public static List<ResourceJsonResponse> mapToJson(List<Resource> resource) {
        return resource.stream()
                .map(ResourceConverter::mapToJson)
                .collect(Collectors.toList());
    }
}
