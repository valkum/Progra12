
% isNat (X) gilt gdw. X eine natuerliche Zahl in Peano - Notation
% repraesentiert
isNat(0).
isNat(s(X)) :- isNat(X).
% add (X,Y,Z) gilt gdw. X, Y und Z natuerliche Zahlen in
% Peano - Notation repraesentieren und Z die Summe von X und Y ist
add(0,Y,Y) :- isNat(Y).
add(s(X),Y,s(Z)) :- add(X,Y,Z).
% leaves (X,Y) gilt gdw . X einen binaeren Baum und Y eine natuerliche
% Zahl in Peano - Notation repraesentieren und Y die Anzahl der
% Blaetter von X ist
leaves(leaf(_),s(0)).
leaves(node(X,_,Y),Z) :- 	leaves(X,A),
							leaves(Y,B),
							add(A,B,Z).
% aufgabe 6
% a)
maxNeighbors(X,0,X) :- isNat(X).
maxNeighbors(X,X,0) :- isNat(X).
maxNeighbors(s(X),s(Y),s(Z)) :- maxNeighbors(X,Y,Z).

% b)
treeSum(leaf(A),A).
treeSum(node(X,V,Y), N) :-  treeSum(X,A),
							treeSum(Y,B),
							add(A,B,C),
							add(V,C,N).

% c)
isBalanced(leaf(_)).
isBalanced(node(X,_,Y)) :-  (isBalancedWithHeight(X,N),
							isBalancedWithHeight(Y,s(N)));
							(isBalancedWithHeight(X,s(N)),
							isBalancedWithHeight(Y,N));
							(isBalancedWithHeight(X,N),
							isBalancedWithHeight(Y,N)).

isBalancedWithHeight(leaf(_),s(0)).
isBalancedWithHeight(node(X,_,Y),N) :-	isBalancedWithHeight(X,A),
										isBalancedWithHeight(Y,B),
										add(A,B,N).