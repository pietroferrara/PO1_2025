package it.unive.dais.po1.test;

import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;
import it.unive.dais.po1.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.carte.trevigiane.ValueTrevigiano;
import org.junit.Test;

public class TestCard {

    @Test
    public void test1() {
        SemeTrevigiano s = SemeTrevigiano.Spade;
        ValueTrevigiano v = ValueTrevigiano.Tre;
        CartaTrevigiana c = new CartaTrevigiana(s, v);
        assert c.getSeme().equals(s);
        assert c.getValore().equals(v);
    }


    @Test
    public void test2() {
        SemeTrevigiano s = SemeTrevigiano.Spade;
        ValueTrevigiano v = ValueTrevigiano.Tre;
        CartaTrevigiana c = new CartaTrevigiana(s, v);
        assert c.getSeme().equals(SemeTrevigiano.Bastoni);
        assert c.getValore().equals(v);
    }

    @Test
    public void test3() {
        this.test3();
    }
}
