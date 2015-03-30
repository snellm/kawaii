package com.snell.michael.kawaii.resource;

import com.snell.michael.kawaii.MicroType;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.file.Path;

import static com.snell.michael.kawaii.MicroTypes.newMicroType;
import static java.util.Objects.requireNonNull;

/**
 * Allow reading files from the classpath as microtype strings
 */
public class ClasspathResources {
    private final Class<?> clazz;

    public ClasspathResources(Class<?> clazz) {
        this.clazz = requireNonNull(clazz);
    }

    public <T extends MicroType<String>> T read(Class<T> microTypeClass, Path path) {
        try (InputStream inputStream = clazz.getResourceAsStream(path.toString())) {
            return newMicroType(microTypeClass, IOUtils.toString(inputStream));
        } catch (Exception e) {
            throw new RuntimeException("Exception reading [" + microTypeClass.getSimpleName() + "] from [" + path + "]", e);
        }
    }
}
