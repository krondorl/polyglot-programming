package main

import (
	"fmt"
	"math"
)

// Generic return types are not yet supported in Go such as in TypeScript
// or Rust
func calculate_dog_age(age uint) uint {
  if age < 1 {
    return 0
  }
  age_value := math.Round(16*math.Log(float64(age)) + 31)
  return uint(age_value)
}

func main() {
  fmt.Println("Dog Age Calculator")
  age := 1
  dog_age := calculate_dog_age(uint(age));
  if dog_age > 0 {
    fmt.Printf("Dog age %d in human years is %d\n", age, dog_age)
  }
  if dog_age == 0 {
    fmt.Println("Error: age should be at least 1.");
  }
}
