package com.snell.michael.kawaii.time;

import com.snell.michael.kawaii.SimpleMicroType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public abstract class LocalDateTimeMicroType extends SimpleMicroType<LocalDateTime> implements Temporal, TemporalAdjuster, ChronoLocalDateTime<LocalDate> {
    public LocalDateTimeMicroType(LocalDateTime value) {
        super(value);
    }

    @Override
    public LocalDate toLocalDate() {
        return value.toLocalDate();
    }

    @Override
    public LocalTime toLocalTime() {
        return value.toLocalTime();
    }

    @Override
    public ChronoLocalDateTime<LocalDate> with(TemporalField field, long newValue) {
        return value.with(field, newValue);
    }

    @Override
    public ChronoLocalDateTime<LocalDate> plus(long amountToAdd, TemporalUnit unit) {
        return value.plus(amountToAdd, unit);
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return value.until(endExclusive, unit);
    }

    @Override
    public ChronoZonedDateTime<LocalDate> atZone(ZoneId zone) {
        return value.atZone(zone);
    }

    @Override
    public boolean isSupported(TemporalField field) {
        return value.isSupported(field);
    }

    @Override
    public long getLong(TemporalField field) {
        return value.getLong(field);
    }
}
