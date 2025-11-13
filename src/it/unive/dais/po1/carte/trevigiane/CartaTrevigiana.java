package it.unive.dais.po1.carte.trevigiane;

import it.unive.dais.po1.DesignByContract;
import it.unive.dais.po1.carte.Carta;


public class CartaTrevigiana extends Carta<SemeTrevigiano, ValueTrevigiano> {

    private static int carte_costruite;
    public static final int MAX_CARTE;


    static {
        MAX_CARTE = 40;
        carte_costruite = 0;
    }

    public CartaTrevigiana(SemeTrevigiano seme, ValueTrevigiano valore) {
        super(seme, valore);
        CartaTrevigiana.carte_costruite++;
    }

    public static int getCarte_costruite() {
        return carte_costruite;
    }

    public static void reset() {
        DesignByContract.checkPrecondition(CartaTrevigiana.carte_costruite==40 || CartaTrevigiana.carte_costruite==0);
        CartaTrevigiana.carte_costruite = 0;
    }

    //FIXME: Spostare in Briscola
    public void print() {
        System.out.println("Carta Trevigiana---------");
        seme.print();
        this.valore.print();
        System.out.println("--------------");
    }

    public int punti() {
        switch(this.valore) {
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
