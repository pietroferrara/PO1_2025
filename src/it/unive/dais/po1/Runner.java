package it.unive.dais.po1;

import it.unive.dais.po1.gioco.carte.briscola.Briscola;
import it.unive.dais.po1.gioco.carte.briscola.BriscolaIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.intelligenti.GiocatoreIntelligente;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.GiocatoreNaive;
import it.unive.dais.po1.quadrilateri.Quadrato;
import it.unive.dais.po1.quadrilateri.Rettangolo;
import it.unive.dais.po1.quadrilateri.Trapezio;

public class Runner {

    public static void main(String[] args) {
        //partitaNaive();
        Quadrato c = new Quadrato(2);
        System.out.println(c.getArea());
        Rettangolo r = new Rettangolo(2, 3);
        System.out.println(r.getArea());
        Trapezio t = new Trapezio(2, 3, 4, 5, 1);
        System.out.println(t.getArea());
    }

    private static void partitaIntelligente() {
        GiocatoreIntelligente g1 = new GiocatoreIntelligente("Pietro"), g2=new GiocatoreIntelligente("Alessio");
        BriscolaIntelligente b = new BriscolaIntelligente(g1, g2);
        GiocatoreIntelligente g = b.giocaPartita();
        if(g==null || g == g1 || g==g2) // g \in {null, g1, g2}
            System.out.println("OK");
        else System.err.println("Valore non concesso "+g.getName());
    }
    private static void partitaNaive() {
        GiocatoreNaive g1 = new GiocatoreNaive("Pietro"), g2=new GiocatoreNaive("Alessio");
        Briscola b = new Briscola(g1, g2);
        GiocatoreNaive g = b.giocaPartita();
        if(g==null || g == g1 || g==g2) // g \in {null, g1, g2}
            System.out.println("OK");
        else System.err.println("Valore non concesso "+g.getName());
    }

}
