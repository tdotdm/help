package com.github.tdotdm;

public abstract class Help {
    public static StringHelp with(final String value) {
        return new StringHelp(value);
    }
}
