package io.wordlift.vectorSearch.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mongodb")
@Data
public class MongoDBConfigProperties {
    private String uri;
    private String database;
    private String collection;
    private String vector;
}
