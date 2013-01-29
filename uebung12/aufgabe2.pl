
class(kunstobjekt).
class(malerei).
class(zeichnung).
class(bildhauerei).
class(portrait).
class(skulptur).
class(plastik).

interface(aufhaengbar).

objekt(_).

extends(malerei, kunstobjekt).
extends(zeichnung, kunstobjekt).
extends(bildhauerei, kunstobjekt).
extends(portrait, malerei).
extends(skulptur, bildhauerei).
extends(plastik, bildhauerei).

implements(zeichnung, aufhaengbar).
implements(portrait, aufhaengbar).

% d)
nichtAbstrakt(malerei).
nichtAbstrakt(zeichnung).
nichtAbstrakt(bildhauerei).
nichtAbstrakt(portrait).
nichtAbstrakt(skulptur).
nichtAbstrakt(plastik).




% b)
extends(X, kunstobjekt).

% c)
instanceof(X,X).
instanceof(X,Y) :- extends(X,Y); implements(X,Y).


% d)
instanzMoeglich(X,Y) :- nichtAbstrakt(X), instanceof(X,Y).