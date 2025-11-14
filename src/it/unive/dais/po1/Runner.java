package it.unive.dais.po1;

import it.unive.dais.po1.carte.*;
import it.unive.dais.po1.carte.briscola.BriscolaADue;
import it.unive.dais.po1.carte.briscola.BriscolaAQuattro;
import it.unive.dais.po1.carte.francese.CartaFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;
import it.unive.dais.po1.carte.francese.MazzoFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscolaNaive;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;
import it.unive.dais.po1.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.carte.trevigiane.ValueTrevigiano;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        String a = "Pietro", b = "Pietro";
        GiocatoreDiBriscolaNaive pietro = new GiocatoreDiBriscolaNaive("Pietro"),
        pietro2 = new GiocatoreDiBriscolaNaive("Pietro");
        Object o = "afdsa";
        o = pietro;
        o = new Stack<>();
        o = new String[10];
        if(pietro==pietro2)
            System.out.println("Sono uguali");
        else System.out.println("Sono diversi");

        System.out.println(pietro);

        CartaTrevigiana c1 = new CartaTrevigiana(SemeTrevigiano.Bastoni, ValueTrevigiano.Asso),
                c2 = new CartaTrevigiana(SemeTrevigiano.Bastoni, ValueTrevigiano.Asso);
        boolean equals = c1.equals(c2);

        Set<CartaTrevigiana> set = new HashSet<>();
        set.add(c1);
        set.add(c2);


        MazzoTrevigiano m = new MazzoTrevigiano();
        System.out.println(m);

    }

    private static void playManyMatches2Players() {
        double vinteg1 = 0, vinteg2 = 0;
        GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g1 = null, g2 = null;
        //if(new Random().nextBoolean())
        //    g1 = new GiocatoreBirscolaIntelligente("Pietro");
        //else g1 = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Pietro");
        //if(new Random().nextBoolean())
        //    g2=new GiocatoreDiBriscolaIntelligente("Alessio");
        //else g2=new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Alessio");

        for(int i = 0; i < 1000; i++) {
            CartaTrevigiana.reset();

            BriscolaADue b = new BriscolaADue(g1, g2);
            GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g = b.giocaPartita();
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
