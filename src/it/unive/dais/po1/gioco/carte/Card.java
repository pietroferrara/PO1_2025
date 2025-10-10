package it.unive.dais.po1.gioco.carte;

public class Card {
    public static int carte_costruite;
    public static final int MAX_CARTE;
    private final Seme seme;
    private final Value figura;

    public Seme getSeme() {
        return seme;
    }
    public Value getFigura() {
        return figura;
    }

    static {
        MAX_CARTE = 40;
        carte_costruite = 0;
    }

    public Card(Seme seme, Value valore) {
        this.seme = seme;
        this.figura = valore;
        if(carte_costruite>=MAX_CARTE)
            System.exit(-1);
        Card.carte_costruite++;
    }

    public void print() {
        System.out.println("Carta---------");
        seme.print();
        this.figura.print();
        System.out.println("--------------");
    }

}
