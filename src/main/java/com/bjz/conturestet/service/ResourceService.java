package com.bjz.conturestet.service;

import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.persistence.repository.api.ResourceRepository;
import com.bjz.conturestet.service.api.IResourceService;
import com.bjz.conturestet.service.request.CreateResourceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

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
        return resourceRepository.createResource(resourceRequest);
    }

    @Override
    public CompletableFuture<Resource> findResource(@NotNull Integer id) {
        Objects.requireNonNull(id);
        return resourceRepository.findResource(id);
    }
}
