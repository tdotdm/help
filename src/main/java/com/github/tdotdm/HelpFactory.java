package com.github.tdotdm;

import java.util.List;
import java.util.Set;

/*
 * Factory to return various
 * helper classes.
 *
 * For example, HelpFactory.help("my_string");
 * will return the StringHelp class.
 * */
public abstract class HelpFactory {
    public static BooleanHelp help(final Boolean value) {
        return new BooleanHelp(value);
    }

    public static IntegerHelp help(final Integer value) {
        return new IntegerHelp(value);
    }

    public static ListHelp help(final List<?> value) {
        return new ListHelp(value);
    }

    public static SetHelp help(final Set<?> value) {
        return new SetHelp(value);
    }

    public static StringHelp help(final String value) {
        return new StringHelp(value);
    }
}
