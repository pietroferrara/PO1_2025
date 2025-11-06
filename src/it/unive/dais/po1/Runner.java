package it.unive.dais.po1;

import it.unive.dais.po1.gioco.Mazzo;
import it.unive.dais.po1.gioco.carte.*;
import it.unive.dais.po1.gioco.carte.briscola.Briscola;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.intelligenti.GiocatoreIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.GiocatoreNaive;
import it.unive.dais.po1.methoddispatching.BoredPrinter;
import it.unive.dais.po1.methoddispatching.Printer;
import it.unive.dais.po1.quadrilateri.Quadrilatero;

import java.util.Random;

public class Runner {

    public static void main(String[] args) {

        Printer p = null;
        if(new Random().nextBoolean()) {
            p = new Printer();
        }
        else p = new BoredPrinter();
        p.print();
        p.print(10);
    }

    private static void playManyMatches() {
        double vinteg1 = 0, vinteg2 = 0;

        for(int i = 0; i < 1000; i++) {
            Card.reset();
            Giocatore g1, g2;
            if(new Random().nextBoolean())
                g1 = new GiocatoreIntelligente("Pietro");
            else g1 = new GiocatoreNaive("Pietro");
            if(new Random().nextBoolean())
                g2=new GiocatoreIntelligente("Alessio");
            else g2=new GiocatoreNaive("Alessio");

            Briscola b = new Briscola(g1, g2);
            Giocatore g = b.giocaPartita();
            if(g==null) {
                vinteg1 = vinteg1 + 0.5;
                vinteg2 =vinteg2  + 0.5;
            }
            else if(g.getName().equals("Pietro")) vinteg1++;
            else if(g.getName().equals("Alessio")) vinteg2++;
            if(g==null) System.out.println("Partita patta");
            else if (g == g1 || g == g2)
                System.out.println("Ha vinto " + g.getName());
            else System.err.println("Valore non concesso " + g.getName());
        }

        System.out.println("Vinte g1: " + vinteg1 + ", vinte g2: " + vinteg2);
    }

}
