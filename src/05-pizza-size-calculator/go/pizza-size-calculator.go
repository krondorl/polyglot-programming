/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package main

import (
	"errors"
	"fmt"
	"math"
)

type Pizza struct {
	Name        string
	DiameterCm  int
	PriceHuf    int
	AreaToPrice float64
}

func calculatePizzaSizes(pizzas []Pizza) ([]Pizza, error) {
	if len(pizzas) < 2 {
		return nil, errors.New("error: please set up at least 2 pizzas")
	}
	calcPizzas := make([]Pizza, len(pizzas))
	for i, pizza := range pizzas {
		pizzaPrice := float64(pizza.PriceHuf) / ((float64(pizza.DiameterCm) * float64(pizza.DiameterCm) * math.Pi) / 4.0)
		pizzaItem := Pizza{
			Name:        pizza.Name,
			DiameterCm:  pizza.DiameterCm,
			PriceHuf:    pizza.PriceHuf,
			AreaToPrice: pizzaPrice,
		}
		calcPizzas[i] = pizzaItem
	}
	return calcPizzas, nil
}

func main() {
	fmt.Println("Pizza Size Calculator")
	fmt.Println()

	pizzas := []Pizza{
		{
			Name:        "quattro formaggi",
			DiameterCm:  24,
			PriceHuf:    1995,
			AreaToPrice: 0.0,
		},
		{
			Name:        "quattro formaggi",
			DiameterCm:  32,
			PriceHuf:    3195,
			AreaToPrice: 0.0,
		},
		{
			Name:        "quattro formaggi",
			DiameterCm:  45,
			PriceHuf:    5395,
			AreaToPrice: 0.0,
		},
	}

	calculatedPizzas, err := calculatePizzaSizes(pizzas)
	if err != nil {
		// Handle error
		fmt.Println(err)
		return
	}

	if len(calculatedPizzas) > 0 {
		for _, pizza := range calculatedPizzas {
			fmt.Printf("Name: %s, Diameter: %d cm, Price: %d HUF, AreaToPrice: %.2f\n", pizza.Name, pizza.DiameterCm, pizza.PriceHuf, pizza.AreaToPrice)
		}
	}
}
