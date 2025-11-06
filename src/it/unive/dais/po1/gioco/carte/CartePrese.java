package it.unive.dais.po1.gioco.carte;

import it.unive.dais.po1.gioco.carte.briscola.PopCard;

public class CartePrese extends StackCarte implements Storable, PopCard {
    public CartePrese() {
        super(40);
    }

    public void storeCard(Card c1) {
        super.push(c1);
    }

    public Card pop() {
        return super.pop();
    }

    public int getCarteRimanenti() {
        return super.size()-super.getEmptySlots();
    }
}
