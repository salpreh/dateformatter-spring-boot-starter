package com.salpreh.dateformatter;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value()
@AllArgsConstructor(staticName = "build")
public class DateFormatterConfig {
    private String localDateTimePattern;
    private String offsetDateTimePattern;
    private String localDatePattern;
    private String localTimePattern;

    private DateFormatterConfig(String localDateTimePattern, String localDatePattern, String localTimePattern) {
        this.localDateTimePattern = localDateTimePattern;
        this.offsetDateTimePattern = localDateTimePattern;
        this.localDatePattern = localDatePattern;
        this.localTimePattern = localTimePattern;
    }

    public static DateFormatterConfig build(String localDateTimePattern, String localDatePattern, String localTimePattern) {
        return new DateFormatterConfig(localDateTimePattern, localDatePattern, localTimePattern);
    }
}
