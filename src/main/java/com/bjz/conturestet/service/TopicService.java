package com.bjz.conturestet.service;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.persistence.model.Topic;
import com.bjz.conturestet.persistence.repository.api.TopicRepository;
import com.bjz.conturestet.service.api.ITopicService;
import com.bjz.conturestet.service.request.CreateTopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
@Service
public class TopicService implements ITopicService {
    //repos
    private final TopicRepository topicRepository;
    private final CategoryService categoryService;

    // services
    private final ResourceService resourceService;

    @Autowired
    public TopicService(TopicRepository topicRepository, CategoryService categoryService, ResourceService resourceService) {
        this.topicRepository = topicRepository;
        this.categoryService = categoryService;
        this.resourceService = resourceService;
    }


    @Override
    public CompletableFuture<Topic> createTopic(@NotNull CreateTopicRequest request) {
        Objects.requireNonNull(request);
        return categoryService.findCategory(request.getCategoryId())
                .thenCompose(category -> topicRepository.createtopic(request))
                .thenCompose(topic -> resourceService.findResourcesByTopic(topic.getId())
                        .thenApply(resources ->
                                TopicService.addResources(
                                        topic,
                                        resources.collect(Collectors.toList()))));
    }

    @Override
    public CompletableFuture<Stream<Topic>> findTopics(@NotNull List<Integer> ids) {
        if (Objects.isNull(ids) || ids.isEmpty()) {
            throw new InvalidArgumentException("Topic ids list can't be empty");
        }

        List<CompletableFuture<Stream<Resource>>> resourcesFutures =
                Collections.synchronizedList(new ArrayList<CompletableFuture<Stream<Resource>>>());
        return topicRepository.findTopics(ids)
                .thenApply(topics ->
                        topics.map(topic -> {
                                    CompletableFuture<Stream<Resource>> resourceFuture = resourceService.findResourcesByTopic(topic.getId());
                                    resourcesFutures.add(resourceFuture);
                                    return resourceFuture
                                            .thenApply(resources -> addResources(topic, resources.collect(Collectors.toList())));
                                }
                        )).thenCompose(topics -> CompletableFuture.allOf(resourcesFutures.toArray(new CompletableFuture[0]))
                        .thenApply(empty -> topics.map(CompletableFuture::join)));
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

    private static Topic addResources(Topic topic, List<Resource> resources) {
        return Topic.builder()
                .setId(topic.getId())
                .setName(topic.getName())
                .setCategory(topic.getCategory())
                .setResources(resources)
                .setCreatedOn(topic.getCreatedOn())
                .setUpdatedOn(topic.getUpdatedOn())
                .build();
    }
}
