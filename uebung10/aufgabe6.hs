module Main where


-- a)
millimeter :: Int -> Int -> Int
millimeter f z = f*305 + z*25


-- b)
mult :: Int -> Int -> Int 
mult x 0 = 0
mult x 1 = x
mult x y = x + mult x (y-1) 



-- c)
sqr :: Integer -> Integer -> Integer
sqr x 0 = 1
sqr x 1 = x
sqr x y = x * sqr x (y-1)

bLog :: Integer -> Integer
bLog x = bLog' x 0 
    where bLog' :: Integer -> Integer -> Integer
          bLog' x y |(x- (sqr 2 y)) > 0 = bLog' x (y+1)
                    |otherwise = y



-- d)
getLastTwo :: [Int] -> [Int]
getLastTwo [x,y]  = [x, y]
getLastTwo (_:xs) = getLastTwo xs



-- e)
singletons :: Int -> [[Int]]
singletons 1 = [[1]]
singletons x = [[x]]++singletons (x-1)


-- f)
cleanEmpty :: [[Int]] -> [[Int]]
cleanEmpty ([]:xs)    = cleanEmpty xs
cleanEmpty (y:[]:xs) = y:cleanEmpty xs
cleanEmpty xs     = xs



-- g)
kleinste :: [Int] -> Int
kleinste [x,y]    |x<y = x
                  |otherwise = y
kleinste (x:y:xs) |x<y = kleinste' x xs
                  |otherwise = kleinste' y xs
    where   kleinste' :: Int -> [Int] -> Int
            kleinste' x [y]      |x < y = x
                                 |otherwise = y
            kleinste' x (y:ys)   |x<y = kleinste' x ys
                                 |otherwise = kleinste' y ys
            

-- h)
nachHinten :: Int -> [Int] -> [Int]
nachHinten 0 xs = xs
nachHinten x (y:xs) = nachHinten (x-1) xs ++ [x]



-- i)
einpacken :: [[Int]] -> [Int] -> [[Int]]
einpacken ([]:xs) [y] = [[y]]
einpacken ([]:xs) (y:ys) = [y] : einpacken xs ys
einpacken (x:xs) ys = x : einpacken xs ys



-- j)
listAdd :: Int -> [Int] -> [Int]
listAdd x [y] = [y+x]
listAdd x (y:ys) = (y+x):listAdd y ys