/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        System.out.println("Guess the number!");

        int secretNumber = getRandomInt(1, 101);
        System.out.println("The secret number is " + secretNumber);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please input your guess: ");
            String guessInput = scanner.nextLine().trim();

            int guess;
            try {
                guess = Integer.parseInt(guessInput);
            } catch (NumberFormatException e) {
                continue;
            }

            System.out.println("You guessed: " + guess);

            if (guess < secretNumber) {
                System.out.println("\u001B[31m" + "Too small!" + "\u001B[0m");
            } else if (guess > secretNumber) {
                System.out.println("\u001B[31m" + "Too big!" + "\u001B[0m");
            } else {
                System.out.println("\u001B[32m" + "You win!" + "\u001B[0m");
                break;
            }
        }

        scanner.close();
    }
}