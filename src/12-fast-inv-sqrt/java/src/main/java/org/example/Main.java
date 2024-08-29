/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

// Based on Kulshrestha's C code
// Licensed under the do whatever the fuck you wanna do public licence.
// (c) Samarth Kulshrestha, 2021
// https://github.com/samarthkulshrestha/fast_inverse_square_root

package org.example;

public class Main {
    public static float fastInvSqrt(float number) {
        int i = Float.floatToRawIntBits(number);
        float x2 = number * 0.5F;
        float y;
        final float THREE_HALVES = 1.5F;

        i = 0x5f3759df - (i >> 1);
        y = Float.intBitsToFloat(i);
        y = y * (THREE_HALVES - (x2 * y * y));
        y = y * (THREE_HALVES - (x2 * y * y));

        return y;
    }

    public static void printSqrtHelper(float number) {
        System.out.println("fastInvSqrt(" + number + ") = " + fastInvSqrt(number));
    }

    public static void main(String[] args) {
        System.out.println("Fast inverse square root");
        System.out.println();
        printSqrtHelper(2.0F);
        printSqrtHelper(4.0F);
        printSqrtHelper(10.0F);
    }
}