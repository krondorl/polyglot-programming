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
)

func fibonacci(n uint) ([]uint, error) {
	if n < 1 {
		return nil, errors.New("Error: Wrong input number, it should be greater or equal than 1.")
	}

	fibNumbers := []uint{1, 1}
	if n == 1 || n == 2 {
		return fibNumbers, nil
	}

	for i := uint(3); i <= n; i++ {
		fibNumbers = append(fibNumbers, fibNumbers[i-3]+fibNumbers[i-2])
	}

	return fibNumbers, nil
}

func main() {
	fmt.Println("Fibonacci sequence in Go")
	fibNumbers, err := fibonacci(10)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(fibNumbers)
	}
}
