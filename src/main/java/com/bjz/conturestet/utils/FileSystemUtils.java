package com.bjz.conturestet.utils;

import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class FileSystemUtils {
    public static String buildFilePath(String path, String fileName) {
        return String.format("%s/%s", path, fileName);
    }

    /**
     * @param name file name containing extension
     * @return file without any extensions
     */
    public static String removeExtension(String name) {
        return name.split(".")[0];
    }
}
