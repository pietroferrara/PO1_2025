package it.unive.dais.po1;

public class DesignByContract {

    static public void checkPrecondition(boolean b) {
        if (!b) {
            System.err.println("Precondition violated");
            System.exit(-1);
        }
    }

    static public void checkPostcondition(boolean b) {
        if (!b) {
            System.err.println("Postcondition violated");
            System.exit(-1);
        }
    }
}
