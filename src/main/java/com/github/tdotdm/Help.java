package com.github.tdotdm;

public class Help<T> {
    protected final T value;

    public Help(final T value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot create Help from illegal argument.");
        }
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
