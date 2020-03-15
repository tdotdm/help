package com.github.tdotdm;

/*
 * Class storing multiple
 * utility methods relating to
 * Boolean.
 * */
public final class BooleanHelp extends Help<Boolean> {
    public BooleanHelp(final Boolean value) {
        super(value);
    }

    public String byReturning(final String valueWhenTrue,
                              final String valueWhenFalse) {
        validate(valueWhenTrue, "Illegal 'valueWhenTrue'.");
        validate(valueWhenFalse, "Illegal 'valueWhenFalse'.");

        if (value) {
            return valueWhenTrue;
        } else {
            return valueWhenFalse;
        }
    }

    private static void validate(final String target,
                                 final String errorMessage) {
        if (target == null) {
            throw new HelpException(errorMessage);
        }
    }
}
