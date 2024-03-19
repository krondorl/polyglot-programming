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
	"math"
)

// Enum equivalent in Go using iota
type RootType int

const (
	RealRoots RootType = iota
	OnlyRoot
	ImaginaryRoots
	NoRoots
)

// Interface to simulate TypeScript's union type (number | string)
type RootValue interface{}

// Struct equivalent to the TypeScript interface
type EquationRoots struct {
	RootType RootType
	Roots1   RootValue
	Roots2   RootValue
}

func solveQe(a, b, c float64) EquationRoots {
	discriminant := b*b - 4*a*c
	if discriminant > 0 {
		x1 := (-b + math.Sqrt(discriminant)) / (2 * a)
		x2 := (-b - math.Sqrt(discriminant)) / (2 * a)
		return EquationRoots{
			RootType: RealRoots,
			Roots1:   x1,
			Roots2:   x2,
		}
	} else if discriminant == 0 {
		x1 := -b / (2 * a)
		return EquationRoots{
			RootType: OnlyRoot,
			Roots1:   x1,
		}
	} else if discriminant < 0 {
		denominator := 2 * a
		realPart := -b / denominator
		imaginaryResult := math.Sqrt(math.Abs(discriminant)) / denominator

		root1 := fmt.Sprintf("%v + %vi", realPart, imaginaryResult)
		root2 := fmt.Sprintf("%v - %vi", realPart, imaginaryResult)

		return EquationRoots{
			RootType: ImaginaryRoots,
			Roots1:   root1,
			Roots2:   root2,
		}
	} else {
		return EquationRoots{
			RootType: NoRoots,
		}
	}
}

func printSolver(a, b, c float64) {
	solutions := solveQe(a, b, c)
	fmt.Printf("%.2fx^2 + %.2fx + %.2f = 0\n", a, b, c)

	switch solutions.RootType {
	case RealRoots:
		fmt.Println("Roots are real and distinct")
		fmt.Printf("Root1 = %v\n", solutions.Roots1)
		fmt.Printf("Root2 = %v\n", solutions.Roots2)
	case ImaginaryRoots:
		fmt.Println("Imaginary Roots")
		fmt.Printf("Root1 = %v\n", solutions.Roots1)
		fmt.Printf("Root2 = %v\n", solutions.Roots2)
	case OnlyRoot:
		fmt.Println("There is only one root")
		fmt.Printf("Root = %v\n", solutions.Roots1)
	case NoRoots:
		fmt.Println("No roots for given parameters.")
	}

	fmt.Println()
	fmt.Println("***")
	fmt.Println()
}

func main() {
	fmt.Println("Quadratic equation solver")
	fmt.Println()
	fmt.Println()
	printSolver(4.0, 3.0, 2.0)
	printSolver(1.0, -8.0, 5.0)
	printSolver(-4.0, 12.0, -9.0)
}
