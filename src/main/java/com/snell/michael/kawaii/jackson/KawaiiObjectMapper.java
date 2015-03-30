package com.snell.michael.kawaii.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.snell.michael.kawaii.JSONString;
import com.snell.michael.kawaii.MicroTypes;

import java.io.IOException;

/**
 * Extend the standard Jackson ObjectMapper to add
 * - Reading and writing of JSONString microtypes
 * - Correct serialisation of mircrotypes with POJOS
 *
 * TODO ObjectMapper is a class not an interface, which makes extension messy - revisit
 */
public class KawaiiObjectMapper extends ObjectMapper {
    public KawaiiObjectMapper() {
        super();
        registerModule(new KawaiiModule());
    }

    public KawaiiObjectMapper(JsonFactory jf) {
        super(jf);
        registerModule(new KawaiiModule());
    }

    protected KawaiiObjectMapper(ObjectMapper src) {
        super(src);
        registerModule(new KawaiiModule());
    }

    public KawaiiObjectMapper(JsonFactory jf, DefaultSerializerProvider sp, DefaultDeserializationContext dc) {
        super(jf, sp, dc);
        registerModule(new KawaiiModule());
    }

    @Override
    public KawaiiObjectMapper enable(SerializationFeature f) {
        super.enable(f);
        return this;
    }

    public <T extends JSONString> T writeValueAs(Class<T> jsonMicroTypeClass, Object value) throws JsonProcessingException {
        return MicroTypes.newMicroType(jsonMicroTypeClass, writeValueAsString(value));
    }

    public <T extends JSONString, M> M readValue(T json, Class<M> valueType) throws IOException {
        return readValue(json.value(), valueType);
    }
}
