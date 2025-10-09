public class Briscola {



    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    static boolean vince(Card prima, Card seconda, Seme briscola) {
        if(prima.seme.value== briscola.value) {
            if(seconda.seme.value!= briscola.value) {
                return true;
            }
            else {
                return prima.figura.maggiore(seconda.figura);
            }
        }
        else if(seconda.seme.value== briscola.value) {
            return false;
        }
        if(seconda.seme.value==prima.seme.value)
            return prima.figura.maggiore(seconda.figura);
        else
            return true;
    }
}
