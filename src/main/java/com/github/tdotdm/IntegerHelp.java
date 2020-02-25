package com.github.tdotdm;

public class IntegerHelp extends Help {
    private final Integer value;

    public IntegerHelp(final Integer value) {
        validate(value);
        this.value = value;
    }
}
