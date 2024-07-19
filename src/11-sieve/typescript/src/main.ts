/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

export function sieveOfEratosthenes(n: number): number[] {
  let sieveNumbers: boolean[] = [];
  if (n < 2) {
    return [];
  }
  for (let fillIndex = 0; fillIndex <= n; fillIndex++) {
    sieveNumbers[fillIndex] = true;
  }
  let squareRootOfN = Math.round(Math.sqrt(n));
  for (let arrayIndex = 2; arrayIndex <= squareRootOfN; arrayIndex++) {
    if (sieveNumbers[arrayIndex]) {
      let multsIndex = arrayIndex * arrayIndex;
      while (multsIndex <= n) {
        sieveNumbers[multsIndex] = false;
        multsIndex += arrayIndex;
      }
    }
  }
  let primes: number[] = [];
  for (let arrayIndex = 2; arrayIndex <= n; arrayIndex++) {
    if (sieveNumbers[arrayIndex]) {
      primes.push(arrayIndex);
    }
  }
  return primes;
}

export function sieveOfAtkin(limit: number): number[] {
  let sieve: boolean[] = [];
  sieve.fill(false, 0, limit);
  if (limit > 2) {
    sieve[2] = true;
  }
  if (limit > 3) {
    sieve[3] = true;
  }
  let x = 1;
  while (x * x <= limit) {
    let y = 1;
    while (y * y <= limit) {
      let n = 4 * x * x + y * y;
      if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
        sieve[n] = !sieve[n];
      }
      n = 3 * x * x + y * y;
      if (n <= limit && n % 12 == 7) {
        sieve[n] = !sieve[n];
      }
      n = 3 * x * x - y * y;
      if (x > y && n <= limit && n % 12 == 11) {
        sieve[n] = !sieve[n];
      }
      y += 1;
    }
    x += 1;
  }

  let r = 5;
  while (r * r < limit) {
    if (sieve[r]) {
      let i = r * r;
      while (i < limit) {
        sieve[i] = false;
        i += r * r;
      }
    }
    r += 1;
  }
  let primes: number[] = [];
  for (let primeIndex = 0; primeIndex < limit; primeIndex++) {
    if (sieve[primeIndex]) {
      primes.push(primeIndex);
    }
  }
  return primes;
}

function printSieve(n: number, sieve: string): void {
  if (n < 10) {
    console.log("Error: please give a n greater or equal than 10.");
    return;
  }
  console.log("***");
  console.log(`Sieve of ${sieve}`);
  let primes: number[] = [];
  switch (sieve) {
    case "Eratosthenes":
      primes = sieveOfEratosthenes(n);
      break;
    case "Atkin":
      primes = sieveOfAtkin(n);
      break;
    default:
      console.log(
        "Error: please select 'Atkin' or 'Eratosthenes' for the sieve algorithm."
      );
  }
  console.log(primes);
}

function main(): void {
  console.log("Prime Sieves");
  printSieve(100, "Eratosthenes");
  printSieve(100, "Atkin");
}

main();
