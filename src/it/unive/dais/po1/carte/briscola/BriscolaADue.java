package it.unive.dais.po1.carte.briscola;

import it.unive.dais.po1.DesignByContract;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscola;
import it.unive.dais.po1.carte.gioco.GiocoDiCarteException;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;

import java.util.Random;

/**
 * The Briscola class represents the card game of Briscola.
 * It handles the game logic, turns, card management, and points calculation
 * for two players.
 * The game is played with a deck of 40 cards and includes briscola
 * identification and rules for determining winning hands and rounds.
 *
 * @author Pietro Ferrara
 * @see GiocatoreDiBriscolaNaive
 * @since 1.0
 */
public class BriscolaADue extends Briscola {

    //invariant mazzo.getCarteRimanenti() + g1.getCarte() + g2.getCarte() + (briscola != null ? 1 : 0) == 40
    private GiocatoreDiBriscola g1, g2;

    //invariant primoDiMano == 1 || primoDiMano == 2
    private int primoDiMano;

    /**
     * Constructs a Briscola game instance.
     *
     * @param g1 the first player in the game
     * @param g2 the second player in the game
     */
    public BriscolaADue(GiocatoreDiBriscola g1, GiocatoreDiBriscola g2) {
        super();
        this.g1 = g1;
        this.g2 = g2;

        //se g1 e' intelligente, allora fai diventare anche g2 intelligante
        //if(this.g1 instanceof GiocatoreIntelligente && !(this.g2 instanceof GiocatoreIntelligente))//richiede un controllo sul tipo **dinamico** dell'espressione g1
        //    this.g2 = new GiocatoreIntelligente(this.g2.getName());

        //if(this.g2 instanceof GiocatoreIntelligente && !(this.g1 instanceof GiocatoreIntelligente))
        //    this.g1 = new GiocatoreIntelligente(this.g1.getName());

        //dai 3 carte al giocatore 1
        this.g1.receiveCard(mazzo.pop());
        this.g1.receiveCard(mazzo.pop());
        this.g1.receiveCard(mazzo.pop());
        //dai 3 carte al giocatore 2
        this.g2.receiveCard(mazzo.pop());
        this.g2.receiveCard(mazzo.pop());
        this.g2.receiveCard(mazzo.pop());
        briscola = mazzo.pop();
        this.primoDiMano = new Random().nextBoolean()? 1: -1;
    }

    private void prendiCarteDaMazzo() throws BriscolaException {
        //precondition primoDiMano==1 || primoDiMano==2
        if (this.primoDiMano == 1) {
            g1.receiveCard(mazzo.pop());
            g2.receiveCard(mazzo.pop());
        } else if (this.primoDiMano == 2) {
            g2.receiveCard(mazzo.pop());
            g1.receiveCard(mazzo.pop());
        } else {//Unreachable
            throw new BriscolaException("Il valore del primo di mano durante una partita di briscola e' invalido: "+this.primoDiMano, null);
        }
    }

    private void giocaSingolaMano() throws BriscolaException {
        CartaTrevigiana c1 = null, c2 = null;
        switch (primoDiMano) {
            case 1:
                c1 = g1.scarta(null, this);
                c2 = g2.scarta(c1, this);
                if (this.maggiore(c1, c2)) {
                    g1.storeCard(c1);
                    g1.storeCard(c2);
                    this.primoDiMano = 1;
                } else {
                    g2.storeCard(c1);
                    g2.storeCard(c2);
                    this.primoDiMano = 2;
                }
                break;
            case 2:
                c1 = g2.scarta(null, this);
                c2 = g1.scarta(c1, this);
                if (this.maggiore(c1, c2)) {
                    g2.storeCard(c1);
                    g2.storeCard(c2);
                    this.primoDiMano = 2;
                } else {
                    g1.storeCard(c1);
                    g1.storeCard(c2);
                    this.primoDiMano = 1;
                }
                break;
            default:
                throw new BriscolaException("Primo di mano sbagliato: "+this.primoDiMano, null);
        }
    }

    /**
     * Plays an entire game of Briscola between two players and determines the winner.
     * At the end, the player with the higher score is returned as the winner.
     * If the scores are tied, the method returns null.
     *
     * @return the winner of the game as a {@code Giocatore} object, or {@code null} if there is a tie.
     */
    public GiocatoreDiBriscola giocaPartita() throws BriscolaException {
            //preconditions g1!=null, g2!=null, g1!=g2
            assert g1 != null || g2 != null || g1 != g2;
            while (mazzo.getCarteRimanenti() > 1) {
                giocaSingolaMano();
                prendiCarteDaMazzo();
            }
            giocaSingolaMano();
            switch (primoDiMano) {
                case 1:
                    g1.receiveCard(mazzo.pop());
                    g2.receiveCard(briscola);
                    break;
                case 2:
                    g2.receiveCard(mazzo.pop());
                    g1.receiveCard(briscola);
                    break;
                default:
                    throw new BriscolaException("Primo di mano errato: " + this.primoDiMano, null);
            }
            giocaSingolaMano();
            giocaSingolaMano();
            giocaSingolaMano();
            int g1punti = g1.contaPunti(), g2punti = g2.contaPunti();
            GiocatoreDiBriscola res;
            if (g1punti > g2punti) {
                res = g1;
            } else if (g2punti > g1punti)
                res = g2;
            else res = null;
            //postcondition return==g1 || return==g2 || return==null
            //gia' un'astrazione ad alto livello
            //DesignByContract.checkPostcondition(res==g1 || res==g2 || res==null);
            DesignByContract.checkPostcondition(
                    g1punti > g2punti ? res == g1 :
                            g1punti < g2punti ? res == g2 :
                                    res == null);

            return res;
    }


}
