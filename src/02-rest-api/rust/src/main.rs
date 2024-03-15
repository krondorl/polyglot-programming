/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

use axum::{routing::get, Json, Router};
use serde::Serialize;

#[derive(Serialize)]
struct MyBooks {
    books: Vec<String>,
}

async fn get_books() -> Json<MyBooks> {
    let books = vec![
        String::from("Jane Austen: Pride and Prejudice"),
        String::from("George Orwell: 1984"),
        String::from("F. Scott Fitzgerald: The Great Gatsby"),
    ];

    let my_books: MyBooks = MyBooks { books };

    Json(my_books)
}

#[tokio::main(flavor = "current_thread")]
async fn main() {
    println!("Rest API example");
    println!("Server is running on port 3000");
    println!();
    println!("Try the following: GET /books");

    let app = Router::new().route("/books", get(get_books));

    let listener = tokio::net::TcpListener::bind("0.0.0.0:3000").await.unwrap();
    axum::serve(listener, app).await.unwrap();
}
