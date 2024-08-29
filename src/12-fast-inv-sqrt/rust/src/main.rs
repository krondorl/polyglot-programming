/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

// Based on Kulshrestha's C code
// Licensed under the do whatever the fuck you wanna do public licence.
// (c) Samarth Kulshrestha, 2021
// https://github.com/samarthkulshrestha/fast_inverse_square_root

fn fast_inv_sqrt(number: f32) -> f32 {
    let mut i = number.to_bits();
    let x2 = number * 0.5;
    let mut y;
    const THREE_HALVES: f32 = 1.5;

    i = 0x5f3759df - (i >> 1);
    y = f32::from_bits(i);
    y = y * (THREE_HALVES - (x2 * y * y));
    y = y * (THREE_HALVES - (x2 * y * y));

    y
}

fn print_sqrt_helper(number: f32) {
    println!("fast_inv_sqrt({number}) = {:?}", fast_inv_sqrt(number));
}

fn main() {
    println!("Fast inverse square root");
    println!();
    print_sqrt_helper(2.0);
    print_sqrt_helper(4.0);
    print_sqrt_helper(10.0);

    // output
    // Fast inverse square root
    //
    // fast_inv_sqrt(2) = 0.70710665
    // fast_inv_sqrt(4) = 0.49999782
    // fast_inv_sqrt(10) = 0.31622636
}
