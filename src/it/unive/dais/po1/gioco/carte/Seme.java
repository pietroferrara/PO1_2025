package it.unive.dais.po1.gioco.carte;

public enum Seme {
    Spade, Denari, Bastoni, Coppe;

    public void print() {
        switch (this) {
            case Spade:
                System.out.println("Spade");
                break;
            case Denari:
                System.out.println("Denari");
                break;
            case Bastoni:
                System.out.println("Bastoni");
                break;
            case Coppe:
                System.out.println("Coppe");
        }
    }
}
