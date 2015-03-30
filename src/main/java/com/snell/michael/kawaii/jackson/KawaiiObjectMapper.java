package com.snell.michael.kawaii.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snell.michael.kawaii.JSONString;
import com.snell.michael.kawaii.MicroTypes;

import java.io.IOException;

public class KawaiiObjectMapper {
    private final ObjectMapper objectMapper;

    public KawaiiObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;

        objectMapper.registerModule(new KawaiiModule());
    }

    public <T extends JSONString> T writeValueAs(Class<T> jsonMicroTypeClass, Object value) throws JsonProcessingException {
        return MicroTypes.instance(jsonMicroTypeClass, objectMapper.writeValueAsString(value));
    }

    public <T extends JSONString, M> M readValue(T json, Class<M> valueType) throws IOException {
        return objectMapper.readValue(json.value(), valueType);
    }
}
