package com.bjz.conturestet.persistence.repository.api;

import com.bjz.conturestet.persistence.model.Topic;
import com.bjz.conturestet.persistence.request.CreateTopicRequest;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public interface TopicRepository {
    CompletableFuture<Topic> findTopic(@NotNull Integer id);

    CompletableFuture<Topic> createtopic(@NotNull CreateTopicRequest request);

    CompletableFuture<Stream<Topic>> findTopics();

    CompletableFuture<Stream<Topic>> findTopics(List<Integer> ids);

    CompletableFuture<Void> deleteTopic(@NotNull Integer id);
}
