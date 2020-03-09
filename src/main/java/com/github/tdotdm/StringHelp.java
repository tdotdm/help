package com.github.tdotdm;

import java.util.Optional;

/*
 * Class storing multiple
 * utility methods relating to
 * String.
 * */
public final class StringHelp extends Help {
    private final String value;

    public StringHelp(final String value) throws HelpException {
        validate(value);
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
