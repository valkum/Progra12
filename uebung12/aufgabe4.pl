 % a)
 % verbindung(XS, A);
verbindung([erdgeschoss,bueros,damenmode], aufzug).
verbindung([erdgeschoss,bueros,cafeteria], kletterwand).
verbindung([cafeteria,damenmode,elektro], treppe).
verbindung([cafeteria,elektro,fitness], treppe).
verbindung([fitness,geschaeftsfuehrung],aufzug).


% b)
% verbindung([A,_,B],M).


% c)
inListe([X|_],X).
inListe([_|Tail],X) :- inListe(Tail,X).

% d)
weiterHinten([A|Tail],A,B) :- inListe(Tail,B).
weiterHinten([_|Tail], A, B) :- weiterHinten(Tail,A,B).

% e)
moeglich(A,A,_).
moeglich(A,B,XS) :- inListe(XS,X), % Alle Verbindungen raten
                    verbindung(XTEMP,X),
                    weiterHinten(XTEMP, A, Z), % Test ob Es ein Z weiterhinten in den aktuellen Verbindungen gibt, so dass man von dort B erreicht.
                    moeglich(Z,B,XS).

% d)
% moeglich(erdgeschoss, X, [kletterwand,aufzug]).