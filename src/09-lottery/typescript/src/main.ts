/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

function generateDraw(drawType: string): number[] | string {
  let maxNumber: number;
  let maxCount: number;

  switch (drawType) {
    case "five-number draw":
      maxNumber = 90;
      maxCount = 5;
      break;
    case "six-number draw":
      maxNumber = 45;
      maxCount = 6;
      break;
    case "seven-number draw":
      maxNumber = 35;
      maxCount = 7;
      break;
    default:
      return "Error: please choose between 'five-number draw' or 'six-number draw' or 'seven-number draw'.";
  }

  const drawnNumbers: number[] = [];
  while (drawnNumbers.length < maxCount) {
    const randomNumber = Math.floor(Math.random() * maxNumber) + 1;
    if (!drawnNumbers.includes(randomNumber)) {
      drawnNumbers.push(randomNumber);
    }
  }

  drawnNumbers.sort((a, b) => a - b);
  return drawnNumbers;
}

function printDraw(drawType: string): void {
  const draw = generateDraw(drawType);
  if (typeof draw === "string") {
    console.log(draw);
  } else {
    console.log(draw);
  }
}

function main(): void {
  console.log("Lottery draw");
  printDraw("wrong draw-y-x-");
  printDraw("five-number draw");
  printDraw("six-number draw");
  printDraw("seven-number draw");
}

main();
