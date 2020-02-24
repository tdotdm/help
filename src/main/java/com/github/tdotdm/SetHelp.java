package com.github.tdotdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetHelp extends Help {
    private final Set<?> value;

    public SetHelp(final Set<?> value) {
        validate(value);
        this.value = value;
    }

    public List<?> byChangingToList() {
        return new ArrayList<>(this.value);
    }
}
