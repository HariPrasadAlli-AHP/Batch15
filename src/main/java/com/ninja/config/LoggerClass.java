package com.ninja.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {
    
    private static final Logger logger = LogManager.getLogger(LoggerClass.class);

    public static void main(String[] args) {
        logger.info("INFO: Application started successfully!");
        logger.debug("DEBUG: Debugging details here.");
        logger.warn("WARN: This is a warning message.");
        logger.error("ERROR: An error occurred.");
    }
}
