package com.snell.michael.kawaii.primitive;

import com.snell.michael.kawaii.ComparableMicroType;

/**
 * Marker class for microtypes that wrap true Java primitives
 *
 * @param <T> Boxed primitive type
 */
class PrimitiveMicroType<T extends Comparable<T>> extends ComparableMicroType<T> {
    public PrimitiveMicroType(T value) {
        super(value);
    }
}
