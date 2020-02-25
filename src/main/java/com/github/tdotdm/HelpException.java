package com.github.tdotdm;

/*
 * Custom runtime exception used
 * for the Help library.
 * */
public final class HelpException extends RuntimeException {
    public HelpException() {
        //ignore
    }

    public HelpException(final String message) {
        super(message);
    }
}