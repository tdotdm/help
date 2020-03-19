package com.github.tdotdm;

import java.util.Optional;

/**
 * Utility class strictly concerned
 * with a String value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
final class StringHelp extends Help<String> {
    StringHelp(final String value) {
        super(value);
    }

    /**
     * Remove all whitespace from StringHelp's value.
     *
     * @return StringHelp's value, wherein, all whitespace has been removed.
     */
    String byRemovingWhitespace() {
        return this.value.replaceAll("\\s+", "");
    }

    /**
     * Convert StringHelp's value into an Integer.
     *
     * @return An Optional, wherein, the present value
     * will be an Integer representation of StringHelp's value.
     */
    Optional<Integer> byConvertingToInteger() {
        try {
            final int result = Integer.parseInt(this.value);
            return Optional.of(result);
        } catch (final NumberFormatException e) {
            return Optional.empty();
        }
    }
}
