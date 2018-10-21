package com.bjz.conturestet.rest;

import com.bjz.conturestet.exception.FileSystemIOException;
import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.rest.converter.ResourceConverter;
import com.bjz.conturestet.rest.response.ResourceJsonResponse;
import com.bjz.conturestet.service.api.IFileService;
import com.bjz.conturestet.service.api.IResourceService;
import com.bjz.conturestet.service.request.CreateResourceRequest;
import com.bjz.conturestet.utils.FileSystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/4/2018.
 */
@RestController
@RequestMapping(value = "/api")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @Autowired
    private IFileService fileService;


    @RequestMapping(value = "/resource/upload", method = RequestMethod.POST)
    public CompletableFuture<ResponseEntity<ResourceJsonResponse>> upload(
            @RequestParam(value = "file") MultipartFile fileRequest,
            @RequestParam(value = "targetID") Integer id,
            @RequestParam(value = "targetType") String targetType)
            throws IOException {
        CreateResourceRequest request = mapToRequest(fileRequest);
        return resourceService.createResource(request)
                .thenCompose(resource -> this.saveFile(resource, fileRequest))
                .thenApply(ResourceConverter::mapToJson)
                .thenApply(json -> new ResponseEntity<>(json, HttpStatus.CREATED));
    }

    private CompletableFuture<Resource> saveFile(Resource resource, MultipartFile fileRequest) {
        try {
            return fileService.saveFile(fileRequest.getInputStream(), resource);
        } catch (IOException e) {
            throw new FileSystemIOException("Can't write file");
        }
    }

    private CreateResourceRequest mapToRequest(MultipartFile fileRequest) {
        String contentType = fileRequest.getContentType();
        String fileName = fileRequest.getName();

        return CreateResourceRequest.builder()
                .setName(fileName)
                .setType(Resource.Type.getByMimeType(contentType))
                .build();
    }

    public enum AllowedUploadTarget {
        TOPIC;

        public static AllowedUploadTarget findByName(String name) {
            return Stream.of(AllowedUploadTarget.values())
                    .filter(allowed -> allowed.name().equalsIgnoreCase(name))
                    .findFirst()
                    .orElseThrow(() ->
                            new InvalidArgumentException(
                                    String.format("Target %s is not an allowed upload type", name)));
        }
    }
}
