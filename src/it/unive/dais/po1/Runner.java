package it.unive.dais.po1;

import it.unive.dais.po1.gioco.Mazzo;
import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.Seme;
import it.unive.dais.po1.gioco.carte.briscola.Briscola;
import it.unive.dais.po1.gioco.carte.briscola.Giocatore;

public class Runner {

    public static void main(String[] args) {;
        Briscola b = new Briscola(new Giocatore("Pietro"), new Giocatore("Alessio"));
        Giocatore g = b.giocaPartita();
        if(g==null)
            System.out.println("Pari");
        else System.out.println("Ha vinto "+g.getName());
    }

}
