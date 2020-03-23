package com.github.tdotdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Utility class strictly concerned with a Set value.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
final class SetHelp extends Help<Set<?>> {
    /**
     * Constant to identify SetHelp through a String context.
     */
    public static final String IDENTIFIER = "SetHelp";

    SetHelp(final Set<?> value) {
        super(value);
    }

    /**
     * Convert SetHelp's value into a new List.
     *
     * @return A new List with the same entries as the class's value.
     */
    List<?> byChangingToList() {
        return new ArrayList<>(this.value);
    }
}
