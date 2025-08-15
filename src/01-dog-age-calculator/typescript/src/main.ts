/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

type AgeResult = number | string;

function calculate_dog_age(age: number): AgeResult {
  if (age < 1) {
    return "Error: age should be at least 1.";
  }
  return Math.round(16 * Math.log(age) + 31);
}

function main() {
  console.log("Dog Age Calculator");
  let age = 1;
  let dog_age = calculate_dog_age(age);
  if (typeof dog_age === "number") {
    console.log(`Dog age ${age} in human years is ${dog_age}`);
  }
  if (typeof dog_age === "string") {
    console.log(`${dog_age}`); // print error
  }
}

main();
