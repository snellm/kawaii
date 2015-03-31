package com.snell.michael.kawaii;

import static com.snell.michael.kawaii.MicroTypes.newMicroType;

/**
 * Utility methods for micro type strings
 */
public class MicroTypeStrings {
    private MicroTypeStrings() {}

    public static <T extends MicroType<String>> T toUpperCase(T microTypeString) {
        if (microTypeString == null) {
            return null;
        } else {
            return newMicroType(microTypeString, microTypeString.value().toUpperCase());
        }
    }

    public static <T extends MicroType<String>> T toLowerCase(T microTypeString) {
        if (microTypeString == null) {
            return null;
        } else {
            //noinspection unchecked
            return newMicroType(microTypeString, microTypeString.value().toLowerCase());
        }
    }
}
