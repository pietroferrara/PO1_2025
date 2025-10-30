package it.unive.dais.po1.gioco.carte.briscola.giocatori;

import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.briscola.Briscola;

/**
 * The Giocatore class represents a player in a briscola game.
 * Each player has a name, a hand consisting of up to three cards,
 * and a deck of stored cards. Players can receive cards, discard cards,
 * and store cards in their deck. They can also calculate their points
 * based on the cards in their deck.
 *
 * @author Pietro Ferrara
 * @since 1.0
 */
public class GiocatoreNaive extends Giocatore {

    public GiocatoreNaive(String name) {
        //costruisci cio' che mi sta "sopra"
        super(name);//la prima istruzione invoca un costruttore della superclasse
    }
    public Card scarta(Card cartaATerra, Briscola briscola) {
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

    public Card scarta() { return null;}

    public String getName() {
        return super.getName()+" is a naive player";
    }

}
