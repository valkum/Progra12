Aufgabe 2 B) Schleifenumformung
=========================== 

## for 2 do-while
Von

	for (Z; B; I) { P; }
Nach

	{
		Z;
		if (B) {
			do {
				P; I;
			} while (B);
		}
	}


## do-while 2 for
Von

	Z;
	do{
		P;
		I;
	} while (B);
Nach

	for (Z; B; I;) {p;}


## for 2 while
Von

	for (Z; B; I) { P; }
Nach

	{
		Z;
		while(B){
			P;
			I;
		}
	}




## while 2 do-while
Von

	{
		Z;
		while(B){
			P;
			I;
		}
	}
Nach

	{
		Z;
		if(B) {
			do {}
				P;
				I;
			} while (B)
		}
	}


Aufgabe 6 b)
=============

Eine gültige Variante für die Terminierung ist V = r, denn die Schleifenbedingung B = r\*r < x mit der Vorbedingung r > 0 impliziert r\*r <= x.  
Es gilt:

	< r > 0 && x > 0 && x >= r && r = m >
	< r + 1 > m>
	r = r + 1;
	< r > m >

Damit ist die Terminierung der einzigen Schleife in P gezeigt, da x konstant bleibt und r stetig wächst.