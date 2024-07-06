/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static int countWords(String fileName) throws IOException {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" ");
                count += splitLine.length;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Count total words sum");
        System.out.println();

        try {
            int count = countWords("enchiridion-hun.txt");
            System.out.println("Total words: " + count);
        } catch (IOException error) {
            System.err.println("An error occurred: " + error.getMessage());
        }
    }
}
