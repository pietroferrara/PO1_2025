package it.unive.dais.po1.gioco.carte;

public class Card {

    private static int carte_costruite;
    public static final int MAX_CARTE;
    private final Seme seme;
    private final Value figura;


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

    public static int getCarte_costruite() {
        return carte_costruite;
    }

    public Seme getSeme() {
        return seme;
    }

    public Value getFigura() {
        return figura;
    }

    public void print() {
        System.out.println("Carta---------");
        seme.print();
        this.figura.print();
        System.out.println("--------------");
    }

    public int punti() {
        switch(this.figura) {
            case Asso:
                return 11;
            case Tre:
                return 10;
            case Re:
                return 4;
            case Cavallo:
                return 3;
            case Fante:
                return 2;
            default:
                return 0;
        }
    }
}
