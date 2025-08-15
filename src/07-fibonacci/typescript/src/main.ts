/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

function fibonacci(n: number): Result<number[], string> {
  let fibNumbers = [1, 1];
  let prevPrevIndex = 0;
  if (n < 1) {
    return {
      ok: false,
      err: "Error: Wrong input number, it should be greater or equal than 1.",
    };
  }
  if (n === 1 || n === 2) {
    return { ok: true, val: fibNumbers };
  }
  for (let i = 3; i <= n; i++) {
    fibNumbers.push(fibNumbers[prevPrevIndex] + fibNumbers[prevPrevIndex + 1]);
    prevPrevIndex++;
  }
  return { ok: true, val: fibNumbers };
}

interface Result<T, E> {
  ok: boolean;
  val?: T;
  err?: E;
}

function main() {
  console.log("Fibonacci sequence in TypeScript");
  const fibNumbers = fibonacci(10);
  if (fibNumbers.ok) {
    console.log(fibNumbers.val);
  } else {
    console.log(fibNumbers.err);
  }
}

main();
