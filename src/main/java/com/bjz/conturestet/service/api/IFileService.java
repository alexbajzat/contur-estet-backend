package com.bjz.conturestet.service.api;

import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.service.request.CreateResourceRequest;

import javax.validation.constraints.NotNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public interface IFileService {
    CompletableFuture<Resource> saveFile(@NotNull InputStream fileStream, @NotNull Resource resource) throws IOException;

    CompletableFuture<Void> deleteFile(@NotNull String fileName);
}
