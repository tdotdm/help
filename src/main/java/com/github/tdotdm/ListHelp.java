package com.github.tdotdm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListHelp extends Help {
    private final List<?> value;

    public ListHelp(final List<?> value) {
        validate(value);
        this.value = value;
    }

    public List<?> byRemovingDuplicates() {
        final Set<?> valueSet = new HashSet<>(value);

        return new ArrayList<>(valueSet);
    }
}
