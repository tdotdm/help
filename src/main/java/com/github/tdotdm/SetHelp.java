package com.github.tdotdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Class storing multiple
 * utility methods relating to
 * Set.
 * */
public final class SetHelp extends Help<Set<?>> {
    public SetHelp(final Set<?> value) {
        super(value);
    }

    public List<?> byChangingToList() {
        return new ArrayList<>(this.value);
    }
}
