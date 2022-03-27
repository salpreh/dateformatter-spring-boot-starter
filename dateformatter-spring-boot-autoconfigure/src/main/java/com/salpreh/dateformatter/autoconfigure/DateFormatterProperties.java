package com.salpreh.dateformatter.autoconfigure;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("salpreh.dateformatter")
@Getter @Setter
public class DateFormatterProperties {
    private String localDateTimeFormatter;
    private String offsetDateTimeFormatter;
    private String localDateFormatter;
    private String localTimeFormatter;
}
