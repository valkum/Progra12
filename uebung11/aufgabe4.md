Lösung zur Aufgabe 4 aus Übung 11
=================================

i)

	f (x : xs) y z = x + y
	f xs y z = if xs == z then y else head xs + y

	Typ: f :: [Int] -> Int -> Int -> a, da x eindeutig eine Liste von Int ist, zu sehen in Zeile 1 und Zeile 2 (head auch Int zurückliefert)
ii)

	g [] = g [1]
	g x = (\x -> x) x

	Typ: g :: [Int] -> Int, da (\x->x) den Typ a -> a hat, und mit Int aufgerufen wird.

iii)

	h w x [] z = if z == [x] then w else h w x [] z
	h w x y z = if x then head y else (x, x)

	Typ: h :: w -> Bool -> [a] -> [Bool]

iv)

	data N a b = A a | F (a -> b) | I Int

	i (F f) x = f x
	i (A y) x = i k x
		where
		k = F (\x -> I y)