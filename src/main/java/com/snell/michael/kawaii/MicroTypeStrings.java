package com.snell.michael.kawaii;

/**
 * Utility methods for micro type strings
 */
public class MicroTypeStrings {
    private MicroTypeStrings() {}

    public static <T extends MicroType<String>> T toUpperCase(T microTypeString) {
        if (microTypeString == null) {
            return null;
        } else {
            //noinspection unchecked
            return (T) MicroTypes.newMicroType(microTypeString.getClass(), microTypeString.value().toUpperCase());
        }
    }

    public static <T extends MicroType<String>> T toLowerCase(T microTypeString) {
        if (microTypeString == null) {
            return null;
        } else {
            //noinspection unchecked
            return (T) MicroTypes.newMicroType(microTypeString.getClass(), microTypeString.value().toLowerCase());
        }
    }
}
