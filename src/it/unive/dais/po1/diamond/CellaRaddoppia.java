package it.unive.dais.po1.diamond;

public interface CellaRaddoppia extends Cella {
    default void step() {
        this.setValue(this.getValue()*2);
    }
}
