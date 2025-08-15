/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

public class Main {
    public static double intoFahrenheit(double degree) {
        return (degree * 9 / 5) + 32;
    }

    public static double intoCelsius(double degree) {
        return ((degree - 32) * 5) / 9;
    }

    public static void main(String[] args) {
        System.out.printf("Celsius and Fahrenheit degrees converter");
        System.out.println();

        double c25 = intoFahrenheit(25);
        System.out.println("25 °C equals to " + c25 + " °F");

        double f77 = intoCelsius(77);
        System.out.println("77 °F equals to " + f77 + " °C");
    }
}