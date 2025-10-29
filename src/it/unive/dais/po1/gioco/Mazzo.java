package it.unive.dais.po1.gioco;

import it.unive.dais.po1.DesignByContract;
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
        //precondition this.getCarteRimanenti()==40
        DesignByContract.checkPrecondition(this.getCarteMancanti()==40);

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
        DesignByContract.checkPostcondition(this.getCarteMancanti()==0);
        //postcondition tutte le carte nel mazzo sono diverse
        for(int i =0; i<deck.length-1; i++) {
            for(int j=0; j<deck.length-1; j++) {
                if(i!=j)
                    if(deck[i].getSeme()==deck[j].getSeme() && deck[i].getFigura()==deck[j].getFigura()) {
                        System.err.println("Due carte uguali nel mazzo, postcondition violated");
                        System.exit(-1);
                    }
            }
            //postcondition \forall i, j \in [0, deck.length-1] : i!=j AND deck[i] != deck[j]
        }
    }

    public void mischia() {
        DesignByContract.checkPrecondition(this.getCarteRimanenti()==40);
        Collections.shuffle(Arrays.asList(deck));
        DesignByContract.checkPrecondition(this.getCarteRimanenti()==40);
    }

    public int getCarteRimanenti() {
        return deck.length-first_card_index;
    }

    public int getCarteMancanti() {
        return 40-this.getCarteRimanenti();
    }
    public Card get(int i) {
        return deck[i];
    }

    public Card pop() {
        DesignByContract.checkPrecondition(this.getCarteRimanenti()>0);
        int cartePresentiIniziali = this.getCarteRimanenti();
        Card c = deck[first_card_index];
        deck[first_card_index] = null;
        first_card_index++;
        DesignByContract.checkPostcondition(this.getCarteRimanenti()==cartePresentiIniziali-1);
        return c;
    }

    public void storeCard(Card c1) {
        DesignByContract.checkPrecondition(this.getCarteMancanti()>0);
        int cartePresentiIniziali = this.getCarteRimanenti();
        first_card_index--;
        deck[first_card_index] = c1;
        DesignByContract.checkPostcondition(this.getCarteRimanenti()==cartePresentiIniziali+1);
    }
}
