-- a)
data AList a = Element String a (AList a)| Nil deriving Show

bsp :: AList Int
bsp = Element "Meier" 908256 (Element "Becker" 503020 (Element "Schmitz" 493827 (Nil)))


-- b)
size :: AList a -> Int
size Nil = 0;
size (Element _ _ s)= 1 + size s

-- c)
contained :: AList a -> String -> Bool
contained Nil _ = False
contained (Element a _ xs) s |a == s = True
                             |otherwise = contained xs s
-- d)
put ::  AList a -> String -> a -> AList a
put Nil s a = Element s a Nil
put (Element g v xs) s a    |g == s = Element g a xs
                            |otherwise = Element g v (put xs s a)

-- e)
mapAList :: (a -> b)  -> AList a-> AList b
mapAList f Nil = Nil
mapAList f (Element x y xs) = Element x (f y) (mapAList f xs)