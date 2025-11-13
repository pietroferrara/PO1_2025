package it.unive.dais.po1.carte;

public class Carta<S extends Seme, V extends Value> {

    protected final S seme;
    protected final V valore;


    public Carta(S seme, V valore) {
        this.seme = seme;
        this.valore = valore;
    }


    public S getSeme() {
        return seme;
    }

    public V getValore() {
        return valore;
    }

    //FIXME: Spostare in Briscola
    public void print() {
        System.out.println("Carta---------");
        seme.print();
        this.valore.print();
        System.out.println("--------------");
    }

}
