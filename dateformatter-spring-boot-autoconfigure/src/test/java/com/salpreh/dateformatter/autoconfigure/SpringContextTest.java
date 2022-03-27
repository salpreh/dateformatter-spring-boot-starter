package com.salpreh.dateformatter.autoconfigure;

import com.salpreh.dateformatter.DateFormatter;
import com.salpreh.dateformatter.DateFormatterConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DateFormatterAutoConfiguration.class})
public class SpringContextTest {

    @Autowired
    DateFormatterConfig dateFormatterConfig;

    @Autowired
    DateFormatter dateFormatter;

    @Test
    void shouldLoadConfiguredDateFormatterCorrectly() {
        assertNotNull(dateFormatterConfig);
        assertNotNull(dateFormatter);
    }
}
