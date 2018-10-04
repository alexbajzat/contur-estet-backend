package com.bjz.conturestet.service.request;

import com.bjz.conturestet.exception.InvalidArgumentException;
import org.springframework.util.StringUtils;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CreateCategoryRequestBuilder {
    private String name;

    public CreateCategoryRequest build() {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidArgumentException("Invalid category name");
        }
        return new CreateCategoryRequest(name);
    }

    public CreateCategoryRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
