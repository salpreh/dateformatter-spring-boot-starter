package com.salpreh.dateformatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

public interface DateFormatter {
    String format(LocalDateTime datetime);
    String format(OffsetDateTime datetime);

    String format(LocalDate date);
    String format(LocalTime time);
}
