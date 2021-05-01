package com.github.tdotdm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility class strictly concerned
 * with a List value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
public final class ListHelp extends Help<List<?>> {
    ListHelp(final List<?> value) {
        super(value);
    }

    /**
     * Remove duplicate entries from ListHelp's value
     *
     * @return A new List containing unique entries of ListHelp's value.
     */
    public List<?> byRemovingDuplicates() {
        final Set<?> valueSet = new HashSet<>(value);

        return new ArrayList<>(valueSet);
    }
}
