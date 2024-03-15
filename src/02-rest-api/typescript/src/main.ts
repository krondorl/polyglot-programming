/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

import express, { Request, Response } from "express";

const app = express();

const books: string[] = [
  "Jane Austen: Pride and Prejudice",
  "George Orwell: 1984",
  "F. Scott Fitzgerald: The Great Gatsby",
];

app.get("/books", (req: Request, res: Response) => {
  const booksObject = { books: books };
  res.json(booksObject);
});

const PORT: number = process.env.PORT ? parseInt(process.env.PORT) : 3000;
app.listen(PORT, () => {
  console.log("Rest API example");
  console.log(`Server is running on port ${PORT}`);
  console.log();
  console.log("Try the following: GET /books");
});
