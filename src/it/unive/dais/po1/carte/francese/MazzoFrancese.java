package it.unive.dais.po1.carte.francese;

import it.unive.dais.po1.carte.Mazzo;

public class MazzoFrancese extends Mazzo<CartaFrancese> {

    public MazzoFrancese() {
        super(52);
    }

    protected void riempiMazzo() {

        for (int i = 1; i <= 4; i++) {
            SemeFrancese corrente = i == 1 ? SemeFrancese.Cuori:
                    i == 2 ? SemeFrancese.Fiori :
                            i == 3 ? SemeFrancese.Picche :
                                    i == 4 ? SemeFrancese.Quadri : null;
            for (int j = 1; j <= 13; j++) {
                CartaFrancese c = new CartaFrancese(corrente, ValueFrancese.getValue(j));
                super.push(c);
            }
        }
    }
}
