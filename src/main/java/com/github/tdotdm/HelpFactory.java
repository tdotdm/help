package com.github.tdotdm;

import java.util.List;
import java.util.Set;

/**
 * The core access point of Help.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
public abstract class HelpFactory {
    /**
     * Return a new instance of BooleanHelp.
     *
     * @param value The value to instantiate BooleanHelp with.
     * @return A new instance of BooleanHelp.
     */
    public static BooleanHelp help(final Boolean value) {
        return new BooleanHelp(value);
    }

    /**
     * Return a new instance of IntegerHelp.
     *
     * @param value The value to instantiate IntegerHelp with.
     * @return A new instance of IntegerHelp.
     */
    public static IntegerHelp help(final Integer value) {
        return new IntegerHelp(value);
    }

    /**
     * Return a new instance of ListHelp.
     *
     * @param value The value to instantiate ListHelp with.
     * @return A new instance of ListHelp.
     */
    public static ListHelp help(final List<?> value) {
        return new ListHelp(value);
    }

    /**
     * Return a new instance of SetHelp.
     *
     * @param value The value to instantiate SetHelp with.
     * @return A new instance of SetHelp.
     */
    public static SetHelp help(final Set<?> value) {
        return new SetHelp(value);
    }

    /**
     * Return a new instance of StringHelp.
     *
     * @param value The value to instantiate StringHelp with.
     * @return A new instance of StringHelp.
     */
    public static StringHelp help(final String value) {
        return new StringHelp(value);
    }
}
