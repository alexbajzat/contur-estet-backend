package com.bjz.conturestet.service;

import com.bjz.conturestet.exception.FileSystemIOException;
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
    public CompletableFuture<Void> saveFile(
            @NotNull InputStream fileStream,
            @NotNull Resource resource) {

        return CompletableFuture.runAsync(() -> {
            String formattedName = FileSystemUtils.buildFilePath(
                    storageURL,
                    buildFileName(resource),
                    resource.getType().getExtension());
            File file = new File(formattedName);

            try {
                FileUtils.copyInputStreamToFile(fileStream, file);
            } catch (IOException e) {
                throw new FileSystemIOException("Can't write file input stream to file");
            }
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
        return String.valueOf(resource.getId());
    }
}
