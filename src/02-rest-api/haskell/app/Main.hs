{-# LANGUAGE OverloadedStrings #-}

{-
  Polyglot Programming

  Copyright (c) 2024 Adam Burucs

  MIT Licensed
-}

import Web.Scotty
import Data.Maybe (fromMaybe)
import System.Environment (lookupEnv)
import Data.Text.Lazy (Text, pack)
import Data.Aeson (object, (.=))

main :: IO ()
main = do
  port <- fromMaybe "3000" <$> lookupEnv "PORT"
  let portNum = read port :: Int
  
  scotty portNum $ do
    get "/books" $ do
      let books = [ "Jane Austen: Pride and Prejudice"
                  , "George Orwell: 1984"
                  , "F. Scott Fitzgerald: The Great Gatsby"
                  ]
      json $ object ["books" .= books]
    
    liftIO $ do
      putStrLn "Rest API example"
      putStrLn $ "Server is running on port " ++ port
      putStrLn ""
      putStrLn "Try the following: GET /books"
