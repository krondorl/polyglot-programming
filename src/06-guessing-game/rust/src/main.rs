// I followed along
// Programming a Guessing Game in Rust!
// https://www.youtube.com/watch?v=H0xBSbnQYds
//
// Some modifications were needed:
// * parse
// * gen_range

use colored::*;
use rand::Rng;
use std::io;

fn main() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1..101);

    println!("The secret number is {secret_number}");

    loop {
        println!("Please input your guess");

        let mut guess = String::new();

        io::stdin()
            .read_line(&mut guess)
            .expect("Failed to read line");

        let guess = match guess.trim().parse::<u32>() {
            Ok(num) => num,
            Err(_) => continue,
        };

        println!("You guessed: {guess}");

        match guess.cmp(&secret_number) {
            std::cmp::Ordering::Less => println!("{}", "Too small!".red()),
            std::cmp::Ordering::Greater => println!("{}", "Too big!".red()),
            std::cmp::Ordering::Equal => {
                println!("{}", "You win!".green());
                break;
            }
        }
    }
}
