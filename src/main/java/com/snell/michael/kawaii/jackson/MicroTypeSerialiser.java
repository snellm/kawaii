package com.snell.michael.kawaii.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.snell.michael.kawaii.MicroType;

import java.io.IOException;

public class MicroTypeSerialiser extends JsonSerializer<MicroType> {
    @Override
    public void serialize(MicroType microType, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        Object value = microType.value();
        jgen.writeObject(value);
    }
}
