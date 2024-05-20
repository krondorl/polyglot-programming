/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

/*!
 *  This code is based on my Arcanus Psw project.
 *
 *  https://github.com/krondorl/arcanus-psw
 *
 *  Copyright (c) 2023 Adam Burucs. MIT license.
 */

package org.example;

import java.security.SecureRandom;

public class RandomGenerator {
    private static final String[] VOWELS = {"a", "e", "i", "o", "u"};
    private static final String[] CONSONANTS = {
            "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n",
            "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"
    };
    private static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] SPECIALS = {"!", "+", "#", "/", "$", "?"};

    private static final SecureRandom random = new SecureRandom();

    public static int generateRandomRange(int max) {
        return random.nextInt(max);
    }

    public static String generateNumbers(int length) {
        if (length >= 1 && length <= 4) {
            StringBuilder generatedNumbers = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int randomNumber = generateRandomRange(9);
                generatedNumbers.append(NUMBERS[randomNumber]);
            }
            return generatedNumbers.toString();
        } else {
            return "Error by generating words: length parameter should be between 1 and 4.";
        }
    }

    public static String generateWords(int length) {
        if (length >= 13 && length <= 64) {
            StringBuilder generatedWords = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    int randomConsonant = generateRandomRange(19);
                    if (i == 0 || i % 4 == 0) {
                        String uppercase = CONSONANTS[randomConsonant].toUpperCase();
                        generatedWords.append(uppercase);
                    } else {
                        generatedWords.append(CONSONANTS[randomConsonant]);
                    }
                } else {
                    int randomVowel = generateRandomRange(4);
                    generatedWords.append(VOWELS[randomVowel]);
                }
            }
            return generatedWords.toString();
        } else {
            return "Error by generating words: length parameter should be between 13 and 64.";
        }
    }

    public static String generateSpecials() {
        int randomRange = generateRandomRange(SPECIALS.length - 1);
        return SPECIALS[randomRange];
    }

    public static String generatePassword(int length) {
        if (length >= 16 && length <= 64) {
            StringBuilder generatedPassword = new StringBuilder();
            String words = generateWords(length - 3);
            if (words.length() > 0) {
                generatedPassword.append(words);
                String numbers = generateNumbers(2);
                if (numbers.length() > 0) {
                    generatedPassword.append(numbers);
                    String specials = generateSpecials();
                    generatedPassword.append(specials);
                    return generatedPassword.toString();
                } else {
                    return "Error: wrong numbers length when using generatePassword function.";
                }
            } else {
                return "Error: wrong words length when using generatePassword function.";
            }
        } else {
            return "Error: generate password should have a length between 16 and 64.";
        }
    }
}
