package it.unive.dais.po1.methoddispatching;

public class Printer {

    static public void staticprinting() {
        System.out.println("Hello world from static method");
    }

    public void print() {
        System.out.println("Hello world");
    }

    public void print(int i) {
        System.out.println("Hello world "+i+" times");
    }

    public void print(String s) {
        System.out.println("Hello world "+s);
    }

    public void print(Provider provider) {
        System.out.println("Hello world "+ provider.getName());
    }


    public void print(SubProvider provider) {
        System.out.println("Hello sub world "+ provider.getName());
    }

    public void print(Provider provider, SubProvider provider2) {
        System.out.println("Hello provider-subprovider "+ provider.getName()+" "+provider2.getName());
    }

    /*public void print(SubProvider provider, Provider provider2) {
        System.out.println("Hello subprovider-provider "+ provider.getName()+" "+provider2.getName());
    }*/
}
