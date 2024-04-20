llast :: [a] -> a
llast a = head (reverse a)

iinit :: [a] -> [a]
iinit a = take (length a - 1) a

inversa :: [a] -> [a]
inversa [] = []
inversa (a:b) = inversa b ++ [a]

zzip :: [a] -> [b] -> [(a,b)]
zzip [][] = []
zzip (a:b) (c:d) = (a,c) : zip b d

eliminaPrimi :: [a] -> Int -> [a]
eliminaPrimi a 0 = a
eliminaPrimi (a:b) n = eliminaPrimi b (n-1)

concatena :: [a] -> [a] -> [a]
concatena [] c = c
concatena (a:b) c = a:(concatena b c)

rreplicate :: Int -> a -> [a]
rreplicate 0 a = []
rreplicate n a = a:(rreplicate (n-1) a)

merge1 :: Ord a => [a] -> [a] -> [a]
merge1 (x:xs) (y:ys)
    | x>y = y:merge1 (x:xs) ys
    | otherwise = x:merge1 xs (y:ys)
merge1 [] ys = ys
merge1 xs [] = xs

msort :: Ord a=> [a] -> [a]
msort [] = []
msort [x] = [x]
msort xs = merge1 (msort (take (div (length xs) 2) xs)) (msort (drop (div (length xs) 2) xs))

halve :: [a] -> ([a],[a])
halve a = splitAt (div (length a) 2) a

third :: [a] -> a
third a = head (tail (tail a))
--third a = a !! 2 --list indexing
--third (_:_:a:_) = a --pattern matching

sumdown :: Int -> Int
sumdown a --if a>0 then a + sumdown(a-1) else 0
    |a>0 = a + sumdown (a-1)
    |otherwise = 0

aand :: [Bool] -> Bool
aand [] = True
aand (a:b) = a && aand b

nesimo :: [a] -> Int -> a
nesimo (a:b) 0 = a
nesimo (a:b) n = nesimo b (n-1)

eelem :: Eq a => a -> [a] -> Bool
eelem x [] = False
eelem x (a:b) --if x==a then True else eelem x b
    |x==a = True
    |otherwise = eelem x b

dec2int :: [Int] -> Int
dec2int = foldl (\a b -> 10*a + b) 0
--0 [1,2,3]
--0*10+1  = 1
--1*10*+2 = 12
--12*10+3 = 123

altMap :: (a->b) ->(a->b) -> [a] -> [b]
altMap x y [] = []
altMap x y (a:b) = x a : altMap y x b