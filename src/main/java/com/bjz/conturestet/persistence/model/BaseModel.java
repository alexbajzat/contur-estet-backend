package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class BaseModel {
    private final LocalDateTime createdOn;
    private final LocalDateTime updatedOn;

    BaseModel(LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
