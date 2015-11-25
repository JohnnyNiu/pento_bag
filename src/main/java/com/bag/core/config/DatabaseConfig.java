package com.bag.core.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

/**
 * Created by johnny on 25/11/15.
 */
@Configuration
public class DatabaseConfig {

    @Bean
    public MongoTemplate getTemplate() throws UnknownHostException {
        return new MongoTemplate(getMongo(), "pentobag");
    }

    private Mongo getMongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

}
