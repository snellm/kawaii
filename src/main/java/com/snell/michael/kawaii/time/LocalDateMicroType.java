package com.snell.michael.kawaii.time;

import com.snell.michael.kawaii.SimpleMicroType;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public abstract class LocalDateMicroType extends SimpleMicroType<LocalDate> implements Temporal, TemporalAdjuster, ChronoLocalDate {
    public LocalDateMicroType(LocalDate value) {
        super(value);
    }

    @Override
    public Chronology getChronology() {
        return value.getChronology();
    }

    @Override
    public int lengthOfMonth() {
        return value.lengthOfMonth();
    }

    @Override
    public ChronoPeriod until(ChronoLocalDate endDateExclusive) {
        return value.until(endDateExclusive);
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return value.until(endExclusive, unit);
    }

    @Override
    public long getLong(TemporalField field) {
        return value.getLong(field);
    }
}
