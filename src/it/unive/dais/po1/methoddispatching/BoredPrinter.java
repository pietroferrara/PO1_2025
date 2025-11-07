package it.unive.dais.po1.methoddispatching;

public class BoredPrinter extends Printer {
    public void print() {
        System.out.println("I'm bored... hello world");
    }

    static public void staticprinting() {
        System.out.println("I'm bored... static hello world");
    }
}
