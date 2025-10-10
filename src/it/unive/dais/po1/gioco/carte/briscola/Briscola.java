package it.unive.dais.po1.gioco.carte.briscola;

import it.unive.dais.po1.gioco.carte.Seme;
import it.unive.dais.po1.gioco.carte.Value;
import it.unive.dais.po1.gioco.carte.Card;

public class Briscola {



    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    public static boolean vince(Card prima, Card seconda, Seme briscola) {
        if(prima.getSeme()== briscola) {
            if(seconda.getSeme()!= briscola) {
                return true;
            }
            else {
                return prima.getFigura().maggiore(seconda.getFigura());
            }
        }
        else if(seconda.getSeme()== briscola) {
            return false;
        }
        if(seconda.getSeme()==prima.getSeme())
            return prima.getFigura().maggiore(seconda.getFigura());
        else
            return true;
    }
}
