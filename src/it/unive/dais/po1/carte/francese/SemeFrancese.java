package it.unive.dais.po1.carte.francese;

import it.unive.dais.po1.carte.Seme;

public enum SemeFrancese implements Seme {
    Fiori, Picche, Cuori, Quadri;

    public void print() {
        System.out.println(this);
    }
}
