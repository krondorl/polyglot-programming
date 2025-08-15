/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

type Celsius = i16;
type Fahrenheit = i16;

fn into_fahrenheit(degree: Celsius) -> Fahrenheit {
    ((degree as f32 * 9.0 / 5.0) + 32.0) as Fahrenheit
}

fn into_celsius(degree: Fahrenheit) -> Celsius {
    ((degree as f32 - 32.0) * 5.0 / 9.0) as Celsius
}

fn main() {
    println!("Celsius and Fahrenheit degrees converter");
    println!();

    let c25 = into_fahrenheit(25);
    println!("25 °C equals to {c25} °F");

    let f77 = into_celsius(77);
    println!("77 °F equals to {f77} °C");
}
