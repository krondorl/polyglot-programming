/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

use tabled::{Table, Tabled};

// Using HUF currency and centimeter for diameter
// Because we are comparing Hungarian made pizzas
#[derive(Debug, Tabled)]
struct Pizza<'a> {
    name: &'a str,
    diameter_cm: u16,
    price_huf: u16,
    area_to_price: f32,
}

fn calculate_pizza_sizes(pizzas: Vec<Pizza>) -> Result<Vec<Pizza>, String> {
    if pizzas.len() < 2 {
        return Err(String::from("Error: please set up at least 2 pizzas."));
    }
    const PI: f32 = std::f32::consts::PI;
    let mut calc_pizzas = Vec::new();
    for pizza in pizzas {
        let pizza_price = (pizza.price_huf as f32)
            / (((pizza.diameter_cm as f32) * (pizza.diameter_cm as f32) * PI) / 4.0);
        let pizza_item = Pizza {
            name: pizza.name,
            diameter_cm: pizza.diameter_cm,
            price_huf: pizza.price_huf,
            area_to_price: pizza_price,
        };
        calc_pizzas.push(pizza_item);
    }
    Ok(calc_pizzas)
}

fn main() {
    println!("Pizza Size Calculator");
    println!();
    let pizza_name = "quattro formaggi";
    let pizzas = vec![
        {
            Pizza {
                name: pizza_name,
                diameter_cm: 24,
                price_huf: 1995,
                area_to_price: 0.0,
            }
        },
        {
            Pizza {
                name: pizza_name,
                diameter_cm: 32,
                price_huf: 3195,
                area_to_price: 0.0,
            }
        },
        {
            Pizza {
                name: pizza_name,
                diameter_cm: 45,
                price_huf: 5395,
                area_to_price: 0.0,
            }
        },
    ];
    let calc_pizzas = calculate_pizza_sizes(pizzas);
    match calc_pizzas {
        Ok(val) => {
            let pizzas_table = Table::new(val).to_string();
            println!("{pizzas_table}");
        }
        Err(e) => println!("{e}"),
    }
}
