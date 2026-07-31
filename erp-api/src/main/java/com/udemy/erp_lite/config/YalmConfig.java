package com.udemy.erp_lite.config;

import com.udemy.erp_lite.persistence.aws.models.AwsConfigModel;
import com.udemy.erp_lite.persistence.rest.models.JsonplaceholderConfigModel;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties({
        AwsConfigModel.class,
        JsonplaceholderConfigModel.class
})
@PropertySource(value = "classpath:aws.yml",factory = YalmPropertiesSourceFactory.class)
@PropertySource(value = "classpath:jsonplaceholder.yml",factory = YalmPropertiesSourceFactory.class)
public class YalmConfig {
}
