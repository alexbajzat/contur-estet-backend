package com.bjz.conturestet.rest.converter;

import com.bjz.conturestet.persistence.model.Topic;
import com.bjz.conturestet.service.request.CreateTopicRequest;
import com.bjz.conturestet.rest.request.CreateTopicJsonRequest;
import com.bjz.conturestet.rest.response.TopicJsonResponse;

import java.util.Collections;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class TopicConverter {
    public static CreateTopicRequest fromJson(CreateTopicJsonRequest request) {
        return CreateTopicRequest.builder()
                .setName(request.getName())
                .setCategoryId(request.getCategoryId())
                .build();
    }

    public static TopicJsonResponse toJson(Topic topic) {
        return TopicJsonResponse.builder()
                .setId(topic.getId())
                .setName(topic.getName())
                .setCategory(CategoryConverter.mapToJson(topic.getCategory()))
                .setResources(ResourceConverter.mapToJson(topic.getResources()
                        .orElse(Collections.emptyList())))
                .setCreatedOn(topic.getCreatedOn())
                .setUpdatedOn(topic.getUpdatedOn())
                .build();
    }

    public static Stream<TopicJsonResponse> toJson(Stream<Topic> topics) {
        return topics.map(TopicConverter::toJson);
    }
}
