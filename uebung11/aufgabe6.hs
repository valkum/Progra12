data List a = Nil | Cons a (List a) deriving Show

testList, testList2 :: List Int
testList = Cons (-23) (Cons 42 (Cons 19 (Cons (-38) Nil)))
testList2 = Cons 1 (Cons 2 Nil)

-- a)
filterList :: (a -> Bool) -> List a -> List a
filterList f Nil = Nil
filterList f (Cons a xs) 
    |(f a) = Cons a (filterList f xs)
    |otherwise = filterList f xs

-- b) 
posList :: List Int -> List Int
posList xs = filterList (\x -> x >= 0) xs

-- c)
foldList :: (a -> b -> b) -> b -> List a -> b
foldList f c Nil = c
foldList f c (Cons a xs) = f a (foldList f c xs)


-- d)
maxList :: List Int -> Int
maxList xs = foldList (\x y -> max x y) 1 xs

-- e)
appendList :: List a -> List a -> List a
appendList xs ys = foldList (\x y -> Cons x y) ys xs


-- f)
reverseList :: List a -> List a
reverseList xs = foldList (\x y -> (appendList y (Cons x Nil))) Nil xs 

-- g)
filterList' :: (a -> Bool) -> List a -> List a
filterList' f xs = foldList  (\x y -> if (f x) then (Cons x y) else y ) Nil xs