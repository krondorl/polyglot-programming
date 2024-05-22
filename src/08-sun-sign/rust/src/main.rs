/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

#[derive(Debug)]
#[allow(dead_code)]
struct SunSign {
    sign: String,
    start_month: u8,
    start_day: u8,
    end_month: u8,
    end_day: u8,
}

fn get_sun_sign(month: u8, day: u8) -> Result<String, String> {
    let mut result_sign: String = String::from("");
    if !(1..=31).contains(&day) || !(1..=12).contains(&month) {
        return Err::<String, String>(String::from("invalid date"));
    }
    let signs = vec![
        SunSign {
            sign: String::from("Aquarius"),
            start_month: 1,
            start_day: 20,
            end_month: 2,
            end_day: 18,
        },
        SunSign {
            sign: String::from("Pisces"),
            start_month: 2,
            start_day: 19,
            end_month: 3,
            end_day: 20,
        },
        SunSign {
            sign: String::from("Aries"),
            start_month: 3,
            start_day: 21,
            end_month: 4,
            end_day: 19,
        },
        SunSign {
            sign: String::from("Taurus"),
            start_month: 4,
            start_day: 20,
            end_month: 5,
            end_day: 20,
        },
        SunSign {
            sign: String::from("Gemini"),
            start_month: 5,
            start_day: 21,
            end_month: 6,
            end_day: 20,
        },
        SunSign {
            sign: String::from("Cancer"),
            start_month: 6,
            start_day: 21,
            end_month: 7,
            end_day: 22,
        },
        SunSign {
            sign: String::from("Leo"),
            start_month: 7,
            start_day: 23,
            end_month: 8,
            end_day: 22,
        },
        SunSign {
            sign: String::from("Virgo"),
            start_month: 8,
            start_day: 23,
            end_month: 9,
            end_day: 22,
        },
        SunSign {
            sign: String::from("Libra"),
            start_month: 9,
            start_day: 23,
            end_month: 10,
            end_day: 22,
        },
        SunSign {
            sign: String::from("Scorpio"),
            start_month: 10,
            start_day: 23,
            end_month: 11,
            end_day: 21,
        },
        SunSign {
            sign: String::from("Sagittarius"),
            start_month: 11,
            start_day: 22,
            end_month: 12,
            end_day: 21,
        },
        SunSign {
            sign: String::from("Capricorn"),
            start_month: 12,
            start_day: 22,
            end_month: 1,
            end_day: 19,
        },
    ];
    for sgn in signs {
        if (month == sgn.start_month && day >= sgn.start_day)
            || (month == sgn.end_month && day <= sgn.end_day)
        {
            result_sign = sgn.sign;
        }
    }
    Ok(result_sign)
}

fn print_sun_sign(month: u8, day: u8) {
    let result = get_sun_sign(month, day);
    match result {
        Ok(sign) => println!("{sign}"),
        Err(err) => println!("Error with getting sign for date (month {month}, day {day}) {err}"),
    };
}

fn main() {
    println!("Calculate your Sun Sign");
    println!();

    print_sun_sign(100, 17);
    print_sun_sign(70, 30);
    print_sun_sign(11, 25);
}

#[cfg(test)]
mod tests {
    use crate::get_sun_sign;

    #[test]
    fn get_sun_sign_test() {
        assert_eq!(get_sun_sign(100, 17), Err(String::from("invalid date")));
        assert_eq!(get_sun_sign(70, 30), Err(String::from("invalid date")));
        assert_eq!(get_sun_sign(11, 25), Ok(String::from("Sagittarius")));
    }
}
