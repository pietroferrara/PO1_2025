package it.unive.dais.po1;

import it.unive.dais.po1.carte.*;
import it.unive.dais.po1.carte.briscola.BriscolaADue;
import it.unive.dais.po1.carte.briscola.BriscolaAQuattro;
import it.unive.dais.po1.carte.francese.CartaFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;
import it.unive.dais.po1.carte.francese.MazzoFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscola;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscolaNaive;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;
import it.unive.dais.po1.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.carte.trevigiane.ValueTrevigiano;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++)
            lista.add(Integer.valueOf(i));
        int val = lista.get(10);

        int int1 = 435353;
        double double1 = int1;
        float float1 = 432.4F;
        byte b = 123;
        long long1 = int1;
        double1 = float1;
        float1 = (float) double1;
        int1 = (int) float1;
        int1 = (int) long1;

        Integer wint1 = Integer.valueOf(4325);
        Double wdouble1 = wint1.doubleValue();
        //Long wlong1 = wint1;


        CardSet<CartaTrevigiana> c = new CardSet<>();
        c.push(new CartaTrevigiana(SemeTrevigiano.Bastoni, ValueTrevigiano.Asso));
        Persona pietro = new Persona("Pietro", "Ferrara", "FRRPTR...");
        System.out.println(pietro);
        String nome = pietro.name();
        Persona pietro2 = new Persona("Pietro", "Ferrara", "FRRPTR...");
        boolean equals = pietro.equals(pietro2);


    }

    private static void playManyMatches2Players() {
        double vinteg1 = 0, vinteg2 = 0;
        GiocatoreDiBriscola g1 = null, g2 = null;
        if(new Random().nextBoolean())
            g1 = new GiocatoreBirscolaIntelligente("Pietro");
        //else g1 = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Pietro");
        //if(new Random().nextBoolean())
        //    g2=new GiocatoreDiBriscolaIntelligente("Alessio");
        //else g2=new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Alessio");

        for(int i = 0; i < 1000; i++) {
            CartaTrevigiana.reset();

            BriscolaADue b = new BriscolaADue(g1, g2);
            GiocatoreDiBriscola g = b.giocaPartita();
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
/*
    private static void playManyMatches4Players() {
        double vintesquadra1 = 0, vintesquadra2 = 0;
        GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g1, g2, g3, g4;
        if(new Random().nextBoolean())
            g1 = new GiocatoreBirscolaIntelligente("Pietro");
        else g1 = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Pietro");
        if(new Random().nextBoolean())
            g2=new GiocatoreBirscolaIntelligente("Alessio");
        else g2=new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Alessio");
        if(new Random().nextBoolean())
            g3 = new GiocatoreBirscolaIntelligente("Gianluca");
        else g3 = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Gianluca");
        if(new Random().nextBoolean())
            g4=new GiocatoreBirscolaIntelligente("Mario");
        else g4=new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Mario");

        for(int i = 0; i < 1000; i++) {
            CartaTrevigiana.reset();

            BriscolaAQuattro b = new BriscolaAQuattro(g1, g2, g3, g4);
            GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g = b.giocaPartita();
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
*/

}
