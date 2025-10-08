public class Card {
    static int carte_costruite;
    Seme seme;
    Value figura;

    Card(Seme seme, Value valore) {
        this.seme = seme;
        this.figura = valore;
        Card.carte_costruite++;
    }

    void print() {
        System.out.println("Carta---------");
        seme.print();
        this.figura.print();
        System.out.println("--------------");
    }

    //restituisce true se la carta corrente vince sulla carta data
    // quando la briscola e' quella passata come parametro
    //assumiamo che la carta corrente sia stata giocata prima di quella data
    boolean vince(Card d, Seme briscola) {
        if(this.seme.value== briscola.value) {
            if(d.seme.value!= briscola.value) {
                return true;
            }
            else {
                return figura.maggiore(d.figura);
            }
        }
        else if(d.seme.value== briscola.value) {
            return false;
        }
        if(d.seme.value==seme.value)
            return figura.maggiore(d.figura);
        else
            return true;
    }
}
