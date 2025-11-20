package it.unive.dais.po1.carte.briscola;

import it.unive.dais.po1.carte.gioco.GiocoDiCarte;
import it.unive.dais.po1.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;

abstract public class Briscola extends GiocoDiCarte<MazzoTrevigiano> {

    protected CartaTrevigiana briscola;

    public Briscola() {
        super(new MazzoTrevigiano());
    }



    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    public boolean maggiore(CartaTrevigiana prima, CartaTrevigiana seconda) {
        if(prima.getSeme()== briscola.getSeme()) {
            if(seconda.getSeme()!= briscola.getSeme()) {
                return true;
            }
            else {
                return prima.getValore().maggiore(seconda.getValore());
            }
        }
        else if(seconda.getSeme()== briscola.getSeme()) {
            return false;
        }
        if(seconda.getSeme()==prima.getSeme())
            return prima.getValore().maggiore(seconda.getValore());
        else
            return true;
    }

    public boolean vince(CartaTrevigiana prima, CartaTrevigiana seconda) {
        if(prima.getSeme()== briscola.getSeme()) {
            if(seconda.getSeme()!= briscola.getSeme()) {
                return true;
            }
            else {
                return prima.getValore().maggiore(seconda.getValore());
            }
        }
        else if(seconda.getSeme()== briscola.getSeme()) {
            return false;
        }
        if(seconda.getSeme()==prima.getSeme())
            return prima.getValore().maggiore(seconda.getValore());
        else
            return false;
    }

}