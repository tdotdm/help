package com.github.tdotdm;

public abstract class Help {
    public static StringHelp help(final String value) {
        return new StringHelp(value);
    }
}
