package com.github.tdotdm;

/*
 * Class storing multiple
 * utility methods relating to
 * Integer.
 * */
public final class IntegerHelp {
    private final Integer value;

    public IntegerHelp(final Integer value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

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
