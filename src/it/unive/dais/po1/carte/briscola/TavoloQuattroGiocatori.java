package it.unive.dais.po1.carte.briscola;

import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;

public class TavoloQuattroGiocatori {
    private GiocatoreBirscolaIntelligente.GiocatoreDiBriscola[] giocatori = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscola[4];

    public TavoloQuattroGiocatori(GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g1, GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g2, GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g3, GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g4) {
        giocatori[0] = g1;
        giocatori[1] = g2;
        giocatori[2] = g3;
        giocatori[3] = g4;
    }

    public void setPrimoDiMano(int i) {
        GiocatoreBirscolaIntelligente.GiocatoreDiBriscola[] newOrder = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscola[4];
        for(int j = 0; j<4; j++) {
            if(j-i>=0)
                newOrder[j-i] = giocatori[j];
            else newOrder[4+j-i] = giocatori[j];
        }
        this.giocatori = newOrder;
    }

    public GiocatoreBirscolaIntelligente.GiocatoreDiBriscola get(int i) {
        return giocatori[i];
    }
}