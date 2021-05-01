package com.github.tdotdm;

import org.jsoup.Jsoup;

import java.util.Optional;

/**
 * Utility class strictly concerned
 * with a String value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
public final class StringHelp extends Help<String> {
    private static final String QUERY_OPENING_REGEX = ".*\\b";
    private static final String QUERY_CLOSING_REGEX = "\\b.*";

    StringHelp(final String value) {
        super(value);
    }

    /**
     * Remove all whitespace from StringHelp's value.
     *
     * @return StringHelp's value, wherein, all whitespace has been removed.
     */
    public String byRemovingWhitespace() {
        return this.value.replaceAll("\\s+", "");
    }

    /**
     * Convert StringHelp's value into an Integer.
     *
     * @return An Optional, wherein, the present value
     * will be an Integer representation of StringHelp's value.
     */
    public Optional<Integer> byConvertingToInteger() {
        try {
            final int result = Integer.parseInt(this.value);
            return Optional.of(result);
        } catch (final NumberFormatException e) {
            return Optional.empty();
        }
    }

    /**
     * Confirm whether StringHelp's value contains
     * the exact given query both wholly & independently.
     * For example, given StringHelp's value is 'women',
     * querying for 'men' will return false.
     * Please note that this method is case sensitive.
     *
     * @param query The value to search StringHelp's value for.
     * @return Whether StringHelp's value contains the given query.
     */
    public boolean byConfirmingQueryIsIndependentlyPresent(final String query) {
        final String regex = QUERY_OPENING_REGEX + query + QUERY_CLOSING_REGEX;
        return this.value.matches(regex);
    }

    /**
     * Confirm whether StringHelp's value contains
     * the exact given query both wholly & independently.
     * For example, given StringHelp's value is 'women',
     * querying for 'men' will return false.
     * Please note that this method is case insensitive.
     *
     * @param query The value to search StringHelp's value for.
     * @return Whether StringHelp's value contains the given query.
     */
    public boolean byConfirmingQueryIsIndependentlyPresentIgnoringCase(final String query) {
        final String regex = QUERY_OPENING_REGEX + query.toLowerCase() + QUERY_CLOSING_REGEX;
        return this.value.toLowerCase().matches(regex);
    }

    /**
     * Remove all HTML elements from value.
     *
     * @return Value with all HTML elements removed.
     */
    public String byRemovingHTMLElements() {
        return Jsoup.parse(this.value).text();
    }
}
