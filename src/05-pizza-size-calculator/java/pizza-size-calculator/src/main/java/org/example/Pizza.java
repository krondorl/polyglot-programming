/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

public class Pizza {
    String name;
    int diameterCm;
    double priceHuf;
    double areaToPrice;

    public Pizza(String name, int diameterCm, double priceHuf, double areaToPrice) {
        this.name = name;
        this.diameterCm = diameterCm;
        this.priceHuf = priceHuf;
        this.areaToPrice = areaToPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", diameterCm=" + diameterCm +
                ", priceHuf=" + priceHuf +
                ", areaToPrice=" + areaToPrice +
                '}';
    }
}