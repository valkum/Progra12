Lösung zur Aufgabe 4 aus Übung 11
=================================

i)

	f (x : xs) y z = x + y
	f xs y z = if xs == z then y else head xs + y

	f :: a -> b -> c -> d

	In Zeile 1 sehen wir, dass a eine Liste von Ints ist und b Int ist. Außerdem ist somit d Int
	f :: [Int] -> Int -> z -> Int

	In Zeile 2 sehen wir, dass c = a sein muss. Also eine Liste von Ints

	f :: [Int] -> Int -> [Int] -> Int
ii)

	g [] = g [1]
	g x = (\x -> x) x

	g :: a -> b

	In Zeile 1 sehen wir, dass a eine Liste von Ints ist.
	g :: [Int] -> b

	In Zeile 2 sehen wir, dass b = a ist.
	g :: [Int] -> [Int]

iii)

	h w x [] z = if z == [x] then w else h w x [] z
	h w x y z = if x then head y else (x, x)

	Typ: h :: w -> Bool -> [a] -> [Bool]

	h :: a -> b -> c -> d -> e
	
	In Zeile 1 sehen wir, dass c eine Liste ist
	h :: a -> b -> [c] -> d -> e

	In Zeile 1 sehen wir das d vom typ [b] sein muss und die rückgabe = a ist
	h :: a -> b -> [c] -> [b] -> a

	In Zeile 2 sehen wir, dass head [c] rückgegeben wird, also muss c = a sein
	h :: a -> b -> [a] -> [b] -> a

	Außerdem muss b Bool sein, da in der 2 Zeile in if dieses vorrausgesetzt wird.
	h :: a -> Bool -> [a] -> [Bool] -> a

	a muss ein Tupel von Bools sein, da in der Zweiten Zeile ein Tupel zurückgegeben wird.
	h :: (Bool, Bool) -> Bool -> [(Bool, Bool)] ->[Bool] -> (Bool, Bool)

iv)

	data N a b = A a | F (a -> b) | I Int

	i (F f) x = f x
	i (A y) x = i k x
		where
		k = F (\x -> I y)


	i F (\x -> I y) x

	i :: a -> c -> d

	a ist eindeutig vom Typ der Liste. 
	i :: N a b -> c -> d

	In where sehen wir, dass F den Typ c bekommt, und I Int zurückgibt, somit ist b = N a b und c = a
	i :: N a (N a b) -> a -> d

	Da die erste Zeile den Rückgabetyp von der Funktion von F hat und dies I Int ist, ist d = N a b
	i :: N a (N a b) -> a -> N a b

	Da I Int ist, ist y in where auch Int und somit auch y in (A y)
	i :: N Int (N a b) -> Int -> N a b
