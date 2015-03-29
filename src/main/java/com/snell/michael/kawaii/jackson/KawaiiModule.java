package com.snell.michael.kawaii.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.snell.michael.kawaii.MicroType;

class KawaiiModule extends SimpleModule {
    @Override
    public String getModuleName() {
        return getClass().getSimpleName();
    }

    @Override
    public void setupModule(SetupContext context) {
        addSerializer(MicroType.class, new MicroTypeSerialiser());

        super.setupModule(context);
    }
}
