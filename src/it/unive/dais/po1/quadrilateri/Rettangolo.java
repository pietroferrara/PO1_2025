package it.unive.dais.po1.quadrilateri;

public class Rettangolo extends Quadrilatero {
    public Rettangolo(int base, int altezza) {
        super(base, base, altezza, altezza, base*altezza);
    }
}
