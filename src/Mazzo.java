import java.util.Arrays;
import java.util.Collections;

public class Mazzo {
    Card[] deck;
    Mazzo() {
        deck = new Card[40];
        for(int i =1; i<=4; i++) {
            for(int j =1; j<=10; j++) {
                Card c = new Card(Seme.getSeme(i), Value.getValue(j));
                deck[(i-1)*10+j-1] = c;
            }
        }
    }

    void mischia() {
        Collections.shuffle(Arrays.asList(deck));
    }

    public Card get(int i) {
        return deck[i];
    }
}
