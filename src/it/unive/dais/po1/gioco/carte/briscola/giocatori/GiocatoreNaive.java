package it.unive.dais.po1.gioco.carte.briscola.giocatori;

import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.CarteCumulo;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaADue;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaAQuattro;

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
    public Card scarta(Card cartaATerra, BriscolaADue briscola) {
        return carteInMano.pop();
    }

    public Card scarta(CarteCumulo carteATerra, BriscolaAQuattro briscola) {
        return carteInMano.pop();
    }

    public String getName() {
        return super.getName();
    }

}
