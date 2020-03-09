package com.github.tdotdm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Class storing multiple
 * utility methods relating to
 * List.
 * */
public final class ListHelp extends Help {
    private final List<?> value;

    public ListHelp(final List<?> value) {
        validate(value);
        this.value = value;
    }

    public final List<?> byRemovingDuplicates() {
        final Set<?> valueSet = new HashSet<>(value);

        return new ArrayList<>(valueSet);
    }
}
