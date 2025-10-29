package it.unive.dais.po1.gioco.carte.briscola.giocatori.intelligenti;

import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;

/**
 * @author Pietro Ferrara
 * @since 1.0
 */
public class GiocatoreIntelligente extends Giocatore {

    /**
     * Constructs a Giocatore (player) instance with the specified name.
     *
     * @param name the name of the player
     */
    public GiocatoreIntelligente(String name) {
        super(name);
    }

    /**
     * Vede la carta e' a terra (se ce ne e' una),
     * e scarta una carta piu' "forte"
     */
    public Card scarta(Card cartaATerra, BriscolaIntelligente briscola) {
        if(cartaATerra==null) {
            Card c = null;
            if (c1 != null) {
                c = c1;
                this.c1 = null;
            } else if (c2 != null) {
                c = c2;
                this.c1 = null;
            } else if (c3 != null) {
                c = c3;
                this.c3 = null;
            } else System.exit(-1);
            return c;
        }
        else {
            Card c = null;
            //Se c1 vince su cartaATerra torna c1
            //Altrimenti prova c2, e poi c3
            if(c1!=null && ! briscola.vince(cartaATerra, c1)) {
                c = c1;
                this.c1 = null;
            }
            else if(c2!=null && ! briscola.vince(cartaATerra, c2)) {
                c = c2;
                this.c2 = null;
            }
            else {
                if(c3!=null) {
                    c = c3;
                    this.c3 = null;
                }
                else System.exit(-1);
            }
            return c;
        }
    }


}
