package com.snell.michael.kawaii.adapter.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.snell.michael.kawaii.MicroType;

class KawaiiModule extends SimpleModule {
    @Override
    public String getModuleName() {
        return getClass().getSimpleName();
    }

    @Override
    public void setupModule(SetupContext context) {
        addSerializer(MicroType.class, new MicroTypeSerializer());

        super.setupModule(context);
    }
}
