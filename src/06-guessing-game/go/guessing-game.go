/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"time"
)

func getRandomInt(min, max int) int {
	return rand.Intn(max-min) + min
}

func main() {
	rand.Seed(time.Now().UnixNano())
	fmt.Println("Guess the number!")

	secretNumber := getRandomInt(1, 101)
	fmt.Printf("The secret number is %d\n", secretNumber)

	reader := bufio.NewReader(os.Stdin)

	for {
		fmt.Print("Please input your guess: ")

		guessInput, _ := reader.ReadString('\n')
		guessInput = strings.TrimSpace(guessInput)

		guess, err := strconv.Atoi(guessInput)
		if err != nil {
			continue
		}

		fmt.Printf("You guessed: %d\n", guess)

		if guess < secretNumber {
			fmt.Println("Too small!")
		} else if guess > secretNumber {
			fmt.Println("Too big!")
		} else {
			fmt.Println("You win!")
			break
		}
	}
}
