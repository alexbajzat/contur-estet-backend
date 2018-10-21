package com.bjz.conturestet.service.api;

import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.service.request.CreateResourceRequest;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public interface IResourceService {
    CompletableFuture<Resource> createResource(@NotNull CreateResourceRequest resourceRequest);

    CompletableFuture<Resource> findResource(@NotNull Integer id);

    CompletableFuture<Stream<Resource>> findResources(List<Integer> ids);

    CompletableFuture<Stream<Resource>> findResourcesByTopic(Integer topicID);

    CompletableFuture<Void> mapTopicResources(Integer topicID, Integer resourceID);
}
