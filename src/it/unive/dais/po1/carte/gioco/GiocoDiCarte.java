package it.unive.dais.po1.carte.gioco;

import it.unive.dais.po1.carte.Mazzo;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscola;

abstract public class GiocoDiCarte<M extends Mazzo> {
    protected M mazzo;
    protected GiocoDiCarte(M mazzo) {
        this.mazzo = mazzo;
        this.mazzo.mischia();
    }

    abstract public GiocatoreDiBriscola giocaPartita() throws GiocoDiCarteException;

}
