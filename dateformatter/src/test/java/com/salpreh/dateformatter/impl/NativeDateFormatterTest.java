package com.salpreh.dateformatter.impl;

import com.salpreh.dateformatter.DateFormatterConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

class NativeDateFormatterTest {

    private NativeDateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        var config = DateFormatterConfig.build(
            "dd/MM/yyyy HH:mm",
            "HH:mmXXX yyyy-MM-dd",
            "dd/MM/yyyy",
            "HH:mm"
        );

        this.dateFormatter = new NativeDateFormatter(config);
    }

    @Test
    void shouldFormatLocalDateTime() {
        // given
        var datetime = LocalDateTime.of(2022, 04, 12, 10, 30);

        // when
        var fDatetime = dateFormatter.format(datetime);

        // then
        assertEquals("12/04/2022 10:30", fDatetime);
    }

    @Test
    void shouldFormatOffsetDateTime() {
        // given
        var datetime = OffsetDateTime.of(
            LocalDateTime.of(2022, 04, 12, 10, 30),
            ZoneOffset.of("+2")
        );

        // when
        var fDatetime = dateFormatter.format(datetime);

        // then
        assertEquals("10:30+02:00 2022-04-12", fDatetime);
    }

    @Test
    void shouldFormatLocalDate() {
        // given
        var date = LocalDate.of(2022, 4, 12);

        // when
        var fDate = dateFormatter.format(date);

        // then
        assertEquals("12/04/2022", fDate);
    }

    @Test
    void shouldFormatLocalTime() {
        // given
        var time = LocalTime.of(10, 30);

        // when
        var fTime = dateFormatter.format(time);

        // then
        assertEquals("10:30", fTime);
    }
}