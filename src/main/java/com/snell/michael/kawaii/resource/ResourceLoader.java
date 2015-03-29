package com.snell.michael.kawaii.resource;

import com.snell.michael.kawaii.MicroType;
import com.snell.michael.kawaii.MicroTypes;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.file.Path;

public class ResourceLoader {
    private final Class<?> clazz;

    public ResourceLoader(Class<?> clazz) {
        this.clazz = clazz;
    }

    public <T extends MicroType<String>> T readResource(Class<T> microTypeClass, Path path) {
        try (InputStream inputStream = clazz.getResourceAsStream(path.toString())) {
            return MicroTypes.instance(microTypeClass, IOUtils.toString(inputStream));
        } catch (Exception e) {
            throw new RuntimeException("Exception reading [" + microTypeClass.getSimpleName() + "] from [" + path + "]", e);
        }
    }
}
