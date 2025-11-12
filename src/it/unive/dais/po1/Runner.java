package it.unive.dais.po1;

import it.unive.dais.po1.gioco.carte.*;
import it.unive.dais.po1.gioco.carte.briscola.Briscola;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaADue;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaAQuattro;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.intelligenti.GiocatoreIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.GiocatoreNaive;

import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Briscola[] briscole = new Briscola[10];
        Giocatore g1 = new GiocatoreNaive("a"), g2 =  new GiocatoreNaive("a"), g3 =  new GiocatoreNaive("a"), g4 =  new GiocatoreNaive("a");
        BriscolaADue bDue = new BriscolaADue(g1, g2);
        BriscolaAQuattro bQuattro = new BriscolaAQuattro(g1, g2, g3, g4);
        briscole[0] = bDue;
        briscole[1] = bQuattro;

        BriscolaADue[] bDueArray = new BriscolaADue[10];
        bDueArray[0] = new BriscolaADue( new GiocatoreNaive("a"),  new GiocatoreNaive("a"));
        bDueArray[1] = new BriscolaADue( new GiocatoreNaive("a"),  new GiocatoreNaive("a"));
        briscole = bDueArray;
        Briscola b = briscole[0];
        briscole[0] = new BriscolaAQuattro( new GiocatoreNaive("a"),  new GiocatoreNaive("a"),  new GiocatoreNaive("a"),  new GiocatoreNaive("a"));
        BriscolaADue b2 = bDueArray[0];



        /*
        Briscola b = briscole[0];

        Stack<Briscola> stack = new Stack<>();
        stack.push(bDue);
        stack.push(bQuattro);
        b = stack.pop();

        Stack<BriscolaADue> stackDue = new Stack<>();
        stackDue.push(bDue);
        //stackDue.push(bQuattro);
        bDue = stackDue.pop();

        stack = stackDue;
        stack.pop(); //il tipo di ritorno e' BriscolaADue, sottotipo di Briscola, OK (covarianza)
        stack.push(bDue);
        stack.push(bQuattro);//sto mettendo una BriscolaAQuattro in un stack di BriscolaADue, NO (contravarianza)


        stackDue = stack;
        stackDue.push(bDue);
        stackDue.push(bQuattro);//NO
        stack.push(bQuattro);
        stackDue.pop();//Potrei avere una BriscolaAQuattro e non a due!


         */


        /*Stack<String> stack = new Stack<String>();
        stack.push("uno");
        stack.push("due");
        String a = "tre";
        stack.push(a);

        for(int i = 0; i<3; i++) {
            a = stack.pop();
            System.out.println(a);
        }*/

        //playManyMatches4Players();
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
