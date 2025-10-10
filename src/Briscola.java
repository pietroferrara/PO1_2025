public class Briscola {



    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    static boolean vince(Card prima, Card seconda, Seme briscola) {
        if(prima.seme== briscola) {
            if(seconda.seme!= briscola) {
                return true;
            }
            else {
                return prima.figura.maggiore(seconda.figura);
            }
        }
        else if(seconda.seme== briscola) {
            return false;
        }
        if(seconda.seme==prima.seme)
            return prima.figura.maggiore(seconda.figura);
        else
            return true;
    }
}
