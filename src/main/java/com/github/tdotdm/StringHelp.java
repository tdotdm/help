package com.github.tdotdm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Utility class strictly concerned with a String value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
@SuppressWarnings("MultipleStringLiterals")
final class StringHelp extends Help<String> {
    /**
     * Constant to identify StringHelp through a String context.
     */
    public static final String IDENTIFIER = "StringHelp";

    private static final String EMPTY_STRING = "";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String REGEX_QUERY_LEFT = ".*\\b";
    private static final String REGEX_QUERY_RIGHT = "\\b.*";

    StringHelp(final String value) {
        super(value);
    }

    /**
     * Remove all whitespace from StringHelp's value.
     *
     * @return StringHelp's value, wherein, all whitespace has been removed.
     */
    String byRemovingWhitespace() {
        return this.value.replaceAll(REGEX_WHITESPACE, EMPTY_STRING);
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
    boolean byConfirmingQueryIsIndependentlyPresent(final String query) {
        final String regex = REGEX_QUERY_LEFT + query + REGEX_QUERY_RIGHT;
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
    boolean byConfirmingQueryIsIndependentlyPresentIgnoringCase(final String query) {
        final String regex = REGEX_QUERY_LEFT + query.toLowerCase() + REGEX_QUERY_RIGHT;
        return this.value.toLowerCase().matches(regex);
    }

    /**
     * Change StringHelp's value from one
     * given timestamp format to another. If
     * an exception occurs whilst formatting
     * StringHelp's value, then StringHelp's unformatted
     * value will be returned.
     *
     * @param currentFormat The current format of StringHelp's timestamp value.
     * @param desiredFormat The desired format of StringHelp's timestamp value.
     * @return StringHelp's formatted value or unformatted value.
     */
    String byFormattingTimestamp(final String currentFormat,
                                 final String desiredFormat) {
        if (currentFormat == null || desiredFormat == null) {
            throw new HelpException("Cannot operate with illegal timestamp format(s).");
        }

        try {
            final SimpleDateFormat currentSDF = new SimpleDateFormat(currentFormat);
            final Date valueAsDate = currentSDF.parse(this.value);
            final SimpleDateFormat desiredSDF = new SimpleDateFormat(desiredFormat);
            final String formattedValue = desiredSDF.format(valueAsDate);

            log.info("Converted '" + currentFormat + "' to '" + desiredFormat + "'.");
            return formattedValue;
        } catch (final ParseException e) {
            log.error("Cannot convert '" + this.value + "' with format '" + currentFormat + "'.");
        }

        log.info("Returning given value of '" + this.value + "'.");
        return this.value;
    }
}
