package it.unive.dais.po1.gioco.carte.briscola;

import it.unive.dais.po1.gioco.Mazzo;
import it.unive.dais.po1.gioco.carte.Seme;
import it.unive.dais.po1.gioco.carte.Value;
import it.unive.dais.po1.gioco.carte.Card;

public class Briscola {

    private Card briscola;
    private Giocatore g1, g2;
    private Mazzo mazzo;
    private int primoDiMano;

    public Briscola(Giocatore g1, Giocatore g2) {
        mazzo = new Mazzo();
        mazzo.riempiMazzo();
        mazzo.mischia();
        this.g1 = g1;
        this.g2 = g2;
        //dai 3 carte al giocatore 1
        g1.receiveCard(mazzo.pop());
        g1.receiveCard(mazzo.pop());
        g1.receiveCard(mazzo.pop());
        //dai 3 carte al giocatore 2
        g2.receiveCard(mazzo.pop());
        g2.receiveCard(mazzo.pop());
        g2.receiveCard(mazzo.pop());
        briscola = mazzo.pop();
        this.primoDiMano = 1;
    }

    private void prendiCarteDaMazzo() {
        if(this.primoDiMano==1) {
            g1.receiveCard(mazzo.pop());
            g2.receiveCard(mazzo.pop());
        }
        else if(this.primoDiMano==2) {
            g2.receiveCard(mazzo.pop());
            g1.receiveCard(mazzo.pop());
        }
        else {
            System.exit(-1);
        }
    }

    private void giocaSingolaMano() {
        Card c1 = null, c2 = null;
        switch(primoDiMano) {
            case 1:
                c1= g1.scarta();
                c2= g2.scarta();
                if(this.vince(c1, c2)) {
                    g1.storeCard(c1);
                    g1.storeCard(c2);
                    this.primoDiMano=1;
                }
                else {
                    g2.storeCard(c1);
                    g2.storeCard(c2);
                    this.primoDiMano=2;
                }
                break;
            case 2:
                c1= g2.scarta();
                c2= g1.scarta();
                if(this.vince(c1, c2)) {
                    g2.storeCard(c1);
                    g2.storeCard(c2);
                    this.primoDiMano=2;
                }
                else {
                    g1.storeCard(c1);
                    g1.storeCard(c2);
                    this.primoDiMano=1;
                }
                break;
            default: System.exit(-1);
        }
    }

    //Ritorna il giocatore che ha vinto la partita
    public Giocatore giocaPartita() {
        while(mazzo.getCarteRimanenti()>1) {
            giocaSingolaMano();
            prendiCarteDaMazzo();
        }
        giocaSingolaMano();
        switch(primoDiMano) {
            case 1:
                g1.receiveCard(mazzo.pop());
                g2.receiveCard(briscola);
                break;
            case 2:
                g2.receiveCard(mazzo.pop());
                g1.receiveCard(briscola);
                break;
            default: System.exit(-1);
        }
        giocaSingolaMano();
        giocaSingolaMano();
        giocaSingolaMano();
        int g1punti = g1.contaPunti(), g2punti = g2.contaPunti();
        if(g1punti>g2punti) {
            return g1;
        }
        else if(g2punti>g1punti)
            return g2;
        else return null;
    }



    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    private boolean vince(Card prima, Card seconda) {
        if(prima.getSeme()== briscola.getSeme()) {
            if(seconda.getSeme()!= briscola.getSeme()) {
                return true;
            }
            else {
                return prima.getFigura().maggiore(seconda.getFigura());
            }
        }
        else if(seconda.getSeme()== briscola.getSeme()) {
            return false;
        }
        if(seconda.getSeme()==prima.getSeme())
            return prima.getFigura().maggiore(seconda.getFigura());
        else
            return true;
    }
}
