package com.orgmanager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by Виктор on 14.07.2017.
 */
//Necessary to include services beans to Spring container
@Configuration
@ComponentScan(basePackages = {"com.orgmanager.services"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Configuration.class})
)
public class ServicesAppConfig {
}
