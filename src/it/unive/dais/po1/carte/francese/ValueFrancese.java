package it.unive.dais.po1.carte.francese;

import it.unive.dais.po1.carte.Value;

public enum ValueFrancese implements Value {
    //1 asso, 2, 3, 4, 5, 6, 7, 8 fante, 9 cavallo, 10 re
    Asso(1), Due(2), Tre(3), Quattro(4), Cinque(5), Sei(6), Sette(7), Otto(8),  Nove(9),  Dieci(10),  Jack(11), Queen(12), King(13);


    private final int value;
    private ValueFrancese(int value) {
        this.value = value;
    }

    public void print() {
        System.out.println(this.name());
    }


    public static ValueFrancese getValue(int j) {
        switch (j) {
            case 1:
                return Asso;
            case 2:
                return Due;
            case 3:
                return Tre;
            case 4:
                return Quattro;
            case 5:
                return Cinque;
            case 6:
                return Sei;
            case 7:
                return Sette;
            case 8:
                return Otto;
            case 9:
                return Nove;
            case 10:
                return Dieci;
            case 11:
                return Jack;
            case 12:
                return Queen;
            case 13:
                return King;
            default:
                return null;
        }
    }
}
