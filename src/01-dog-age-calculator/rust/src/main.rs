fn calculate_dog_age(age: u8) -> Result<u8, String> {
    if age < 1 {
        return Err(String::from("Error: age should be at least 1."));
    }
    let result_age: f32 = (16. * (age as f32).ln() + 31.).round();
    Ok(result_age as u8)
}

fn main() {
    println!("Dog Age Calculator");
    let age = 1;
    let dog_age = calculate_dog_age(age);
    match dog_age {
        Ok(val) => println!("Dog age {age} in human years is {val}"),
        Err(e) => println!("{e}"),
    }
}
