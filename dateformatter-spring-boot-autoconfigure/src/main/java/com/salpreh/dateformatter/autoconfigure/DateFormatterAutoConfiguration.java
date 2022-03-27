package com.salpreh.dateformatter.autoconfigure;

import com.salpreh.dateformatter.DateFormatter;
import com.salpreh.dateformatter.DateFormatterConfig;
import com.salpreh.dateformatter.impl.NativeDateFormatter;
import lombok.experimental.UtilityClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DateFormatter.class)
@EnableConfigurationProperties(DateFormatterProperties.class)
public class DateFormatterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DateFormatterConfig dateFormatterConfig(DateFormatterProperties properties) {
        String localDateTimePattern = properties.getLocalDateTimeFormatter() != null
            ? properties.getLocalDateFormatter()
            : DateFormatterDefaults.LOCAL_DATETIME_PATTERN;

        String offsetDateTimePattern = properties.getOffsetDateTimeFormatter() != null
            ? properties.getOffsetDateTimeFormatter()
            : DateFormatterDefaults.OFFSET_DATETIME_PATTERN;

        String localDatePattern = properties.getLocalDateFormatter() != null
            ? properties.getLocalDateFormatter()
            : DateFormatterDefaults.LOCAL_DATE_PATTERN;

        String localTimePattern = properties.getLocalTimeFormatter() != null
            ? properties.getLocalTimeFormatter()
            : DateFormatterDefaults.LOCAL_TIME_PATTERN;

        return DateFormatterConfig.build(localDateTimePattern, offsetDateTimePattern, localDatePattern, localTimePattern);
    }

    @Bean
    @ConditionalOnMissingBean
    public DateFormatter dateFormatter(DateFormatterConfig config) {
        return new NativeDateFormatter(config);
    }

    @UtilityClass
    private static class DateFormatterDefaults {
        public final String LOCAL_DATETIME_PATTERN = "dd/MM/yyyy HH:mm";
        public final String OFFSET_DATETIME_PATTERN = "dd/MM/yyyy HH:mmXXX";
        public final String LOCAL_DATE_PATTERN = "dd/MM/yyyy";
        public final String LOCAL_TIME_PATTERN = "HH:mm";
    }
}
