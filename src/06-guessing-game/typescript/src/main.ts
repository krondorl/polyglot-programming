/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

import * as readlineSync from "readline-sync";
import chalk from "chalk";

function getRandomInt(min: number, max: number): number {
  return Math.floor(Math.random() * (max - min)) + min;
}

function main() {
  console.log("Guess the number!");

  const secretNumber = getRandomInt(1, 101);
  console.log(`The secret number is ${secretNumber}`);

  while (true) {
    const guessInput = readlineSync.question("Please input your guess: ");

    const guess = parseInt(guessInput.trim(), 10);
    if (isNaN(guess)) {
      continue;
    }

    console.log(`You guessed: ${guess}`);

    if (guess < secretNumber) {
      console.log(chalk.red("Too small!"));
    } else if (guess > secretNumber) {
      console.log(chalk.red("Too big!"));
    } else {
      console.log(chalk.green("You win!"));
      break;
    }
  }
}

main();
