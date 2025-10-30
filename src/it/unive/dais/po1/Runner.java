package it.unive.dais.po1;

import it.unive.dais.po1.gioco.carte.briscola.Briscola;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.intelligenti.GiocatoreIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.GiocatoreNaive;

public class Runner {

    public static void main(String[] args) {
        GiocatoreIntelligente g1 = new GiocatoreIntelligente("Pietro"), g2=new GiocatoreIntelligente("Alessio");
        Briscola b = new Briscola(g1, g2);
        Giocatore g = b.giocaPartita();
        if(g==null || g == g1 || g==g2) // g \in {null, g1, g2}
            System.out.println("OK, ha vinto "+g.getName());
        else System.err.println("Valore non concesso "+g.getName());
    }

}
