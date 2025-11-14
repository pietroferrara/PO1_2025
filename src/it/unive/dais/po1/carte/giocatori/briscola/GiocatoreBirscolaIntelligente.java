package it.unive.dais.po1.carte.giocatori.briscola;

import it.unive.dais.po1.carte.CarteInMano;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;
import it.unive.dais.po1.carte.CarteCumulo;
import it.unive.dais.po1.carte.briscola.BriscolaADue;
import it.unive.dais.po1.carte.briscola.BriscolaAQuattro;

/**
 * @author Pietro Ferrara
 * @since 1.0
 */
public class GiocatoreBirscolaIntelligente extends GiocatoreDiBriscola {

    /**
     * Constructs a Giocatore (player) instance with the specified name.
     *
     * @param name the name of the player
     */
    public GiocatoreBirscolaIntelligente(String name) {
        super(name);
    }

    /**
     * Vede la carta e' a terra (se ce ne e' una),
     * e scarta una carta piu' "forte"
     */
    public final CartaTrevigiana scarta(CartaTrevigiana cartaATerra, BriscolaADue briscola) {
        CartaTrevigiana c1 = carteInMano.viewCard(1),
            c2=carteInMano.viewCard(2),
            c3 = carteInMano.viewCard(3);
        if(cartaATerra==null) {
            CartaTrevigiana c = null;
            if (c1 != null) {
                c = c1;
                carteInMano.remove(c1);
            } else if (c2 != null) {
                c = c2;
                carteInMano.remove(c2);
            } else if (c3 != null) {
                c = c3;
                carteInMano.remove(c3);
            } else System.exit(-1);
            return c;
        }
        else {
            CartaTrevigiana c = null;
            //Se c1 vince su cartaATerra torna c1
            //Altrimenti prova c2, e poi c3
            if(c1!=null && ! briscola.vince(cartaATerra, c1)) {
                c = c1;
                carteInMano.remove(c1);
            }
            else if(c2!=null && ! briscola.vince(cartaATerra, c2)) {
                c = c2;
                carteInMano.remove(c2);
            }
            else {
                if(c3!=null) {
                    c = c3;
                    carteInMano.remove(c3);
                }
                else {
                    if(c1!=null) {
                        c = c1;
                        carteInMano.remove(c1);
                        return c;
                    }
                    else if(c2!=null) {
                        c = c2;
                        carteInMano.remove(c2);
                        return c;
                    }
                    else System.exit(-1);
                }
            }
            return c;
        }
    }


    public CartaTrevigiana scarta(CarteCumulo carteATerra, BriscolaAQuattro briscola) {
        return carteInMano.pop();
    }

    public String getName() {
        return super.getName();
    }


}
