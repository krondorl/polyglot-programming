/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
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
    let books: Vec<String> = [
        "Jane Austen: Pride and Prejudice",
        "George Orwell: 1984",
        "F. Scott Fitzgerald: The Great Gatsby",
    ]
    .iter()
    .map(|&s| s.to_string())
    .collect();

    let my_books: MyBooks = MyBooks { books };

    Json(my_books)
}

#[tokio::main(flavor = "current_thread")]
async fn main() {
    println!("Rest API example");
    println!("Server is running on 0.0.0.0:3000");
    println!();
    println!("Try the following: GET /books");

    let app = Router::new().route("/books", get(get_books));

    let listener = tokio::net::TcpListener::bind("0.0.0.0:3000").await;

    match listener {
        Ok(ok_listener) => {
            println!("Listener is working...");
            let serve = axum::serve(ok_listener, app).await;
            match serve {
                Ok(_ok_serve) => {
                    println!("Serving is working...");
                }
                Err(e) => {
                    println!("Error when serving server. {}", e);
                }
            }
        }
        Err(e) => {
            println!("Error when binding to TcpListener. {}", e);
        }
    }
}
