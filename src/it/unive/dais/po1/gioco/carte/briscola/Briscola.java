package it.unive.dais.po1.gioco.carte.briscola;

import it.unive.dais.po1.DesignByContract;
import it.unive.dais.po1.gioco.Mazzo;
import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.GiocatoreNaive;

/**
 * The Briscola class represents the card game of Briscola.
 * It handles the game logic, turns, card management, and points calculation
 * for two players.
 * The game is played with a deck of 40 cards and includes briscola
 * identification and rules for determining winning hands and rounds.
 *
 * @see GiocatoreNaive
 * @author Pietro Ferrara
 * @since 1.0
 */
public class Briscola {

    //invariant mazzo.getCarteRimanenti() + g1.getCarte() + g2.getCarte() + (briscola != null ? 1 : 0) == 40
    private Card briscola;
    private Giocatore g1, g2;
    private Mazzo mazzo;

    //invariant primoDiMano == 1 || primoDiMano == 2
    private int primoDiMano;

    /**
     * Constructs a Briscola game instance.
     *
     * @param g1 the first player in the game
     * @param g2 the second player in the game
     */
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
        //precondition primoDiMano==1 || primoDiMano==2
        if(this.primoDiMano==1) {
            g1.receiveCard(mazzo.pop());
            g2.receiveCard(mazzo.pop());
        }
        else if(this.primoDiMano==2) {
            g2.receiveCard(mazzo.pop());
            g1.receiveCard(mazzo.pop());
        }
        else {//Unreachable
            System.exit(-1);
        }
    }

    private void giocaSingolaMano() {
        Card c1 = null, c2 = null;
        switch(primoDiMano) {
            case 1:
                c1= g1.scarta(null, this);
                c2= g2.scarta(c1, this);
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
                c1= g2.scarta(null, this);
                c2= g1.scarta(c1, this);
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

    /**
     * Plays an entire game of Briscola between two players and determines the winner.
     * At the end, the player with the higher score is returned as the winner.
     * If the scores are tied, the method returns null.
     *
     * @return the winner of the game as a {@code Giocatore} object, or {@code null} if there is a tie.
     */
    public Giocatore giocaPartita() {
        //preconditions g1!=null, g2!=null, g1!=g2
        DesignByContract.checkPrecondition(g1!=null || g2!=null || g1!=g2);
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
        Giocatore res;
        if(g1punti>g2punti) {
            res=g1;
        }
        else if(g2punti>g1punti)
            res=g2;
        else res=null;
        //postcondition return==g1 || return==g2 || return==null
        //gia' un'astrazione ad alto livello
        //DesignByContract.checkPostcondition(res==g1 || res==g2 || res==null);
        DesignByContract.checkPostcondition(
                g1punti>g2punti ? res==g1 :
                g1punti<g2punti ? res==g2 :
                res==null);

        return res;
    }



    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    public boolean vince(Card prima, Card seconda) {
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
