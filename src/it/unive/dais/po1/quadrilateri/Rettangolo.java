package it.unive.dais.po1.quadrilateri;

public class Rettangolo extends Quadrilatero {
    public Rettangolo(int base, int altezza) {
        super(base, base, altezza, altezza);
    }

    @Override
    public float getArea() {
        return this.lato1*this.lato3;
    }
}
