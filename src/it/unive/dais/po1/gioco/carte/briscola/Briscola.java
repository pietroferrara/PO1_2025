package it.unive.dais.po1.gioco.carte.briscola;

import it.unive.dais.po1.gioco.Mazzo;
import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;

abstract public class Briscola {

    protected Card briscola;

    protected Mazzo mazzo;

    public Briscola() {
        mazzo = new Mazzo();
        mazzo.mischia();
    }


    abstract public Giocatore giocaPartita();

    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    public boolean maggiore(Card prima, Card seconda) {
        if(prima.getSeme()== briscola.getSeme()) {
            if(seconda.getSeme()!= briscola.getSeme()) {
                return true;
            }
            else {
                return prima.getFigura().maggiore(seconda.getFigura());
            }
        }
        else if(seconda.getSeme()== briscola.getSeme()) {
            return false;
        }
        if(seconda.getSeme()==prima.getSeme())
            return prima.getFigura().maggiore(seconda.getFigura());
        else
            return true;
    }

    public boolean vince(Card prima, Card seconda) {
        if(prima.getSeme()== briscola.getSeme()) {
            if(seconda.getSeme()!= briscola.getSeme()) {
                return true;
            }
            else {
                return prima.getFigura().maggiore(seconda.getFigura());
            }
        }
        else if(seconda.getSeme()== briscola.getSeme()) {
            return false;
        }
        if(seconda.getSeme()==prima.getSeme())
            return prima.getFigura().maggiore(seconda.getFigura());
        else
            return false;
    }

}