package com.bjz.conturestet.persistence.repository.api;

import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.service.request.CreateResourceRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public interface ResourceRepository {
    CompletableFuture<Resource> createResource(CreateResourceRequest resourceRequest);

    CompletableFuture<Resource> findResource(Integer id);

    CompletableFuture<Stream<Resource>> findResources(List<Integer> ids);

    CompletableFuture<Stream<Resource>> findResourcesByTopic(Integer topicID);

    CompletableFuture<Void> mapResourceToTopic(Integer topicID, Integer resourceID);
}
