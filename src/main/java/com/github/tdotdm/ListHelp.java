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
public final class ListHelp extends Help<List<?>> {
    public ListHelp(final List<?> value) {
        super(value);
    }

    public List<?> byRemovingDuplicates() {
        final Set<?> valueSet = new HashSet<>(value);

        return new ArrayList<>(valueSet);
    }
}
