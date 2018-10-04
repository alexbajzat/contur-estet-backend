package com.bjz.conturestet.config;

import com.bjz.conturestet.service.LocalFileService;
import com.bjz.conturestet.service.api.IFileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Brought to life by bjz on 10/4/2018.
 */
@Configuration
public class ResourceStorageConfig {

    @Bean
    public IFileService fileService() {
        return new LocalFileService();
    }
}
