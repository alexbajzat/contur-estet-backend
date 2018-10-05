package com.bjz.conturestet.service;

import com.bjz.conturestet.exception.FileSystemIOException;
import com.bjz.conturestet.exception.NotFoundException;
import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.service.api.IFileService;
import com.bjz.conturestet.utils.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class LocalFileService implements IFileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalFileService.class);
    @Value("${storage.base.dir}")
    private String storageURL;

    @PostConstruct
    private void postInit() {
        LOGGER.info(String.format("Using LOCAL storage path: %s", storageURL));
    }

    @Override
    public CompletableFuture<Resource> saveFile(
            @NotNull InputStream fileStream,
            @NotNull Resource resource) {

        return CompletableFuture.supplyAsync(() -> {
            String url = resource.getEndpoint().orElseThrow(() -> new NotFoundException("URL not present"));
            String formattedName = FileSystemUtils.buildFilePath(
                    storageURL,
                    url);
            File file = new File(formattedName);

            try {
                FileUtils.copyInputStreamToFile(fileStream, file);
            } catch (IOException e) {
                throw new FileSystemIOException("Can't write file input stream to file");
            }
            //build resource url
            return Resource.builder()
                    .setId(resource.getId())
                    .setName(resource.getName())
                    .setExtension(resource.getType())
                    .setEndpoint(url)
                    .setCreatedOn(resource.getCreatedOn())
                    .setUpdatedOn(resource.getUpdatedOn())
                    .build();
        });
    }

    @Override
    public CompletableFuture<Void> deleteFile(@NotNull String fileName) {
        return CompletableFuture.runAsync(() -> {
            File file = new File(FileSystemUtils.buildFilePath(storageURL, fileName));
            FileUtils.deleteQuietly(file);
        });
    }

    private static String buildFileName(Resource resource) {
        return String.format("%s-%s%s", resource.getName(), resource.getId(), resource.getType().getExtension());
    }
}
