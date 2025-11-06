package it.unive.dais.po1.diamond.multipleinheritance;

public class CellaIncrementa extends Cella {
    public CellaIncrementa(int value) {
        super(value);
    }
    public void step() {
        this.setValue(this.getValue()+1);
    }
}
