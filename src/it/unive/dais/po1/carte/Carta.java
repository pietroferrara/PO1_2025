package it.unive.dais.po1.carte;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carta<?, ?> carta)) return false;
        return Objects.equals(seme, carta.seme) && Objects.equals(valore, carta.valore);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(seme);
    }
/*@Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Carta))
            return false;
        Carta c = (Carta) obj;
        return this.seme.equals(c.seme) &&
                this.valore.equals(c.valore);
    }

    @Override
    public int hashCode() {
        return 0;
    }*/

    @Override
    public String toString() {
        return "(" + valore +
                ", " + seme +
                ')';
    }
}
