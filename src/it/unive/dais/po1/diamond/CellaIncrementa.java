package it.unive.dais.po1.diamond;

public interface CellaIncrementa extends Cella {
    default void step() {
        this.setValue(this.getValue()+1);
    }
}
