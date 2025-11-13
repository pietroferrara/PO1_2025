package it.unive.dais.po1.carte.scala40;

import it.unive.dais.po1.carte.francese.MazzoFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;
import it.unive.dais.po1.carte.gioco.GiocoDiCarte;

public class Scala40 extends GiocoDiCarte<MazzoFrancese> {
    public Scala40() {
        super(new MazzoFrancese());
    }

    public GiocatoreBirscolaIntelligente.GiocatoreDiBriscola giocaPartita() {
        return null;//TODO
    }
}
