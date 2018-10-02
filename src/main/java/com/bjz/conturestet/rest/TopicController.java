package com.bjz.conturestet.rest;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.rest.converter.TopicConverter;
import com.bjz.conturestet.rest.request.CreateTopicJsonRequest;
import com.bjz.conturestet.rest.response.TopicJsonResponse;
import com.bjz.conturestet.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
@RestController
@RequestMapping("/api")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "/topic", method = RequestMethod.POST)
    public CompletableFuture<ResponseEntity<TopicJsonResponse>> createTopic(@RequestBody CreateTopicJsonRequest request) {
        return topicService.createTopic(TopicConverter.fromJson(request))
                .thenApply(TopicConverter::toJson)
                .thenApply(response -> new ResponseEntity<>(response, HttpStatus.CREATED));

    }

    @RequestMapping(value = "/topic", method = RequestMethod.DELETE)
    public CompletableFuture<ResponseEntity<Void>> deleteTopic(@RequestParam(value = "ID") Integer id) {
        return topicService.deleteTopic(id)
                .thenApply(empty -> new ResponseEntity<>(HttpStatus.OK));

    }

    @RequestMapping(value = "/topics/all", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<List<TopicJsonResponse>>> findAll() {
        return topicService.findTopics()
                .thenApply(topics -> topics.collect(Collectors.toList()))
                .thenApply(TopicConverter::toJson)
                .thenApply(response -> new ResponseEntity<>(response, HttpStatus.OK));
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<List<TopicJsonResponse>>> findByIds(@RequestParam(value = "IDs") List<Integer> ids) {
        return topicService.findTopics(ids)
                .thenApply(topics -> topics.collect(Collectors.toList()))
                .thenApply(TopicConverter::toJson)
                .thenApply(response -> new ResponseEntity<>(response, HttpStatus.OK));
    }
}
