/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

package main

import (
	"errors"
	"fmt"
)

type SunSign struct {
	Sign       string
	StartMonth int
	StartDay   int
	EndMonth   int
	EndDay     int
}

func getSunSign(month, day int) (string, error) {
	if day < 1 || day > 31 || month < 1 || month > 12 {
		return "", errors.New("invalid date")
	}

	signs := []SunSign{
		{"Aquarius", 1, 20, 2, 18},
		{"Pisces", 2, 19, 3, 20},
		{"Aries", 3, 21, 4, 19},
		{"Taurus", 4, 20, 5, 20},
		{"Gemini", 5, 21, 6, 20},
		{"Cancer", 6, 21, 7, 22},
		{"Leo", 7, 23, 8, 22},
		{"Virgo", 8, 23, 9, 22},
		{"Libra", 9, 23, 10, 22},
		{"Scorpio", 10, 23, 11, 21},
		{"Sagittarius", 11, 22, 12, 21},
		{"Capricorn", 12, 22, 1, 19},
	}

	for _, sign := range signs {
		if (month == sign.StartMonth && day >= sign.StartDay) ||
			(month == sign.EndMonth && day <= sign.EndDay) {
			return sign.Sign, nil
		}
	}
	return "", nil
}

func printSunSign(month, day int) {
	sign, err := getSunSign(month, day)
	if err != nil {
		fmt.Printf("Error with getting sign for date (month %d, day %d): %s\n", month, day, err.Error())
		return
	}
	fmt.Println(sign)
}

func main() {
	fmt.Println("Calculate your Sun Sign")
	fmt.Println()

	printSunSign(100, 17)
	printSunSign(70, 30)
	printSunSign(11, 25)
}
