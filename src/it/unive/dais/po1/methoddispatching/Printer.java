package it.unive.dais.po1.methoddispatching;

public class Printer {
    public void print() {
        System.out.println("Hello world");
    }

    public void print(int i) {
        System.out.print("Hello world "+i+" times");
    }
}
