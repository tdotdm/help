package com.github.tdotdm;

/**
 * The core exception used for Help.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
final class HelpException extends RuntimeException {
    HelpException(final String message) {
        super(message);
    }
}