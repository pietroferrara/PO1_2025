package it.unive.dais.po1.gioco.carte;

import it.unive.dais.po1.gioco.carte.briscola.PopCard;

public class CarteInMano extends StackCarte implements Storable, PopCard {

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


    public int getCarteRimanenti() {
        return super.size()-super.getEmptySlots();
    }

    public Card viewCard(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                return stack[i-1];
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
        stack[i] = null;
        for(int j=i; j<stack.length-1; j++) {
            stack[j] = stack[j+1];
        }
        super.first_empty_slot--;
        stack[stack.length-1] = null;
    }

    private int find(Card c) {
        for(int i=0; i<stack.length; i++) {
            if(stack[i]==c) {
                return i;
            }
        }
        System.err.println("Carta non presente nella mano");
        System.exit(-1);
        return -1;
    }

}
