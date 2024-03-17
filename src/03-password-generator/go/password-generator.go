/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

/*!
 *  This code is based on my Arcanus Psw project.
 *
 *  https://github.com/krondorl/arcanus-psw
 *
 *  Copyright (c) 2023 Adam Burucs. MIT license.
 */

package main

import (
	"fmt"
	"math/rand"
	"strings"
	"time"
)

var VOWELS = []string{"a", "e", "i", "o", "u"}
var CONSONANTS = []string{
	"b", "c", "d", "f", "g", "h", "j", "k", "l", "m",
	"n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z",
}
var NUMBERS = []string{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
var SPECIALS = []string{"!", "+", "#", "/", "$", "?"}

func generateRandomRange(min, max uint8) uint8 {
	rand.Seed(time.Now().UnixNano())
	return uint8(rand.Intn(int(max)-int(min)+1) + int(min))
}

func generateNumbers(length uint8) string {
	if length >= 1 && length <= 4 {
		generatedNumbers := make([]string, 0)
		var i uint8 = 0
		for i < length {
			randomNumber := generateRandomRange(0, 9)
			generatedNumbers = append(generatedNumbers, NUMBERS[randomNumber])
			i += 1
		}
		return strings.Join(generatedNumbers, "")
	} else {
		return "Error by generating words: length parameter should be between 1 and 4."
	}
}

func generateSpecials() string {
	randomRange := generateRandomRange(0, 5)
	return SPECIALS[randomRange]
}

func generateWords(length uint8) string {
	if length >= 13 && length <= 64 {
		generatedWords := make([]string, 0)
		var i uint8 = 0
		for i < length {
			if i%2 == 0 {
				var randomConsonant uint8 = generateRandomRange(0, 20)
				if i == 0 || i%4 == 0 {
					var uppercase string = strings.ToUpper(CONSONANTS[randomConsonant])
					generatedWords = append(generatedWords, uppercase)
				} else {
					generatedWords = append(generatedWords, CONSONANTS[randomConsonant])
				}
			} else {
				var randomVowel uint8 = generateRandomRange(0, 4)
				generatedWords = append(generatedWords, VOWELS[randomVowel])
			}
			i += 1
		}
		return strings.Join(generatedWords, "")
	} else {
		return "Error by generating words: length parameter should be between 13 and 64."
	}
}

func generatePassword(length uint8) string {
	if length >= 13 && length <= 64 {
		generatedPassword := make([]string, 0)
		var words string = generateWords(length - 3)
		if len(words) > 0 {
			generatedPassword = append(generatedPassword, words)
			var numbers string = generateNumbers(2)
			if len(numbers) > 0 {
				generatedPassword = append(generatedPassword, numbers)
				var specials string = generateSpecials()
				generatedPassword = append(generatedPassword, specials)
				return strings.Join(generatedPassword, "")
			} else {
				return "Error: wrong numbers length when using generatePassword function."
			}
		} else {
			return "Error: wrong words length when using generatePassword function."
		}
	} else {
		return "Error: generate password should have a length between 16 and 64."
	}
}

func main() {
	fmt.Println("Password generator")
	p32 := generatePassword(32) // entropy seems low, @todo refactor
	fmt.Println(p32)            // eg. MemeMemeMemeMemeMemeMemeMemeM77/
}
