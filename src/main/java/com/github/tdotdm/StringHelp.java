package com.github.tdotdm;

import java.util.Optional;

/*
 * Class storing multiple
 * utility methods relating to
 * String.
 * */
public final class StringHelp {
    private final String value;

    public StringHelp(final String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public final String byRemovingWhitespace() {
        return this.value.replaceAll("\\s+", "");
    }

    public final Optional<Integer> byConvertingToInteger() {
        try {
            final int result = Integer.parseInt(this.value);
            return Optional.of(result);
        } catch (final NumberFormatException e) {
            return Optional.empty();
        }
    }
}
