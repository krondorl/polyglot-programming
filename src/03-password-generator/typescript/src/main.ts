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

// The node:crypto module provides cryptographically secure random numbers.
import * as crypto from "crypto";

const VOWELS = ["a", "e", "i", "o", "u"] as const;
const CONSONANTS = [
  "b",
  "c",
  "d",
  "f",
  "g",
  "h",
  "j",
  "k",
  "l",
  "m",
  "n",
  "p",
  "q",
  "r",
  "s",
  "t",
  "v",
  "w",
  "x",
  "y",
  "z",
] as const;
const NUMBERS = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"] as const;
const SPECIALS = ["!", "+", "#", "/", "$", "?"] as const;

function generateRandomRange(max: number): number {
  return crypto.randomInt(max);
}

function generateNumbers(length: number): string {
  if (length >= 1 && length <= 4) {
    const generatedNumbers: string[] = [];
    let i = 0;
    while (i < length) {
      let randomNumber = generateRandomRange(9);
      generatedNumbers.push(NUMBERS[randomNumber]);
      i += 1;
    }
    return generatedNumbers.join("");
  } else {
    return "Error by generating words: length parameter should be between 1 and 4.";
  }
}

function generateSpecials(): string {
  const randomRange = generateRandomRange(5);
  return SPECIALS[randomRange];
}

function generateWords(length: number): string {
  if (length >= 13 && length <= 64) {
    const generatedWords: string[] = [];
    let i = 0;
    while (i < length) {
      if (i % 2 === 0) {
        let randomConsonant = generateRandomRange(20);
        if (i === 0 || i % 4 === 0) {
          let uppercase = CONSONANTS[randomConsonant].toUpperCase();
          generatedWords.push(uppercase);
        } else {
          generatedWords.push(CONSONANTS[randomConsonant]);
        }
      } else {
        let randomVowel = generateRandomRange(4);
        generatedWords.push(VOWELS[randomVowel]);
      }
      i += 1;
    }
    return generatedWords.join("");
  } else {
    return "Error by generating words: length parameter should be between 13 and 64.";
  }
}

function generatePassword(length: number): string {
  if (length >= 13 && length <= 64) {
    let generatedPassword: string[] = [];
    let words = generateWords(length - 3);
    if (words.length > 0) {
      generatedPassword.push(words);
      let numbers = generateNumbers(2);
      if (numbers.length > 0) {
        generatedPassword.push(numbers);
        let specials = generateSpecials();
        generatedPassword.push(specials);
        return generatedPassword.join("");
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

function main() {
  console.log("Password generator");
  let p32 = generatePassword(32);
  console.log(p32);
}

main();
