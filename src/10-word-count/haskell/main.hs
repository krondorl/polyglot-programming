{-
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
-}

import System.IO
import System.IO.Error (catchIOError)
import Control.Exception (try, SomeException)
import Data.Text (Text, splitOn, unpack)
import qualified Data.Text as T
import qualified Data.Text.IO as TIO

countWords :: FilePath -> IO (Either String Int)
countWords fileName = do
    result <- try (TIO.readFile fileName) :: IO (Either SomeException Text)
    case result of
        Left ex -> return $ Left (show ex)
        Right content -> return $ Right (sum $ map (length . T.words) (T.lines content))

main :: IO ()
main = do
    putStrLn "Count total words sum"
    putStrLn ""

    countResult <- countWords "enchiridion-hun.txt"
    case countResult of
        Left err -> putStrLn $ "Error: " ++ err
        Right count -> putStrLn $ "Total words: " ++ show count
