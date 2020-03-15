package com.github.tdotdm;

/**
 * The core exception used for Help.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
public final class HelpException extends RuntimeException {
    public HelpException() {
        //ignore
    }

    public HelpException(final String message) {
        super(message);
    }
}