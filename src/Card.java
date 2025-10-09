public class Card {
    static int carte_costruite;
    static final int MAX_CARTE;
    Seme seme;
    Value figura;

    static {
        MAX_CARTE = 40;
        carte_costruite = 0;
    }

    Card(Seme seme, Value valore) {
        this.seme = seme;
        this.figura = valore;
        if(carte_costruite>=MAX_CARTE)
            System.exit(-1);
        Card.carte_costruite++;
    }

    void print() {
        System.out.println("Carta---------");
        seme.print();
        this.figura.print();
        System.out.println("--------------");
    }

}
