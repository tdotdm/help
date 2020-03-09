package com.github.tdotdm;

public class Help<T> {
    protected final T value;

    public Help(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
