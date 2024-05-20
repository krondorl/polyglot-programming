/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

import static org.example.QuadraticEquationSolver.printSolver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Quadratic equation solver");
        System.out.println();
        printSolver(4.0, 3.0, 2.0);
        printSolver(1.0, -8.0, 5.0);
        printSolver(-4.0, 12.0, -9.0);
    }
}