/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

public class Result<T, E> {
    private final T val;
    private final E err;
    private final boolean ok;

    public Result(T val, E err, boolean ok) {
        this.val = val;
        this.err = err;
        this.ok = ok;
    }

    public T getVal() {
        return val;
    }

    public E getErr() {
        return err;
    }

    public boolean isOk() {
        return ok;
    }
}
