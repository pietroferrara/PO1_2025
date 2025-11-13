package it.unive.dais.po1.carte.giocatori.briscola;

import it.unive.dais.po1.carte.CarteCumulo;
import it.unive.dais.po1.carte.CarteInMano;
import it.unive.dais.po1.carte.briscola.BriscolaADue;
import it.unive.dais.po1.carte.briscola.BriscolaAQuattro;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;

/**
 * @author Pietro Ferrara
 * @since 1.0
 */
    public class GiocatoreDiBriscolaNaive extends GiocatoreDiBriscola {

        public GiocatoreDiBriscolaNaive(String name) {
            //costruisci cio' che mi sta "sopra"
            super(name);//la prima istruzione invoca un costruttore della superclasse
        }
        public CartaTrevigiana scarta(CartaTrevigiana cartaATerra, BriscolaADue briscola) {
            return carteInMano.pop();
        }

        public CartaTrevigiana scarta(CarteCumulo carteATerra, BriscolaAQuattro briscola) {
            return carteInMano.pop();
        }

        public String getName() {
            return super.getName();
        }

    }
