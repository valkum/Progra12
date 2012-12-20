module Main where

sekunden :: Int -> Int -> Int -> Int
sekunden h m s = s + 60 * m + 3600 * h

-----------------

turm :: Integer -> Integer -> Integer
turm x 0 = 1
turm x y = x ^ (turm x (y - 1))


--------------

wurzel :: Int -> Int
wurzel x = wurzel' x
    where   wurzel' :: Int -> Int
            wurzel' w   |w * w * w <= x = w
                        |otherwise = wurzel' (w-1)

getEnd :: [Int] -> Int
getEnd [x] = x
getEnd (x:xs) = getEnd xs

