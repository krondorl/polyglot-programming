/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

fn fibonacci(n: u32) -> Result<Vec<u32>, String> {
    let mut fib_numbers = vec![1, 1];
    let _prev_prev_index = 0;
    match n {
        0 => {
            return Err(String::from(
                "Error: Wrong input number, it should be greater or equal than 1.",
            ))
        }
        1 | 2 => return Ok(fib_numbers),
        3_u32..=u32::MAX => {
            for (prev_prev_index, _i) in (3..n).enumerate() {
                fib_numbers.push(fib_numbers[prev_prev_index] + fib_numbers[prev_prev_index + 1]);
            }
        }
    }
    Ok(fib_numbers)
}

fn main() {
    println!("Fibonacci sequence in Rust");
    let fib_numbers = fibonacci(10);
    match fib_numbers {
        Ok(val) => {
            let s = format!("{val:?}");
            println!("{s}");
        }
        Err(e) => println!("{e}"),
    }
}
