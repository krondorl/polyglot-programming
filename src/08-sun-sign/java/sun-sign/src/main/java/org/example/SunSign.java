/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

public class SunSign {
    String sign;
    int startMonth;
    int startDay;
    int endMonth;
    int endDay;

    SunSign(String sign, int startMonth, int startDay, int endMonth, int endDay) {
        this.sign = sign;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }
}