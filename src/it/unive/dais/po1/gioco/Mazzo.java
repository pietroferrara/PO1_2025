package it.unive.dais.po1.gioco;

import it.unive.dais.po1.gioco.carte.Seme;
import it.unive.dais.po1.gioco.carte.Value;
import it.unive.dais.po1.gioco.carte.Card;

import java.util.Arrays;
import java.util.Collections;

public class Mazzo {
    private Card[] deck;
    //Prima carta disponibile partendo da sinistra
    private int first_card_index;
    public Mazzo() {
        deck = new Card[40];
        first_card_index = 40;
    }

    public void riempiMazzo() {
        for(int i =1; i<=4; i++) {
            Seme corrente = i==1 ? Seme.Denari:
                    i==2 ? Seme.Bastoni:
                    i==3 ? Seme.Coppe :
                    i==4 ? Seme.Spade : null;
            for(int j =1; j<=10; j++) {
                Card c = new Card(corrente, Value.getValue(j));
                deck[(i-1)*10+j-1] = c;
            }
        }
        first_card_index = 0;
    }

    public void mischia() {
        Collections.shuffle(Arrays.asList(deck));
    }

    public int getCarteRimanenti() {
        return deck.length-first_card_index;
    }
    public Card get(int i) {
        return deck[i];
    }

    public Card pop() {
        Card c = deck[first_card_index];
        deck[first_card_index] = null;
        first_card_index++;
        return c;
    }

    public void storeCard(Card c1) {
        first_card_index--;
        deck[first_card_index] = c1;
    }
}
