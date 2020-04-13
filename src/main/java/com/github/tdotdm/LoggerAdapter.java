package com.github.tdotdm;

import org.apache.log4j.Logger;

/**
 * Logging functionality with "syntactic sugar".
 *
 * @author Darryn McGaw
 * @since 3.1.0
 */
final class LoggerAdapter {
    private final Logger logger;
    private final boolean isDebugEnabled;
    private final boolean isTraceEnabled;
    private final boolean isInfoEnabled;

    LoggerAdapter(final Class clazz) {
        this.logger = Logger.getLogger(clazz);
        this.isDebugEnabled = logger.isDebugEnabled();
        this.isInfoEnabled = logger.isInfoEnabled();
        this.isTraceEnabled = logger.isTraceEnabled();
    }

    /**
     * If the logging level is set to "DEBUG",
     * log the message.
     *
     * @param message The message to log.
     */
    void debug(final String message) {
        if (isDebugEnabled) {
            this.logger.debug(message);
        }
    }

    /**
     * If the logging level is set to "INFO",
     * log the message.
     *
     * @param message The message to log.
     */
    void info(final String message) {
        if (isInfoEnabled) {
            this.logger.info(message);
        }
    }

    /**
     * If the logging level is set to "TRACE",
     * log the message.
     *
     * @param message The message to log.
     */
    void trace(final String message) {
        if (isTraceEnabled) {
            this.logger.trace(message);
        }
    }

    /**
     * If the logging level is set to "ERROR",
     * log the message.
     *
     * @param message The message to log.
     */
    void error(final String message) {
        this.logger.error(message);
    }
}
