package it.unive.dais.po1.carte.trevigiane;

import it.unive.dais.po1.carte.Mazzo;

public class MazzoTrevigiano extends Mazzo<CartaTrevigiana> {


    public MazzoTrevigiano() {
        super(40);
    }

    protected void riempiMazzo() {
        for (int i = 1; i <= 4; i++) {
            SemeTrevigiano corrente = i == 1 ? SemeTrevigiano.Denari :
                    i == 2 ? SemeTrevigiano.Bastoni :
                            i == 3 ? SemeTrevigiano.Coppe :
                                    i == 4 ? SemeTrevigiano.Spade : null;
            for (int j = 1; j <= 10; j++) {
                CartaTrevigiana c = new CartaTrevigiana(corrente, ValueTrevigiano.getValue(j));
                super.push(c);
            }
        }
    }

}
