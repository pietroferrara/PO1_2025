package it.unive.dais.po1.methoddispatching;

public class SubProvider extends Provider{
    public String getName() {
        return "sub "+super.getName();
    }
}
