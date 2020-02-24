package com.github.tdotdm;

public class StringHelp extends Help {
    private final String value;

    public StringHelp(final String value) {
        this.value = value;
    }

    public String byRemovingWhitespace() {
        return this.value.replaceAll("\\s+", "");
    }
}
