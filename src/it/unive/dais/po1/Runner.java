package it.unive.dais.po1;

import it.unive.dais.po1.carte.*;
import it.unive.dais.po1.carte.briscola.BriscolaADue;
import it.unive.dais.po1.carte.briscola.BriscolaAQuattro;
import it.unive.dais.po1.carte.briscola.BriscolaException;
import it.unive.dais.po1.carte.francese.CartaFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;
import it.unive.dais.po1.carte.francese.MazzoFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscola;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscolaNaive;
import it.unive.dais.po1.carte.gioco.GiocoDiCarteException;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;
import it.unive.dais.po1.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.carte.trevigiane.ValueTrevigiano;

import java.util.*;

public class Runner {

    public static void main(String[] args) throws GiocoDiCarteException {
        //playManyMatches2Players();
        //foo();
        try {
            ArrayList<MazzoTrevigiano> mazzi = new ArrayList<>();
            while (true)
                mazzi.add(new MazzoTrevigiano());
        }
        catch(OutOfMemoryError e) {
            System.err.println("Errore: mazzo troppo grande");
        }
        catch(StackOverflowError e) {
            System.err.println("Errore: mazzo troppo grande");
        }
        catch(NullPointerException e) {
            System.err.println("Errore: null pointer");
        }

    }

    private static void foo() {
        foo();
    }

    private static void playManyMatches2Players() throws GiocoDiCarteException {
        double vinteg1 = 0, vinteg2 = 0;
        GiocatoreDiBriscola g1 = null, g2 = null;
        g1 = new GiocatoreBirscolaIntelligente("Pietro");
        g2=new GiocatoreBirscolaIntelligente("Alessio");

        for(int i = 0; i < 1000; i++) {
            CartaTrevigiana.reset();
            g1 = new GiocatoreBirscolaIntelligente("Pietro");
            g2=new GiocatoreBirscolaIntelligente("Alessio");

            BriscolaADue b = new BriscolaADue(g1, g2);

            try {
                GiocatoreDiBriscola g = b.giocaPartita();
                if (g == null) {
                    vinteg1 = vinteg1 + 0.5;
                    vinteg2 = vinteg2 + 0.5;
                } else if (g.getName().equals("Pietro")) vinteg1++;
                else if (g.getName().equals("Alessio")) vinteg2++;
                if (g == null) System.out.println("Partita patta");
                else System.out.println("Ha vinto " + g.getName());
            }
            catch(BriscolaException e) {
                System.err.println("Errore durante la partita, partita invalida");
            }

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
