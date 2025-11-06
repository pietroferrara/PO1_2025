package it.unive.dais.po1.diamond.multipleinheritance;

public class CellaRaddoppia extends Cella {
    public CellaRaddoppia(int value) {
        super(value);
    }
    public void step() {
        this.setValue(this.getValue()*2);
    }
}
