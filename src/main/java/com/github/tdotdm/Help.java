package com.github.tdotdm;

/**
 * The core entity of Help.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
abstract class Help<T> {
    /**
     * The value all subsequent method
     * calls will interact with.
     */
    protected final T value;

    /**
     * Create a new instance of Help.
     *
     * @param value The value all subsequent method calls will interact with.
     */
    Help(final T value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot create Help from illegal argument.");
        }
        this.value = value;
    }

    /**
     * Return Help's generic Value.
     *
     * @return The Help's generic Value.
     */
    T getValue() {
        return this.value;
    }
}
