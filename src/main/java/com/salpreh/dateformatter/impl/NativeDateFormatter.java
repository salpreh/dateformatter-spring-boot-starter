package com.salpreh.dateformatter.impl;

import com.salpreh.dateformatter.DateFormatter;
import com.salpreh.dateformatter.DateFormatterConfig;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class NativeDateFormatter implements DateFormatter {
    private Formatters formatters;

    public NativeDateFormatter(@NonNull DateFormatterConfig config) throws IllegalArgumentException {
        configure(config);
    }

    @Override
    public String format(LocalDateTime datetime) {
        return datetime.format(formatters.localDateTimeFormatter);
    }

    @Override
    public String format(OffsetDateTime datetime) {
        return datetime.format(formatters.offsetDateTimeFormatter);
    }

    @Override
    public String format(LocalDate date) {
        return date.format(formatters.localDateFormatter);
    }

    @Override
    public String format(LocalTime time) {
        return time.format(formatters.localTimeFormatter);
    }

    private void configure(DateFormatterConfig config) throws IllegalArgumentException {
        var formatters = new Formatters();
        formatters.localDateTimeFormatter = DateTimeFormatter.ofPattern(config.getLocalDateTimePattern());
        formatters.offsetDateTimeFormatter = DateTimeFormatter.ofPattern(config.getOffsetDateTimePattern());
        formatters.localDateFormatter = DateTimeFormatter.ofPattern(config.getLocalDatePattern());
        formatters.localTimeFormatter = DateTimeFormatter.ofPattern(config.getLocalTimePattern());

        this.formatters = formatters;
    }

    private static class Formatters {
        public DateTimeFormatter localDateTimeFormatter;
        public DateTimeFormatter offsetDateTimeFormatter;
        public DateTimeFormatter localDateFormatter;
        public DateTimeFormatter localTimeFormatter;
    }
}
