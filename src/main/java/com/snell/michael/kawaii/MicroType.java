package com.snell.michael.kawaii;

public abstract class MicroType<T> {
    private final T t;

    protected MicroType(T t) {
        this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MicroType<?> microType = (MicroType<?>) o;

        return !(t != null ? !t.equals(microType.t) : microType.t != null);
    }

    @Override
    public int hashCode() {
        return t != null ? t.hashCode() : 0;
    }

    @Override
    public String toString() {
        return t.toString();
    }
}
