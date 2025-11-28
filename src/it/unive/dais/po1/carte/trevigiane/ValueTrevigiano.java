package it.unive.dais.po1.carte.trevigiane;

import it.unive.dais.po1.carte.Value;
import it.unive.dais.po1.carte.ValueOfCard;

public enum ValueTrevigiano implements Value {
    //1 asso, 2, 3, 4, 5, 6, 7, 8 fante, 9 cavallo, 10 re
    Asso(1), Due(2), Tre(3), Quattro(4), Cinque(5), Sei(6), Sette(7), Fante(8), Cavallo(9), Re(10);


    private final int value;
    private ValueTrevigiano(int value) {
        this.value = value;
    }

    public static ValueTrevigiano getValue(int j) {
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
                return Fante;
            case 9:
                return Cavallo;
            case 10:
                return Re;
            default:
                return null;
        }
    }


    @Deprecated
    public void print() {
        System.out.println(this.name());
    }

    //FIXME: questo dovrebbe essere in Briscola (encapsulation)
    public boolean maggiore(ValueTrevigiano valore) {
        if(this==Asso)
            return true;
        else if(this==Tre) {
            if (valore == Asso)
                return false;
            else
                return true;
        }
        else if(valore==Asso || valore==Tre)
            return false;
        else
            return this.value>=valore.value;
    }

    @ValueOfCard
    public int getValue() {
        return value;
    }
}
