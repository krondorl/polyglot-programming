/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

use std::{
    fs::File,
    io::{BufRead, BufReader},
};

fn count_words(filepath: &str) -> Result<usize, Box<dyn std::error::Error>> {
    let mut count: usize = 0;
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);

    for line in reader.lines() {
        match line {
            Ok(val) => {
                count += val.split_whitespace().count();
            }
            Err(err) => {
                println!("Error when matching lines {err}");
            }
        }
    }

    Ok(count)
}

fn main() {
    println!("Count total words sum");
    println!();
    // Example file
    let count = count_words("enchiridion-hun.txt");
    match count {
        Ok(val) => println!("Total word count: {val}"),
        Err(err) => println!("Error when counting words: {err}"),
    }
}
