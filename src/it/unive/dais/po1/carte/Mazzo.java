package it.unive.dais.po1.carte;

import it.unive.dais.po1.carte.briscola.PopCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract public class Mazzo<C extends Carta> extends Stack<C> implements PopCard {
    public Mazzo(int max_carte) {
        super(max_carte);
        this.riempiMazzo();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    abstract protected void riempiMazzo();

    public void mischia() {
        Collections.shuffle(list);
    }

    public int getCarteRimanenti() {
        return super.nonEmptySlots();
    }

    public int getCarteMancanti() {
        return super.getEmptySlots();
    }

    public C pop() {
        if(super.list.size()==0)
            return null;
        else return super.pop();
    }
}
