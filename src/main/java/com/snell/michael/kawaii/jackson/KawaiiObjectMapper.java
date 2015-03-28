package com.snell.michael.kawaii.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.snell.michael.kawaii.MicroType;

public class KawaiiObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
    public KawaiiObjectMapper() {
        super();
        registerModule(new SimpleModule().addSerializer(MicroType.class, new MicroTypeSerialiser()));
    }
}
