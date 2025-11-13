package it.unive.dais.po1.carte.giocatori.briscola;

import it.unive.dais.po1.carte.CarteInMano;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;
import it.unive.dais.po1.carte.CarteCumulo;
import it.unive.dais.po1.carte.briscola.BriscolaADue;
import it.unive.dais.po1.carte.briscola.BriscolaAQuattro;

/**
 * @author Pietro Ferrara
 * @since 1.0
 */
public class GiocatoreBirscolaIntelligente extends GiocatoreBirscolaIntelligente.GiocatoreDiBriscola {

    /**
     * Constructs a Giocatore (player) instance with the specified name.
     *
     * @param name the name of the player
     */
    public GiocatoreBirscolaIntelligente(String name) {
        super(name);
    }

    /**
     * Vede la carta e' a terra (se ce ne e' una),
     * e scarta una carta piu' "forte"
     */
    public final CartaTrevigiana scarta(CartaTrevigiana cartaATerra, BriscolaADue briscola) {
        CartaTrevigiana c1 = carteInMano.viewCard(1),
            c2=carteInMano.viewCard(2),
            c3 = carteInMano.viewCard(3);
        if(cartaATerra==null) {
            CartaTrevigiana c = null;
            if (c1 != null) {
                c = c1;
                carteInMano.remove(c1);
            } else if (c2 != null) {
                c = c2;
                carteInMano.remove(c2);
            } else if (c3 != null) {
                c = c3;
                carteInMano.remove(c3);
            } else System.exit(-1);
            return c;
        }
        else {
            CartaTrevigiana c = null;
            //Se c1 vince su cartaATerra torna c1
            //Altrimenti prova c2, e poi c3
            if(c1!=null && ! briscola.vince(cartaATerra, c1)) {
                c = c1;
                carteInMano.remove(c1);
            }
            else if(c2!=null && ! briscola.vince(cartaATerra, c2)) {
                c = c2;
                carteInMano.remove(c2);
            }
            else {
                if(c3!=null) {
                    c = c3;
                    carteInMano.remove(c3);
                }
                else {
                    if(c1!=null) {
                        c = c1;
                        carteInMano.remove(c1);
                        return c;
                    }
                    else if(c2!=null) {
                        c = c2;
                        carteInMano.remove(c2);
                        return c;
                    }
                    else System.exit(-1);
                }
            }
            return c;
        }
    }


    public CartaTrevigiana scarta(CarteCumulo carteATerra, BriscolaAQuattro briscola) {
        return carteInMano.pop();
    }

    public String getName() {
        return super.getName();
    }

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
    public abstract static class GiocatoreDiBriscola {

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
        public GiocatoreDiBriscola(String name) {
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
        final public void receiveCard(CartaTrevigiana pop) {
            carteInMano.storeCard(pop);
        }

        /**
         * Discards and returns a card from the player's hand.
         * If no cards are available, the program terminates.
         *
         * @return a card in the player's hand.
         * @since 1.0
         */
        abstract public CartaTrevigiana scarta(CartaTrevigiana cartaATerra, BriscolaADue briscola);


        abstract public CartaTrevigiana scarta(CarteCumulo carteATerra, BriscolaAQuattro briscola);

        /**
         * Stores the specified card in a player's deck.
         *
         * @param c1 the card to be stored in the deck
         */
        final public void storeCard(CartaTrevigiana c1) {
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
    public static class GiocatoreDiBriscolaNaive extends GiocatoreDiBriscola {

        public GiocatoreDiBriscolaNaive(String name) {
            //costruisci cio' che mi sta "sopra"
            super(name);//la prima istruzione invoca un costruttore della superclasse
        }
        public CartaTrevigiana scarta(CartaTrevigiana cartaATerra, BriscolaADue briscola) {
            return carteInMano.pop();
        }

        public CartaTrevigiana scarta(CarteCumulo carteATerra, BriscolaAQuattro briscola) {
            return carteInMano.pop();
        }

        public String getName() {
            return super.getName();
        }

    }
}
