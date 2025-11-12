package it.unive.dais.po1.gioco.carte.briscola.giocatori;

import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.CarteInMano;
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
public abstract class Giocatore {

    /**
     * Represents three cards a player can hold at a time
     * during the game of Briscola. The variable's value is dynamically updated
     * as cards are received or discarded by the player.
     */
    //FIXME: utilizza invece una lista di 3 carte
    //protected Card c1;
    //protected Card c2;
    //protected Card c3;
    protected CarteInMano carteInMano = new CarteInMano();
    private final String name;
    private CarteCumulo cartePrese = new CarteCumulo();

    /**
     * Constructs a Giocatore (player) instance with the specified name.
     *
     * @param name the name of the player
     */
    public Giocatore(String name) {
        this.name = name;
    }

    public void reset() {
        this.carteInMano = new CarteInMano();
        this.cartePrese = new CarteCumulo();
    }


    final public int getCartePrese() {
        int totale = 0;
        if(carteInMano.viewCard(1)!=null) totale++;
        if(carteInMano.viewCard(2)!=null) totale++;
        if(carteInMano.viewCard(3)!=null) totale++;
        return totale + cartePrese.getCarteRimanenti();
    }

    /**
     * Receives a card.
     * If all card slots are occupied, the program exits
     * with a status of -1.
     *
     * @param pop the card to be received
     */
    final public void receiveCard(Card pop) {
        carteInMano.storeCard(pop);
    }

    /**
     * Discards and returns a card from the player's hand.
     * If no cards are available, the program terminates.
     *
     * @return a card in the player's hand.
     * @since 1.0
     */
    abstract public Card scarta(Card cartaATerra, BriscolaADue briscola);


    abstract public Card scarta(CarteCumulo carteATerra, BriscolaAQuattro briscola);

    /**
     * Stores the specified card in a player's deck.
     *
     * @param c1 the card to be stored in the deck
     */
    final public void storeCard(Card c1) {
        this.cartePrese.storeCard(c1);
    }

    /**
     * Calculates the total points based on the cards stored
     * in the player's deck following briscola rules.
     *
     * @return the total points
     */
    final public int contaPunti() {
        int punti = 0;
        while(cartePrese.getCarteRimanenti()>0) {
            punti+= cartePrese.pop().punti();
        }
        return punti;
    }


    /**
     * Retrieves the name of the player.
     *
     * @return the name of the player as a string.
     */
    public String getName() {
        return name;
    }
}
