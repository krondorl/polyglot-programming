/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String getSunSign(int month, int day) throws Exception {
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            throw new Exception("invalid date");
        }

        List<SunSign> signs = new ArrayList<>();
        signs.add(new SunSign("Aquarius", 1, 20, 2, 18));
        signs.add(new SunSign("Pisces", 2, 19, 3, 20));
        signs.add(new SunSign("Aries", 3, 21, 4, 19));
        signs.add(new SunSign("Taurus", 4, 20, 5, 20));
        signs.add(new SunSign("Gemini", 5, 21, 6, 20));
        signs.add(new SunSign("Cancer", 6, 21, 7, 22));
        signs.add(new SunSign("Leo", 7, 23, 8, 22));
        signs.add(new SunSign("Virgo", 8, 23, 9, 22));
        signs.add(new SunSign("Libra", 9, 23, 10, 22));
        signs.add(new SunSign("Scorpio", 10, 23, 11, 21));
        signs.add(new SunSign("Sagittarius", 11, 22, 12, 21));
        signs.add(new SunSign("Capricorn", 12, 22, 1, 19));

        for (SunSign sign : signs) {
            if ((month == sign.startMonth && day >= sign.startDay) ||
                    (month == sign.endMonth && day <= sign.endDay)) {
                return sign.sign;
            }
        }
        return "";
    }

    public static void printSunSign(int month, int day) {
        try {
            String sign = getSunSign(month, day);
            System.out.println(sign);
        } catch (Exception e) {
            System.out.println("Error with getting sign for date (month " + month + ", day " + day + "): " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Calculate your Sun Sign");
        System.out.println();

        printSunSign(100, 17);
        printSunSign(70, 30);
        printSunSign(11, 25);
    }
}
