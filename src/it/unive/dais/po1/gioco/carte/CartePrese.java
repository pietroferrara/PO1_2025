package it.unive.dais.po1.gioco.carte;

public class CartePrese extends StackCarte {
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
