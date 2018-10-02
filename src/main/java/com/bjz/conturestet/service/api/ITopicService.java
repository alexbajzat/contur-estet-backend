package com.bjz.conturestet.service.api;

import com.bjz.conturestet.persistence.model.Topic;
import com.bjz.conturestet.persistence.request.CreateTopicRequest;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public interface ITopicService {
    CompletableFuture<Topic> createTopic(@NotNull CreateTopicRequest request);

    CompletableFuture<Stream<Topic>> findTopics(@NotNull List<Integer> ids);

    CompletableFuture<Stream<Topic>> findTopics();

    CompletableFuture<Void> deleteTopic(@NotNull Integer id);
}
