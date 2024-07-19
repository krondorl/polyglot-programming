/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

import { expect, test } from "vitest";
import { sieveOfEratosthenes, sieveOfAtkin } from "./main.js";

const primes100 = [
  2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
  73, 79, 83, 89, 97,
];

test("get primes until 100 with Eratosthenes", () => {
  expect(sieveOfEratosthenes(100)).toStrictEqual(primes100);
});

test("get primes until 100 with Atkin", () => {
  expect(sieveOfAtkin(100)).toStrictEqual(primes100);
});
