package it.unive.dais.po1.carte.gioco;

import it.unive.dais.po1.carte.Mazzo;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscola;

abstract public class GiocoDiCarte<M extends Mazzo> {
    private M mazzo;
    protected GiocoDiCarte(M mazzo) {
        mazzo = this.mazzo;
        mazzo.mischia();
    }

    abstract public GiocatoreDiBriscola giocaPartita();

}
