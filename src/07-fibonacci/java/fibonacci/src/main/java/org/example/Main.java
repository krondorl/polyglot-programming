/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Result<List<Integer>, String> fibonacci(int n) {
        List<Integer> fibNumbers = new ArrayList<>();
        fibNumbers.add(1);
        fibNumbers.add(1);
        if (n < 1) {
            return new Result<>(null, "Error: Wrong input number, it should be greater or equal than 1.", false);
        }
        if (n == 1 || n == 2) {
            return new Result<>(fibNumbers, null, true);
        }
        for (int i = 3; i <= n; i++) {
            fibNumbers.add(fibNumbers.get(fibNumbers.size() - 2) + fibNumbers.get(fibNumbers.size() - 1));
        }
        return new Result<>(fibNumbers, null, true);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci sequence in Java");
        Result<List<Integer>, String> fibNumbers = fibonacci(10);
        if (fibNumbers.isOk()) {
            System.out.println(fibNumbers.getVal());
        } else {
            System.out.println(fibNumbers.getErr());
        }
    }
}