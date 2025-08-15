/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

use rand::prelude::*;

// General function which can draw multiple game types
// These lottery draws are popular in Hungary
// range # count
// 1..90 # 5
// 1..45 # 6
// 1..35 # 7
fn generate_draw(draw_type: &str) -> Result<Vec<i32>, String> {
    match draw_type {
        "five-number draw" | "six-number draw" | "seven-number draw" => {
            let mut drawn_numbers: Vec<i32> = Vec::new();
            let max_number: i32;
            let max_count: i32;

            match draw_type {
                "five-number draw" => {
                    max_number = 90;
                    max_count = 5;
                }
                "six-number draw" => {
                    max_number = 45;
                    max_count = 6;
                }
                "seven-number draw" => {
                    max_number = 35;
                    max_count = 7;
                }
                _ => {
                    max_number = 90;
                    max_count = 5;
                }
            }

            let mut rng: ThreadRng = thread_rng();
            loop {
                let random_number: i32 = rng.gen_range(1..max_number);

                if !drawn_numbers.contains(&random_number) {
                    drawn_numbers.push(random_number);
                }
                if drawn_numbers.len() == max_count as usize {
                    break;
                }
            }
            drawn_numbers.sort();
            Ok(drawn_numbers)
        }
        _ => {
            Err(String::from("Error: please choose between 'five-number draw' or 'six-number draw' or 'seven-number draw'."))
        }
    }
}

fn print_draw(draw_type: &str) {
    let draw = generate_draw(draw_type);
    match draw {
        Ok(val) => {
            let d = format!("{val:?}");
            println!("{d}");
        }
        Err(e) => println!("{e}"),
    }
}

fn main() {
    println!("Lottery draw");
    print_draw("wrong draw-y-x-");
    print_draw("five-number draw");
    print_draw("six-number draw");
    print_draw("seven-number draw");
}
