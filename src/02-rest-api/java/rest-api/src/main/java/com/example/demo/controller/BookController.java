/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    public BookController() {}

    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList(
            "Jane Austen: Pride and Prejudice",
            "George Orwell: 1984",
            "F. Scott Fitzgerald: The Great Gatsby"
        );
    }
}
