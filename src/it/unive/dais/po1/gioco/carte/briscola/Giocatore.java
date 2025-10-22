package it.unive.dais.po1.gioco.carte.briscola;

import it.unive.dais.po1.gioco.Mazzo;
import it.unive.dais.po1.gioco.carte.Card;

public class Giocatore {
    private Card c1, c2, c3;
    private final String name;
    private Mazzo carte = new Mazzo();

    public Giocatore(String name) {
        this.name = name;
    }
    public void receiveCard(Card pop) {
        if(c1 == null) {
            c1 = pop;
        } else if(c2 == null) {
            c2 = pop;
        } else if(c3 == null) {
            c3 = pop;
        }
        else
            System.exit(-1);
    }

    public Card scarta() {
        Card c = null;
        if(c1 != null){
            c = c1;
            this.c1 = null;
        }
        else if(c2 != null){
             c = c2;
            this.c1 = null;
        }
        else if(c3!=null){
            c = c3;
            this.c3 = null;
        }
        else System.exit(-1);
        return c;
    }

    public void storeCard(Card c1) {
        this.carte.storeCard(c1);
    }

    public int contaPunti() {
        int punti = 0;
        while(carte.getCarteRimanenti()>0) {
            punti+=carte.pop().punti();
        }
        return punti;
    }


    public String getName() {
        return name;
    }
}
