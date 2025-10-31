package it.unive.dais.po1.quadrilateri;

public class Quadrato extends Quadrilatero {
    public Quadrato(int lato) {
        super(lato, lato, lato, lato);
    }

    @Override
    public float getArea() {
        return this.lato1*this.lato1;
    }
}
