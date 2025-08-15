/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

interface Pizza {
  name: string;
  diameterCm: number;
  priceHuf: number;
  areaToPrice: number;
}

type PizzaError = string;

function calculatePizzaSizes(pizzas: Pizza[]): Pizza[] | PizzaError {
  if (pizzas?.length < 2) {
    return "Error: please set up at least 2 pizzas.";
  }
  const calcPizzas: Pizza[] = [];
  for (let pizza of pizzas) {
    let pizzaPrice =
      pizza.priceHuf / ((pizza.diameterCm * pizza.diameterCm * Math.PI) / 4.0);
    let pizzaItem: Pizza = {
      name: pizza.name,
      diameterCm: pizza.diameterCm,
      priceHuf: pizza.priceHuf,
      areaToPrice: pizzaPrice,
    };
    calcPizzas.push(pizzaItem);
  }

  return calcPizzas;
}

function main() {
  console.log("Pizza Size Calculator");
  console.log();

  let pizzas: Pizza[] = [
    {
      name: "quattro formaggi",
      diameterCm: 24,
      priceHuf: 1995,
      areaToPrice: 0.0,
    },
    {
      name: "quattro formaggi",
      diameterCm: 32,
      priceHuf: 3195,
      areaToPrice: 0.0,
    },
    {
      name: "quattro formaggi",
      diameterCm: 45,
      priceHuf: 5395,
      areaToPrice: 0.0,
    },
  ];

  const calcPizzas = calculatePizzaSizes(pizzas);

  if (calcPizzas?.length > 0) {
    console.table(calcPizzas);
  } else {
    console.log(calcPizzas);
  }
}

main();
