package it.unive.dais.po1.diamond.multipleinheritance;

public abstract class Cella {
    private int value;
    public Cella(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    protected void setValue(int value) {
        this.value = value;
    }

    abstract public void step();
}
