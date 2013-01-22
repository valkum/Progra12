 -- data Liste a = Element a Liste | Null deriving Show

--testListe :: Liste Int
--testListe = Element 42 (Element 3 Null)

data Mobile a = Kaenguru a (Mobile a) (Mobile a) | Elefant (Mobile a) | Stern | Seepferdchen deriving Show

mobileLinks :: Mobile Int
mobileLinks = Kaenguru 1 
    (
        Elefant 
        (
            Kaenguru 2 (Stern) (Kaenguru 3 Seepferdchen Stern)
        )
    ) Seepferdchen

mobileRechts :: Mobile Int
mobileRechts = Elefant (Kaenguru 1 (Elefant Stern) (Elefant Seepferdchen))

-- b
count :: Mobile a -> Int
count Stern = 1
count Seepferdchen = 1
count (Elefant s) = 1 + (count s)
count (Kaenguru _ l r) = 1 + (count l) + (count r)

-- c
liste :: Mobile a -> [a]
liste Stern = []
liste Seepferdchen = []
liste (Elefant s) = liste s
liste (Kaenguru a l r) = a : liste l ++ liste r

-- d
greife :: Mobile a -> Int -> Mobile a
greife x 1 = x
greife (Elefant a) n = greife a (n - 1)
greife (Kaenguru _ l r) n   |n<count l = greife l (n - 1)
                            |otherwise = greife r (n - 1 - (count l))