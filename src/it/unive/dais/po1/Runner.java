package it.unive.dais.po1;

import it.unive.dais.po1.gioco.carte.*;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaADue;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaAQuattro;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.intelligenti.GiocatoreIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.GiocatoreNaive;

import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        playManyMatches4Players();
    }

    private static void playManyMatches2Players() {
        double vinteg1 = 0, vinteg2 = 0;
        Giocatore g1, g2;
        if(new Random().nextBoolean())
            g1 = new GiocatoreIntelligente("Pietro");
        else g1 = new GiocatoreNaive("Pietro");
        if(new Random().nextBoolean())
            g2=new GiocatoreIntelligente("Alessio");
        else g2=new GiocatoreNaive("Alessio");

        for(int i = 0; i < 1000; i++) {
            Card.reset();

            BriscolaADue b = new BriscolaADue(g1, g2);
            Giocatore g = b.giocaPartita();
            if(g==null) {
                vinteg1 = vinteg1 + 0.5;
                vinteg2 =vinteg2  + 0.5;
            }
            else if(g.getName().equals("Pietro")) vinteg1++;
            else if(g.getName().equals("Alessio")) vinteg2++;
            if(g==null) System.out.println("Partita patta");
            else System.out.println("Ha vinto " + g.getName());

        }

        System.out.println("Vinte g1: " + vinteg1 + ", vinte g2: " + vinteg2);
    }

    private static void playManyMatches4Players() {
        double vintesquadra1 = 0, vintesquadra2 = 0;
        Giocatore g1, g2, g3, g4;
        if(new Random().nextBoolean())
            g1 = new GiocatoreIntelligente("Pietro");
        else g1 = new GiocatoreNaive("Pietro");
        if(new Random().nextBoolean())
            g2=new GiocatoreIntelligente("Alessio");
        else g2=new GiocatoreNaive("Alessio");
        if(new Random().nextBoolean())
            g3 = new GiocatoreIntelligente("Gianluca");
        else g3 = new GiocatoreNaive("Gianluca");
        if(new Random().nextBoolean())
            g4=new GiocatoreIntelligente("Mario");
        else g4=new GiocatoreNaive("Mario");

        for(int i = 0; i < 1000; i++) {
            Card.reset();

            BriscolaAQuattro b = new BriscolaAQuattro(g1, g2, g3, g4);
            Giocatore g = b.giocaPartita();
            if(g==null) {
                vintesquadra1 = vintesquadra1 + 0.5;
                vintesquadra2 =vintesquadra2  + 0.5;
                System.out.println("Partita patta");
            }
            else if(g.getName().equals("Pietro") || g.getName().equals("Gianluca")) vintesquadra1++;
            else if(g.getName().equals("Alessio") || g.getName().equals("Mario")) vintesquadra2++;

        }

        System.out.println("Vinte squadra 1: " + vintesquadra1 + ", vinte squadra 2: " + vintesquadra2);
    }


}
