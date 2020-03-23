package com.github.tdotdm;

/**
 * Utility class strictly concerned with a Boolean value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
final class BooleanHelp extends Help<Boolean> {
    /**
     * Constant to identify BooleanHelp through a String context.
     */
    public static final String IDENTIFIER = "BooleanHelp";

    BooleanHelp(final Boolean value) {
        super(value);
    }

    private static void validate(final String target,
                                 final String errorMessage) {
        if (target == null) {
            throw new HelpException(errorMessage);
        }
    }

    private String value(final String valueWhenTrue,
                         final String valueWhenFalse) {
        if (value) {
            return valueWhenTrue;
        } else {
            return valueWhenFalse;
        }
    }

    /**
     * Return a given value depending on the state of
     * BooleanHelp's value.
     *
     * @param valueWhenTrue  The String to return when BooleanHelp's value is true.
     * @param valueWhenFalse The String to return when BooleanHelp's value is false.
     * @return The value depending on the state of BooleanHelp's value.
     */
    String byReturning(final String valueWhenTrue,
                       final String valueWhenFalse) {
        validate(valueWhenTrue, "Illegal 'valueWhenTrue'.");
        validate(valueWhenFalse, "Illegal 'valueWhenFalse'.");

        return value(valueWhenTrue, valueWhenFalse);
    }

    /**
     * Return a given value depending on the state of
     * BooleanHelp's value.
     *
     * @param valueWhenTrue  The String to return when BooleanHelp's value is true.
     * @param valueWhenFalse The String to return when BooleanHelp's value is false.
     * @param defaultValue   The String to return when either valueWhenTrue or valueWhenFalse
     *                       is null.
     * @return The value depending on the state of BooleanHelp's value.
     */
    String byReturning(final String valueWhenTrue,
                       final String valueWhenFalse,
                       final String defaultValue) {
        if (valueWhenTrue == null || valueWhenFalse == null) {
            return defaultValue;
        }

        return value(valueWhenTrue, valueWhenFalse);
    }
}
