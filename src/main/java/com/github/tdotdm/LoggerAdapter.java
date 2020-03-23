package com.github.tdotdm;

import org.apache.log4j.Logger;

/**
 * Class concerned with adding "syntactic sugar" to the logging functionality.
 *
 * @author Darryn McGaw
 * @since 3.1.0
 */
final class LoggerAdapter {
    private LoggerAdapter() {
        //ignore
    }

    /**
     * If the logging level is set to "DEBUG",
     * log the message.
     *
     * @param logger  The logger to use.
     * @param message The message to log.
     */
    static void debug(final Logger logger,
                      final String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }
}
