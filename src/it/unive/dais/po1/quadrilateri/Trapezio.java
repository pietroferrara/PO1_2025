package it.unive.dais.po1.quadrilateri;

public class Trapezio extends Quadrilatero {
    public Trapezio(int base1, int base2, int lato1, int lato2, int altezza) {
        super(base1, base2, lato1, lato2, ((base1+base2)*altezza)/2);
    }

}
