package com.github.tdotdm;

import java.util.Optional;

public class StringHelp extends Help {
    private final String value;

    public StringHelp(final String value) {
        this.value = value;
    }

    public String byRemovingWhitespace() {
        return this.value.replaceAll("\\s+", "");
    }

    public Optional<Integer> byConvertingToInteger() {
        try {
            final int result = Integer.parseInt(this.value);
            return Optional.of(result);
        } catch (final NumberFormatException e) {
            return Optional.empty();
        }
    }
}