package it.unive.dais.po1;

import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.briscola.Briscola;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.intelligenti.GiocatoreIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.GiocatoreNaive;
import it.unive.dais.po1.quadrilateri.Quadrilatero;

public class Runner {

    static void printArea(Quadrilatero a) {
        System.out.println("Area: " + a.getArea());
    }
    public static void main(String[] args) {
        double vinteg1 = 0, vinteg2 = 0;

        for(int i = 0; i < 100; i++) {
            Card.reset();
            Giocatore g1 = new GiocatoreIntelligente("Pietro"), g2=new GiocatoreNaive("Alessio");
            Briscola b = new Briscola(g1, g2);
            Giocatore g = b.giocaPartita();
            if(g==g1) vinteg1++;
            else if(g==g2) vinteg2++;
            else {
                vinteg1 = vinteg1 + 0.5;
                vinteg2 =vinteg2  + 0.5;
            }
            if(g==null) System.out.println("Partita patta");
            else if (g == g1 || g == g2) // g \in {null, g1, g2}
                System.out.println("Ha vinto " + g.getName());
            else System.err.println("Valore non concesso " + g.getName());
        }

        System.out.println("Vinte g1: " + vinteg1 + ", vinte g2: " + vinteg2);
    }

}
