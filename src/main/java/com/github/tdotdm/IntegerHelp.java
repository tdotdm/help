package com.github.tdotdm;

/*
 * Class storing multiple
 * utility methods relating to
 * Integer.
 * */
public final class IntegerHelp extends Help<Integer> {
    public IntegerHelp(final Integer value) {
        super(value);
    }

    public boolean byCheckingNotExceedingBoundary(final Integer lowerBoundary,
                                                  final Integer upperBoundary) {
        if ((lowerBoundary.equals(upperBoundary)) || lowerBoundary > upperBoundary) {
            throw new HelpException("Lower is greater than Upper!");
        }

        return value >= lowerBoundary && this.value <= upperBoundary;
    }
}
