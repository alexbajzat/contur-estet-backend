package com.bjz.conturestet.service;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.persistence.repository.api.ResourceRepository;
import com.bjz.conturestet.service.api.IResourceService;
import com.bjz.conturestet.service.request.CreateResourceRequest;
import com.bjz.conturestet.service.transformer.CreateResourceTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/4/2018.
 */
@Service
public class ResourceService implements IResourceService {
    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public CompletableFuture<Resource> createResource(@NotNull CreateResourceRequest resourceRequest) {
        Objects.requireNonNull(resourceRequest);
        CreateResourceTransformer transformer = new CreateResourceTransformer();
        return resourceRepository.createResource(transformer.transform(resourceRequest));
    }

    @Override
    public CompletableFuture<Resource> findResource(@NotNull Integer id) {
        Objects.requireNonNull(id);
        return resourceRepository.findResource(id);
    }

    @Override
    public CompletableFuture<Stream<Resource>> findResources(List<Integer> ids) {
        Objects.requireNonNull(ids);
        if (ids.isEmpty()) {
            throw new InvalidArgumentException("IDs list can't be empty");
        }
        return resourceRepository.findResources(ids);
    }

    @Override
    public CompletableFuture<Stream<Resource>> findResourcesByTopic(Integer topicID) {
        Objects.requireNonNull(topicID);
        return resourceRepository.findResourcesByTopic(topicID);
    }


}
