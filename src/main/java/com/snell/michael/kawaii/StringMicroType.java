package com.snell.michael.kawaii;

public abstract class StringMicroType extends ComparableMicroType<String> implements CharSequence {
    public StringMicroType(String value) {
        super(value);
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return MicroTypes.newMicroType(this, value.substring(start, end));
    }
}