package it.unive.dais.po1.gioco;

import it.unive.dais.po1.DesignByContract;
import it.unive.dais.po1.gioco.carte.*;
import it.unive.dais.po1.gioco.carte.briscola.PopCard;

import java.util.Arrays;
import java.util.Collections;

public class Mazzo extends Stack<Card> implements PopCard {
    public Mazzo() {
        super(40);
        this.riempiMazzo();
    }

    private void riempiMazzo() {
        for(int i =1; i<=4; i++) {
            Seme corrente = i==1 ? Seme.Denari:
                    i==2 ? Seme.Bastoni:
                    i==3 ? Seme.Coppe :
                    i==4 ? Seme.Spade : null;
            for(int j =1; j<=10; j++) {
                Card c = new Card(corrente, Value.getValue(j));
                super.push(c);
            }
        }
    }

    public void mischia() {
        DesignByContract.checkPrecondition(this.getCarteRimanenti()==40);
        Collections.shuffle(list);
        DesignByContract.checkPrecondition(this.getCarteRimanenti()==40);
    }

    public int getCarteRimanenti() {
        return super.nonEmptySlots();
    }

    public int getCarteMancanti() {
        return super.getEmptySlots();
    }

    public Card pop() {
        return super.pop();
    }
}
