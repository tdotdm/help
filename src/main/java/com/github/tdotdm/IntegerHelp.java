package com.github.tdotdm;

/*
 * Class storing multiple
 * utility methods relating to
 * Integer.
 * */
public final class IntegerHelp extends Help {
    private final Integer value;

    public IntegerHelp(final Integer value) {
        validate(value);
        this.value = value;
    }

    public final boolean byCheckingNotExceedingBoundary(final Integer lowerBoundary,
                                                        final Integer upperBoundary) {
        if ((lowerBoundary.equals(upperBoundary)) || lowerBoundary > upperBoundary) {
            throw new HelpException("Lower is greater than Upper!");
        }

        return this.value >= lowerBoundary && this.value <= upperBoundary;
    }
}
