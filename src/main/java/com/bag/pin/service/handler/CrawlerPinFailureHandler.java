package com.bag.pin.service.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by xiaomingniu on 29/11/2015.
 */
@Component
public class CrawlerPinFailureHandler {

    Logger logger = LoggerFactory.getLogger(CrawlerPinFailureHandler.class);

    public void handle(String url, Exception e) {
        logger.error("Failed to crawling page {} because: {}", url, e.getMessage());
    }
}
