package com.bjz.conturestet.service;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.model.Topic;
import com.bjz.conturestet.persistence.repository.api.TopicRepository;
import com.bjz.conturestet.persistence.request.CreateTopicRequest;
import com.bjz.conturestet.service.api.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
@Service
public class TopicService implements ITopicService {
    private final TopicRepository topicRepository;
    private final CategoryService categoryService;

    @Autowired
    public TopicService(TopicRepository topicRepository, CategoryService categoryService) {
        this.topicRepository = topicRepository;
        this.categoryService = categoryService;
    }


    @Override
    public CompletableFuture<Topic> createTopic(@NotNull CreateTopicRequest request) {
        Objects.requireNonNull(request);
        return categoryService.findCategory(request.getCategoryId())
                .thenCompose(category -> topicRepository.createtopic(request));
    }

    @Override
    public CompletableFuture<Stream<Topic>> findTopics(@NotNull List<Integer> ids) {
        if (Objects.isNull(ids) || ids.isEmpty()) {
            throw new InvalidArgumentException("Topic ids list can't be empty");
        }

        return topicRepository.findTopics(ids);
    }

    @Override
    public CompletableFuture<Stream<Topic>> findTopics() {
        return topicRepository.findTopics();
    }

    @Override
    public CompletableFuture<Void> deleteTopic(@NotNull Integer id) {
        Objects.requireNonNull(id);
        return topicRepository.deleteTopic(id);
    }
}