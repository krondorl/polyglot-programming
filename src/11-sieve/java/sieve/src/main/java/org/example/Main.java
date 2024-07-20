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
    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Boolean> sieveNumbers = new ArrayList<>();
        if (n < 2) {
            return new ArrayList<>();
        }
        for (int fillIndex = 0; fillIndex <= n; fillIndex++) {
            sieveNumbers.add(true);
        }
        int squareRootOfN = (int) Math.round(Math.sqrt(n));
        for (int arrayIndex = 2; arrayIndex <= squareRootOfN; arrayIndex++) {
            if (sieveNumbers.get(arrayIndex)) {
                int multsIndex = arrayIndex * arrayIndex;
                while (multsIndex <= n) {
                    sieveNumbers.set(multsIndex, false);
                    multsIndex += arrayIndex;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int arrayIndex = 2; arrayIndex <= n; arrayIndex++) {
            if (sieveNumbers.get(arrayIndex)) {
                primes.add(arrayIndex);
            }
        }
        return primes;
    }

    public static List<Integer> sieveOfAtkin(int limit) {
        List<Boolean> sieve = new ArrayList<>();
        for (int fillIndex = 0; fillIndex <= limit; fillIndex++) {
            sieve.add(false);
        }
        if (limit > 2) {
            sieve.set(2, true);
        }
        if (limit > 3) {
            sieve.set(3, true);
        }
        int x = 1;
        while (x * x <= limit) {
            int y = 1;
            while (y * y <= limit) {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    sieve.set(n, !sieve.get(n));
                }
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7) {
                    sieve.set(n, !sieve.get(n));
                }
                n = 3 * x * x - y * y;
                if (x > y && n <= limit && n % 12 == 11) {
                    sieve.set(n, !sieve.get(n));
                }
                y += 1;
            }
            x += 1;
        }

        int r = 5;
        while (r * r < limit) {
            if (sieve.get(r)) {
                int i = r * r;
                while (i < limit) {
                    sieve.set(i, false);
                    i += r * r;
                }
            }
            r += 1;
        }
        List<Integer> primes = new ArrayList<>();
        for (int primeIndex = 0; primeIndex < limit; primeIndex++) {
            if (sieve.get(primeIndex)) {
                primes.add(primeIndex);
            }
        }
        return primes;
    }

    public static void printSieve(int n, String sieve) {
        if (n < 10) {
            System.out.println("Error: please give a n greater or equal than 10.");
            return;
        }
        System.out.println("***");
        System.out.println("Sieve of " + sieve);

        List<Integer> primes = new ArrayList<>();

        switch (sieve) {
            case "Eratosthenes":
                primes = sieveOfEratosthenes(n);
                break;
            case "Atkin":
                primes = sieveOfAtkin(n);
                break;
            default:
                System.out.println("Error: please select 'Atkin' or 'Eratosthenes' for the sieve algorithm.");
        }
        System.out.println(primes);
    }

    public static void main(String[] args) {
        System.out.println("Prime Sieves");
        printSieve(100, "Eratosthenes");
        printSieve(100, "Atkin");
    }
}