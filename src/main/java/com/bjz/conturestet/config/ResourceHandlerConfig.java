package com.bjz.conturestet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Brought to life by bjz on 10/4/2018.
 */
@Configuration
@EnableWebMvc
public class ResourceHandlerConfig implements WebMvcConfigurer {
    @Value("${storage.base.dir}")
    private String storageDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:/" + storageDir + "/");
    }
}
