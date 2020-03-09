package com.github.tdotdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Class storing multiple
 * utility methods relating to
 * Set.
 * */
public final class SetHelp {
    private final Set<?> value;

    public SetHelp(final Set<?> value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public final List<?> byChangingToList() {
        return new ArrayList<>(this.value);
    }
}
