package com.bjz.conturestet.service.transformer;

import com.bjz.conturestet.service.request.CreateResourceRequest;

import java.util.UUID;

/**
 * Brought to life by bjz on 10/6/2018.
 */
public class CreateResourceTransformer implements Transformer<CreateResourceRequest> {
    @Override
    public CreateResourceRequest transform(CreateResourceRequest target) {
        return CreateResourceRequest.builder()
                .setName(target.getName())
                .setType(target.getType())
                .setEndpoint(generateEndpoint(target))
                .build();
    }

    private String generateEndpoint(CreateResourceRequest resourceRequest) {
        return String.format(
                "%s-%s%s",
                resourceRequest.getName(),
                UUID.randomUUID(),
                resourceRequest.getType().getExtension());
    }
}
