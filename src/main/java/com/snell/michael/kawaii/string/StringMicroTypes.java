package com.snell.michael.kawaii.string;

import com.snell.michael.kawaii.MicroType;

import static com.snell.michael.kawaii.MicroTypes.newMicroType;

/**
 * Utility methods for micro type strings
 */
public class StringMicroTypes {
    private StringMicroTypes() {}

    public static <T extends MicroType<String>> T toUpperCase(T microTypeString) {
        return microTypeString == null ? null : newMicroType(microTypeString, microTypeString.value().toUpperCase());
    }

    public static <T extends MicroType<String>> T toLowerCase(T microTypeString) {
        return microTypeString == null ? null : newMicroType(microTypeString, microTypeString.value().toLowerCase());
    }

    public static <T extends MicroType<String>> T trim(T microTypeString) {
        return microTypeString == null ? null : newMicroType(microTypeString, microTypeString.value().trim());
    }
}
