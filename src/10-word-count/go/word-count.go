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
	"os"
	"strings"
)

func countWords(fileName string) (int, error) {
	file, err := os.Open(fileName)
	if err != nil {
		return 0, err
	}
	defer file.Close()

	count := 0
	scanner := bufio.NewScanner(file)

	for scanner.Scan() {
		line := scanner.Text()
		splitLine := strings.Fields(line)
		count += len(splitLine)
	}

	if err := scanner.Err(); err != nil {
		return 0, err
	}

	return count, nil
}

func main() {
	fmt.Println("Count total words sum")
	fmt.Println()

	count, err := countWords("enchiridion-hun.txt")
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Printf("Total words: %d\n", count)
	}
}
