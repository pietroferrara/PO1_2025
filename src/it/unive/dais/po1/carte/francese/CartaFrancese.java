package it.unive.dais.po1.carte.francese;

import it.unive.dais.po1.carte.Carta;

public class CartaFrancese extends Carta<SemeFrancese, ValueFrancese> {


    public CartaFrancese(SemeFrancese seme, ValueFrancese valore) {
        super(seme, valore);
    }


    public void print() {
        System.out.println("Carta Francese---------");
        System.out.println(this);
        System.out.println("--------------");
    }

}
