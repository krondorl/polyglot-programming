{-
 * Polyglot Programming
 *
 * Copyright (c) 2024- Adam Burucs
 *
 * MIT Licensed
-}

type AgeResult = Either String Int

calculateDogAge :: Int -> AgeResult
calculateDogAge age
    | age < 1   = Left "Error: age should be at least 1."
    | otherwise = Right $ round (16 * log (fromIntegral age) + 31)

main :: IO ()
main = do
    putStrLn "Dog Age Calculator"
    let age = 1
    case calculateDogAge age of
        Right dogAge -> putStrLn $ "Dog age " ++ show age ++ " in human years is " ++ show dogAge
        Left errorMsg -> putStrLn errorMsg
