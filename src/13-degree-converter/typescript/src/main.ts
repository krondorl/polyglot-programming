/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

type Celsius = number;
type Fahrenheit = number;

function intoFahrenheit(degree: Celsius): Fahrenheit {
  return ((degree * 9) / 5 + 32) as Fahrenheit;
}

function intoCelsius(degree: Fahrenheit): Celsius {
  return (((degree - 32) * 5) / 9) as Celsius;
}

function main() {
  console.log("Celsius and Fahrenheit degrees converter");
  console.log();

  let c25 = intoFahrenheit(25);
  console.log(`25 °C equals to ${c25} °F`);

  let f77 = intoCelsius(77);
  console.log(`77 °F equals to ${f77} °C`);
}

main();
