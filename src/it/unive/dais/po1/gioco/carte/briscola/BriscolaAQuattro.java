package it.unive.dais.po1.gioco.carte.briscola;

import it.unive.dais.po1.gioco.carte.Card;
import it.unive.dais.po1.gioco.carte.CartePrese;
import it.unive.dais.po1.gioco.carte.briscola.giocatori.Giocatore;

public class BriscolaAQuattro extends Briscola {
    private Giocatore g1, g2, g3, g4;

    public BriscolaAQuattro(Giocatore g1, Giocatore g2, Giocatore g3, Giocatore g4) {
        super();
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
    }

    public Giocatore giocaPartita() {
        TavoloQuattroGiocatori tavolo = new TavoloQuattroGiocatori(g1, g2, g3, g4);
        this.g1.receiveCard(mazzo.pop());
        this.g1.receiveCard(mazzo.pop());
        this.g1.receiveCard(mazzo.pop());
        this.g2.receiveCard(mazzo.pop());
        this.g2.receiveCard(mazzo.pop());
        this.g2.receiveCard(mazzo.pop());
        this.g3.receiveCard(mazzo.pop());
        this.g3.receiveCard(mazzo.pop());
        this.g3.receiveCard(mazzo.pop());
        this.g4.receiveCard(mazzo.pop());
        this.g4.receiveCard(mazzo.pop());
        this.g4.receiveCard(mazzo.pop());

        briscola = mazzo.pop();
        boolean mazzoIsEmpty = false;
        while (!mazzoIsEmpty) {
            Giocatore vincitore = giocaMano(tavolo);
            tavolo.get(0).receiveCard(mazzo.pop());
            tavolo.get(1).receiveCard(mazzo.pop());
            tavolo.get(2).receiveCard(mazzo.pop());
            Card next = mazzo.pop();
            if (next != null)
                tavolo.get(3).receiveCard(next);
            else {
                mazzoIsEmpty = true;
                tavolo.get(3).receiveCard(briscola);
            }
        }
        for (int i = 0; i < 3; i++)
            giocaMano(tavolo);
        int punteggiog1 = g1.contaPunti() + g3.contaPunti();
        int punteggiog2 = g2.contaPunti() + g4.contaPunti();
        if (punteggiog1 > punteggiog2) {
            System.out.println("Ha vinto la squadra 1");
            return g1;
        } else if (punteggiog1 < punteggiog2) {
            System.out.println("Ha vinto la squadra 2");
            return g2;
        } else {
            System.out.println("Patta");
            return null;
        }
    }

    private Giocatore giocaMano(TavoloQuattroGiocatori tavolo) {
        Giocatore primoDiMano = tavolo.get(0);
        Giocatore secondoDiMano = tavolo.get(1);
        Giocatore terzoDiMano = tavolo.get(2);
        Giocatore quartoDiMano = tavolo.get(3);

        CartePrese c = new CartePrese();
        Card prima = primoDiMano.scarta(c, this);
        c.storeCard(prima);
        Card seconda = secondoDiMano.scarta(c, this);
        c.storeCard(seconda);
        Card terza = terzoDiMano.scarta(c, this);
        c.storeCard(terza);
        Card quarta = quartoDiMano.scarta(c, this);
        c.storeCard(quarta);
        if (maggiore(prima, seconda) && maggiore(prima, quarta)) {
            giveAllCards(primoDiMano, c);
            if (vince(terza, prima))
                tavolo.setPrimoDiMano(2);
            //else
            //    tavolo.setPrimoDiMano(0);
            return primoDiMano;
        } else if (vince(seconda, prima) && maggiore(seconda, terza)) {
            giveAllCards(secondoDiMano, c);
            tavolo.setPrimoDiMano(1);
            return secondoDiMano;
        } else if (((vince(terza, seconda) && vince(seconda, prima)) || vince(terza, prima))
                && maggiore(terza, quarta)) {
            giveAllCards(terzoDiMano, c);
            tavolo.setPrimoDiMano(2);
            return terzoDiMano;
        } else {
            giveAllCards(quartoDiMano, c);
            tavolo.setPrimoDiMano(3);
            return quartoDiMano;
        }
    }

    private void giveAllCards(Giocatore giocatore, CartePrese c) {
        while(c.getCarteRimanenti()>0) {
            giocatore.storeCard(c.pop());
        }
    }

}
