/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
 */

import fs from "node:fs/promises";

async function countWords(fileName: string): Promise<number | string> {
  const file = await fs.open(fileName);
  let count = 0;

  for await (const line of file.readLines()) {
    let splitLine = line.split(" ");
    count += splitLine.length;
  }

  return count;
}

async function main(): Promise<void> {
  console.log("Count total words sum");
  console.log();

  try {
    let count = await countWords("enchiridion-hun.txt");
    if (typeof count === "number") {
      console.log(`Total words: ${count}`);
    } else if (typeof count === "string") {
      console.log(`Error: ${count}`);
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

main();
