package com.github.tdotdm;

/**
 * Utility class strictly concerned
 * with an Integer value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
public final class IntegerHelp extends Help<Integer> {
    public IntegerHelp(final Integer value) {
        super(value);
    }

    /**
     * Return true or false depending on whether IntegerHelp's value
     * exceeds the given limit.
     *
     * @param lowerBoundary The smallest size the IntegerHelp's value can be.
     * @param upperBoundary The biggest size the IntegerHelp's value can be.
     * @return Return true or false depending on whether IntegerHelp's value
     * exceeds the given limit.
     */
    public boolean byCheckingNotExceedingBoundary(final Integer lowerBoundary,
                                                  final Integer upperBoundary) {
        if ((lowerBoundary.equals(upperBoundary)) || lowerBoundary > upperBoundary) {
            throw new HelpException("Lower is greater than Upper!");
        }

        return value >= lowerBoundary && this.value <= upperBoundary;
    }
}
