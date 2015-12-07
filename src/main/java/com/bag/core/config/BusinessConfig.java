package com.bag.core.config;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    public static final String PENTO_BASE_URL = "www.pento.cn";
    public static final int PENTO_BASE_PORT = 80;
    public static final String PENTO_BASE_TYPE = "http://";
    private static final int MAX_CONNECTIONS = 20;


    @Bean
    public PoolingHttpClientConnectionManager getConnectionManager() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(MAX_CONNECTIONS);
        connManager.setDefaultMaxPerRoute(MAX_CONNECTIONS);
        return connManager;
    }
}
