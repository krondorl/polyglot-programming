/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

public class QuadraticEquationSolver {
    public static EquationRoots solveQe(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            return new EquationRoots(RootType.RealRoots, x1, x2);
        } else if (discriminant == 0) {
            double x1 = -b / (2 * a);
            return new EquationRoots(RootType.OnlyRoot, x1, null);
        } else if (discriminant < 0) {
            double denominator = 2 * a;
            double realPart = -b / (2 * a);
            double imaginaryResult = Math.sqrt(Math.abs(discriminant)) / denominator;
            return new EquationRoots(RootType.ImaginaryRoots, realPart + imaginaryResult, realPart - imaginaryResult);
        } else {
            return new EquationRoots(RootType.NoRoots, null, null);
        }
    }

    public static void printSolver(double a, double b, double c) {
        EquationRoots solutions = solveQe(a, b, c);
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");

        switch (solutions.rootType) {
            case RealRoots:
                System.out.println("Roots are real and distinct");
                System.out.println("Root1 = " + solutions.roots1);
                System.out.println("Root2 = " + solutions.roots2);
                break;
            case ImaginaryRoots:
                System.out.println("Imaginary Roots");
                System.out.println("Root1 = " + solutions.roots1);
                System.out.println("Root2 = " + solutions.roots2);
                break;
            case OnlyRoot:
                System.out.println("There is only one root");
                System.out.println("Root = " + solutions.roots1);
                break;
            case NoRoots:
                System.out.println("No roots for given parameters.");
                break;
        }

        System.out.println();
        System.out.println("***");
        System.out.println();
    }
}
