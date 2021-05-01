package com.github.tdotdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Utility class strictly concerned
 * with a Set value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
public final class SetHelp extends Help<Set<?>> {
    SetHelp(final Set<?> value) {
        super(value);
    }

    /**
     * Convert SetHelp's value into a new List.
     *
     * @return A new List with the same entries as the class's value.
     */
    public List<?> byChangingToList() {
        return new ArrayList<>(this.value);
    }
}
