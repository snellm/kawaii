package com.snell.michael.kawaii.time;

import com.snell.michael.kawaii.ComparableMicroType;

import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public abstract class LocalTimeMicroType extends ComparableMicroType<LocalTime> implements Temporal, TemporalAdjuster {
    public LocalTimeMicroType(LocalTime value) {
        super(value);
    }

    @Override
    public boolean isSupported(TemporalUnit unit) {
        return value.isSupported(unit);
    }

    @Override
    public Temporal with(TemporalField field, long newValue) {
        return value.with(field, newValue);
    }

    @Override
    public Temporal plus(long amountToAdd, TemporalUnit unit) {
        return value.plus(amountToAdd, unit);
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return value.until(endExclusive, unit);
    }

    @Override
    public boolean isSupported(TemporalField field) {
        return value.isSupported(field);
    }

    @Override
    public long getLong(TemporalField field) {
        return value.getLong(field);
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        return value.adjustInto(temporal);
    }
}
