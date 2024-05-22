/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package main

import (
	"fmt"
	"math/rand"
	"sort"
	"time"
)

func generateDraw(drawType string) ([]int, string) {
	var maxNumber, maxCount int

	switch drawType {
	case "five-number draw":
		maxNumber = 90
		maxCount = 5
	case "six-number draw":
		maxNumber = 45
		maxCount = 6
	case "seven-number draw":
		maxNumber = 35
		maxCount = 7
	default:
		return nil, "Error: please choose between 'five-number draw' or 'six-number draw' or 'seven-number draw'."
	}

	rand.Seed(time.Now().UnixNano())
	drawnNumbers := make([]int, 0, maxCount)
	for len(drawnNumbers) < maxCount {
		randomNumber := rand.Intn(maxNumber) + 1
		if !contains(drawnNumbers, randomNumber) {
			drawnNumbers = append(drawnNumbers, randomNumber)
		}
	}

	sort.Ints(drawnNumbers)
	return drawnNumbers, ""
}

func contains(slice []int, item int) bool {
	for _, v := range slice {
		if v == item {
			return true
		}
	}
	return false
}

func printDraw(drawType string) {
	draw, err := generateDraw(drawType)
	if err != "" {
		fmt.Println(err)
	} else {
		fmt.Println(draw)
	}
}

func main() {
	fmt.Println("Lottery draw")
	printDraw("wrong draw-y-x-")
	printDraw("five-number draw")
	printDraw("six-number draw")
	printDraw("seven-number draw")
}
