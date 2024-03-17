/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

/*!
 *  This code is based on my Arcanus Psw project.
 *
 *  https://github.com/krondorl/arcanus-psw
 *
 *  Copyright (c) 2023 Adam Burucs. MIT license.
 */

use rand::Rng;

const VOWELS: [&str; 5] = ["a", "e", "i", "o", "u"];
const CONSONANTS: [&str; 21] = [
    "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x",
    "y", "z",
];
const NUMBERS: [&str; 10] = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
const SPECIALS: [&str; 6] = ["!", "+", "#", "/", "$", "?"];

fn generate_numbers(length: u8) -> Result<String, String> {
    if (1..=4).contains(&length) {
        let mut generated_numbers: String = Default::default();
        let mut i = 0;
        while i < length {
            let random_number = rand::thread_rng().gen_range(0..9);
            generated_numbers.push_str(NUMBERS[random_number]);
            i += 1;
        }
        Ok(generated_numbers)
    } else {
        Err(String::from(
            "Error by generating words: length parameter should be between 1 and 4.",
        ))
    }
}

fn generate_specials() -> String {
    let random_special = rand::thread_rng().gen_range(0..5);
    SPECIALS[random_special].to_string()
}

fn generate_words(length: u8) -> Result<String, String> {
    if (13..=64).contains(&length) {
        let mut generated_words: String = Default::default();
        let mut i = 0;
        while i < length {
            if i % 2 == 0 {
                let random_consonant = rand::thread_rng().gen_range(0..20);
                if i == 0 || i % 4 == 0 {
                    let uppercase = str::to_uppercase(CONSONANTS[random_consonant]);
                    generated_words.push_str(&uppercase);
                } else {
                    generated_words.push_str(CONSONANTS[random_consonant]);
                }
            } else {
                let random_vowel = rand::thread_rng().gen_range(0..4);
                generated_words.push_str(VOWELS[random_vowel]);
            }
            i += 1;
        }
        Ok(generated_words)
    } else {
        Err(String::from(
            "Error by generating words: length parameter should be between 13 and 64.",
        ))
    }
}

fn generate_password(length: Option<u8>) -> Result<String, String> {
    match length {
        Some(length_value) => {
            if (16..=64).contains(&length_value) {
                let mut generated_password: String = Default::default();
                let words = generate_words(length_value - 3);
                match words {
                    Ok(words_value) => {
                        generated_password.push_str(&words_value);
                        let numbers = generate_numbers(2);
                        match numbers {
                            Ok(numbers_value) => {
                                generated_password.push_str(&numbers_value);
                                let specials = generate_specials();
                                generated_password.push_str(&specials);
                                Ok(generated_password)
                            }
                            Err(e) => Err(e),
                        }
                    }
                    Err(e) => Err(e),
                }
            } else {
                Err(String::from(
                    "Error: generate password should have a length between 16 and 64.",
                ))
            }
        }
        None => {
            let mut generated_password: String = Default::default();
            let words = generate_words(13);
            match words {
                Ok(words_value) => {
                    generated_password.push_str(&words_value);
                    let numbers = generate_numbers(2);
                    match numbers {
                        Ok(numbers_value) => {
                            generated_password.push_str(&numbers_value);
                            let specials = generate_specials();
                            generated_password.push_str(&specials);
                            Ok(generated_password)
                        }
                        Err(e) => Err(e),
                    }
                }
                Err(e) => Err(e),
            }
        }
    }
}

fn main() {
    println!("Password generator");
    let p32 = generate_password(Some(32)).unwrap();
    println!("{:#?}", p32);
}
