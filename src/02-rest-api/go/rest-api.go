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
	"net/http"

	"github.com/gin-gonic/gin"
)

func main() {
	fmt.Println("Rest API example")
	fmt.Println()
	fmt.Println("After the server has been started, try the following: GET /books")
	fmt.Println()

	r := gin.Default()

	books := []string{
		"Jane Austen: Pride and Prejudice",
		"George Orwell: 1984",
		"F. Scott Fitzgerald: The Great Gatsby",
	}

	r.GET("/books", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{"books": books})
	})

	r.Run(":3000")
}
