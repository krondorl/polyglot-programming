/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Pizza> calculatePizzaSizes(List<Pizza> pizzas) {
        if (pizzas == null || pizzas.size() < 2) {
            System.out.println("Error: please set up at least 2 pizzas.");
            return null;
        }

        List<Pizza> calcPizzas = new ArrayList<>();
        for (Pizza pizza : pizzas) {
            double pizzaPrice = pizza.priceHuf / ((pizza.diameterCm * pizza.diameterCm * Math.PI) / 4.0);
            Pizza pizzaItem = new Pizza(pizza.name, pizza.diameterCm, pizza.priceHuf, pizzaPrice);
            calcPizzas.add(pizzaItem);
        }

        return calcPizzas;
    }

    public static void main(String[] args) {
        System.out.println("Pizza Size Calculator");
        System.out.println();

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("quattro formaggi", 24, 1995, 0.0));
        pizzas.add(new Pizza("quattro formaggi", 32, 3195, 0.0));
        pizzas.add(new Pizza("quattro formaggi", 45, 5395, 0.0));

        List<Pizza> calcPizzas = calculatePizzaSizes(pizzas);

        if (calcPizzas != null && calcPizzas.size() > 0) {
            for (Pizza pizza : calcPizzas) {
                System.out.println(pizza.toString());
            }
        } else {
            System.out.println(calcPizzas);
        }
    }
}