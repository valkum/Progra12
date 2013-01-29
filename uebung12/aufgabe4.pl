 % a)
 % verbindung(XS, A);
verbindung([erdgeschoss,bueros,damenmode], aufzug).
verbindung([erdgeschoss,bueros,cafeteria], kletterwand).
verbindung([cafeteria,damenmode,elektro], treppe).
verbindung([cafeteria,elektro,fitness], treppe).
verbindung([fitness,geschaeftsfuehrung],aufzug).


% b)
verbindung([A,_,B],M).


% c)
inListe([X|XS],X).
inListe([Y|YS],X) :- inListe(YS,X).

% d)
weiterHinten([A|XS],A,B) :- inListe(XS,B).
weiterHinten([X|XS], A, B) :- weiterhinten(XS,A,B).

% e)