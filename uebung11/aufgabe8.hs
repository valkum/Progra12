--a ) Hier würde ich eher Integer benutzen, da die Zahlen sehr groß werden.
fibs :: [Int]
fibs = 0:1:zipWith (+) fibs (tail fibs)

-- b)

zeckendorf :: Int -> [Int]
zeckendorf 0 = []
zeckendorf n =  (f : zeckendorf (n - f)) where f = last(takeWhile (<=n) fibs)