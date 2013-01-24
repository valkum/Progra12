-- a
sekunden :: Int -> Int -> Int -> Int
sekunden h m s = 60*60*h + 60*m + s

-- b
turm :: Integer -> Integer -> Integer
turm _ 0 = 1
turm x y = x ^ (turm x (y-1))

-- c
wurzel :: Int -> Int
wurzel x = wurzelH x
  where wurzelH :: Int -> Int
        wurzelH w | w*w*w <= x = w
                  | otherwise  = wurzelH (w-1)

-- d
getEnd :: [Int] -> Int
getEnd [x] = x
getEnd (_:xs) = getEnd xs

-- e
insertEnd :: Int -> [Int] -> [Int]
insertEnd x     [] = [x]
insertEnd x (y:ys) = y : insertEnd x ys

-- f
anzahl :: Int -> [Int] -> Int
anzahl _ []     = 0
anzahl x (y:ys) | x == y      = 1 + anzahl x ys
                | otherwise   =     anzahl x ys

-- g
einfuegen :: Int -> [Int] -> [Int]
einfuegen x []     = [x]
einfuegen x (y:ys) | x < y     = x:y:ys
                   | otherwise = y : einfuegen x ys

-- h
insSort :: [Int] -> [Int]
insSort []     = []
insSort (x:xs) = einfuegen x (insSort xs)

-- i
zipping :: [Int] -> [Int] -> [Int]
zipping []     ys = ys
zipping (x:xs) ys = x : zipping ys xs

-- j
flach :: [[Int]] -> [Int]
flach []           = []
flach (    []:ys)  = flach ys
flach ((x:xs):ys)  = x : flach (xs : ys)
