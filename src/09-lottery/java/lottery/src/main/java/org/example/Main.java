/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

import java.util.*;

public class Main {
    public static List<Integer> generateDraw(String drawType) throws Exception {
        int maxNumber;
        int maxCount;

        switch (drawType) {
            case "five-number draw":
                maxNumber = 90;
                maxCount = 5;
                break;
            case "six-number draw":
                maxNumber = 45;
                maxCount = 6;
                break;
            case "seven-number draw":
                maxNumber = 35;
                maxCount = 7;
                break;
            default:
                throw new Exception("Error: please choose between 'five-number draw' or 'six-number draw' or 'seven-number draw'.");
        }

        List<Integer> drawnNumbers = new ArrayList<>();
        Random rng = new Random();

        while (drawnNumbers.size() < maxCount) {
            int randomNumber = rng.nextInt(maxNumber) + 1;
            if (!drawnNumbers.contains(randomNumber)) {
                drawnNumbers.add(randomNumber);
            }
        }

        Collections.sort(drawnNumbers);
        return drawnNumbers;
    }

    public static void printDraw(String drawType) {
        try {
            List<Integer> draw = generateDraw(drawType);
            System.out.println(draw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Lottery draw");
        printDraw("wrong draw-y-x-");
        printDraw("five-number draw");
        printDraw("six-number draw");
        printDraw("seven-number draw");
    }
}
