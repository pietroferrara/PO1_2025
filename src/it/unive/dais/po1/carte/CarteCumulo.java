package it.unive.dais.po1.carte;

import it.unive.dais.po1.carte.briscola.PopCard;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;

public class CarteCumulo extends Stack<CartaTrevigiana> implements Storable, PopCard {
    public CarteCumulo() {
        super(40);
    }

    public void storeCard(CartaTrevigiana c1) {
        super.push(c1);
    }

    public CartaTrevigiana pop() {
        return super.pop();
    }

    public int getCarteRimanenti() {
        return super.nonEmptySlots();
    }
}
