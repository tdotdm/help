package com.github.tdotdm;

public abstract class Help {
    public static StringHelp help(final String value) {
        return new StringHelp(value);
    }

    protected void validate(final Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                throw new HelpException("Cannot create Help with illegal arguments!");
            }
        }
    }
}
