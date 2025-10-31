package it.unive.dais.po1.quadrilateri;

public class Trapezio extends Quadrilatero {
    private int base1, base2, altezza;
    public Trapezio(int base1, int base2, int lato1, int lato2, int altezza) {
        super(base1, base2, lato1, lato2);
        this.base1 = base1;
        this.base2 = base2;
        this.altezza = altezza;
    }

    @Override
    public float getArea() {
        return ((base1+base2)*altezza)/2;
    }
}
