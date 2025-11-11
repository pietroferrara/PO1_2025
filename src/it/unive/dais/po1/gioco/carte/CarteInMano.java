package it.unive.dais.po1.gioco.carte;

import it.unive.dais.po1.gioco.carte.briscola.PopCard;

public class CarteInMano extends Stack<Card> implements Storable, PopCard {

    public CarteInMano() {
        super(3);
    }

    public void storeCard(Card c1) {
        if(this.getEmptySlots() > 0) {
            super.push(c1);
        }
        else {
            System.err.println("Mano piena");
            System.exit(-1);
        }
    }

    public Card viewCard(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                return list.get(i-1);
            default:
                System.err.println("Carta a indice " + i + " non esistente");
                System.exit(-1);
        }
        return null;
    }

    //Ritorna una carta casuale
    public Card pop() {
        return super.pop();
    }

    public void remove(Card c) {
        int i = find(c);
        list.set(i, null);
        for(int j = i; j< list.size()-1; j++) {
            list.set(j, list.get(j+1));
        }
        list.set(list.size()-1, null);
    }

    private int find(Card c) {
        for(int i = 0; i< list.size(); i++) {
            if(list.get(i)==c) {
                return i;
            }
        }
        System.err.println("Carta non presente nella mano");
        System.exit(-1);
        return -1;
    }

}
