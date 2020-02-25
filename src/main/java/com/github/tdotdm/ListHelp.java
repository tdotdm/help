package com.github.tdotdm;

import java.util.List;

public class ListHelp extends Help {
    private final List<?> value;

    public ListHelp(final List<?> value) {
        validate(value);
        this.value = value;
    }
}
