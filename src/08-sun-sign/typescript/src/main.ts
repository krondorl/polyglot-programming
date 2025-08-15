/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

class SunSign {
  constructor(
    public sign: string,
    public startMonth: number,
    public startDay: number,
    public endMonth: number,
    public endDay: number
  ) {}
}

function getSunSign(month: number, day: number): string {
  if (day < 1 || day > 31 || month < 1 || month > 12) {
    return "Error: invalid date";
  }

  const signs = [
    new SunSign("Aquarius", 1, 20, 2, 18),
    new SunSign("Pisces", 2, 19, 3, 20),
    new SunSign("Aries", 3, 21, 4, 19),
    new SunSign("Taurus", 4, 20, 5, 20),
    new SunSign("Gemini", 5, 21, 6, 20),
    new SunSign("Cancer", 6, 21, 7, 22),
    new SunSign("Leo", 7, 23, 8, 22),
    new SunSign("Virgo", 8, 23, 9, 22),
    new SunSign("Libra", 9, 23, 10, 22),
    new SunSign("Scorpio", 10, 23, 11, 21),
    new SunSign("Sagittarius", 11, 22, 12, 21),
    new SunSign("Capricorn", 12, 22, 1, 19),
  ];

  for (const sign of signs) {
    if (
      (month === sign.startMonth && day >= sign.startDay) ||
      (month === sign.endMonth && day <= sign.endDay)
    ) {
      return sign.sign;
    }
  }
  return "";
}

function printSunSign(month: number, day: number): void {
  try {
    const sign = getSunSign(month, day);
    console.log(sign);
  } catch (err: unknown) {
    if (typeof err === "string") {
      console.log(
        `Error with getting sign for date (month ${month}, day ${day}): ${err}`
      );
    }
  }
}

function main(): void {
  console.log("Calculate your Sun Sign");
  console.log();

  printSunSign(100, 17);
  printSunSign(70, 30);
  printSunSign(11, 25);
}

main();
