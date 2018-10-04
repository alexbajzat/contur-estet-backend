package com.bjz.conturestet.persistence.model;

import com.bjz.conturestet.exception.InvalidArgumentException;

import java.time.LocalDateTime;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class Resource extends BaseModel {
    private final Integer id;
    private final String name;
    private final Type type;


    Resource(Integer id, String name, Type type, LocalDateTime createdOn, LocalDateTime updatedOn) {
        super(createdOn, updatedOn);
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public static ResourceBuilder builder() {
        return new ResourceBuilder();
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public enum Type {
        JPEG("image/jpeg", ".jpeg"), PNG("image/png", ".png");

        private String mimeType;
        private String extension;

        Type(String mimeType, String extension) {
            this.mimeType = mimeType;
            this.extension = extension;
        }

        public String getMimeType() {
            return mimeType;
        }

        public String getExtension() {
            return extension;
        }

        public static Type getByMimeType(String mimeType) {
            return Stream.of(Type.values())
                    .filter(type -> type.getMimeType().equals(mimeType))
                    .findFirst()
                    .orElseThrow(() ->
                            new InvalidArgumentException(
                                    String.format("No type allowed for mime type: %s", mimeType)));
        }

        public static Type getByExtension(String extension) {
            return Stream.of(Type.values())
                    .filter(type -> type.getExtension().equals(extension))
                    .findFirst()
                    .orElseThrow(() ->
                            new InvalidArgumentException(
                                    String.format("No type allowed for extension: %s", extension)));
        }
    }
}
