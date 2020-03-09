package com.github.tdotdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Class storing multiple
 * utility methods relating to
 * Set.
 * */
public final class SetHelp extends Help {
    private final Set<?> value;

    public SetHelp(final Set<?> value) {
        validate(value);
        this.value = value;
    }

    public final List<?> byChangingToList() {
        return new ArrayList<>(this.value);
    }
}
