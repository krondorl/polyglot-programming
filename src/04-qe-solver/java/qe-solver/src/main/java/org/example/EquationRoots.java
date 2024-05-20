/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

enum RootType {
    RealRoots,
    OnlyRoot,
    ImaginaryRoots,
    NoRoots
}

public class EquationRoots {
    RootType rootType;
    Double roots1;
    Double roots2;

    public EquationRoots(RootType rootType, Double roots1, Double roots2) {
        this.rootType = rootType;
        this.roots1 = roots1;
        this.roots2 = roots2;
    }
}
