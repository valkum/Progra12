Lösung zur Aufgabe 4 aus Übung 11
=================================

i) 

	f [] x y = y
	f [z:zs] x y = f [] (z:x) y

	f :: a -> b -> c -> d 
	Aus der 1. Zeile => c = d

	f :: a -> b -> c -> c
	Aus der 1. Zeile => a = [a]
	Aus der 2. Zeile => [a] = [[a]]

	f :: [[a]] -> b -> c -> c
	Aus der 2. Zeile nach dem "="" => x = [x]
	Mit Zeile 2 (z:x) => x = a

	f :: [[a]] ->[a] -> c -> c

ii) 

	g x 1 = 1
	g x y = (\x -> (g x 0)) y
		  = g y 0


	g :: a -> b -> c
	Aus Zeile 1 => b, c = Int

	g :: a -> Int -> Int
	Aus Zeile 2 folgt: wenn y Int ist und in x eingesetzt wird muss x auch Int sein

	g :: Int -> Int -> Int

iii) 

	h (x:xs) y z = if x then h xs x (y:z) else h xs y z

	h :: a -> b -> c -> d
	Durch (x:xs) und if x .. folgt x = Boolean

	h :: [Bool] -> b -> c -> d
	Durch  ...

	h :: [Bool] -> Bool -> [Bool] -> d

iv) 

	data T a b = C0 | C1 a | C2 b | C3 (T a b) (T a b)
	i (C3 (C1 []) (C2 y)) = C1 0
	i (C3 (C2 []) (C1 y)) = C2 0
	i (C3 (C1 (x:xs )) (C2 y)) = i (C3 (C1 y) (C2 [x]))

	i :: a -> b

	i :: a -> T Int Int

	i :: T a b -> T Int Int

	i :: T [a] [b] -> T Int Int

	i :: T [a] [a] -> T Int Int