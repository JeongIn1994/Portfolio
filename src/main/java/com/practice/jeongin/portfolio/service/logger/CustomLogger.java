package com.practice.jeongin.portfolio.service.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomLogger {
    private static final Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public void recordUserAction (String action){
        logger.info("User performed action: {}", action);
    }
}
