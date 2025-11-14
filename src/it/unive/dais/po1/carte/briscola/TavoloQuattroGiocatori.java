package it.unive.dais.po1.carte.briscola;

import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscola;

public class TavoloQuattroGiocatori {
    private GiocatoreDiBriscola[] giocatori = new GiocatoreDiBriscola[4];

    public TavoloQuattroGiocatori(GiocatoreDiBriscola g1, GiocatoreDiBriscola g2, GiocatoreDiBriscola g3, GiocatoreDiBriscola g4) {
        giocatori[0] = g1;
        giocatori[1] = g2;
        giocatori[2] = g3;
        giocatori[3] = g4;
    }

    public void setPrimoDiMano(int i) {
        GiocatoreDiBriscola[] newOrder = new GiocatoreDiBriscola[4];
        for(int j = 0; j<4; j++) {
            if(j-i>=0)
                newOrder[j-i] = giocatori[j];
            else newOrder[4+j-i] = giocatori[j];
        }
        this.giocatori = newOrder;
    }

    public GiocatoreDiBriscola get(int i) {
        return giocatori[i];
    }
}