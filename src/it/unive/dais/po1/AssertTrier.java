package it.unive.dais.po1;

public class AssertTrier {
    private int x;
    public AssertTrier(int x) {
        this.x=x;
    }

    public void validate() {
        assert x>0;
    }
}
