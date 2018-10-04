package com.bjz.conturestet.persistence.repository.api;

import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.service.request.CreateResourceRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public interface ResourceRepository {
    CompletableFuture<Resource> createResource(CreateResourceRequest resourceRequest);

    CompletableFuture<Resource> findResource(Integer id);
}
