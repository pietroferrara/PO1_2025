package it.unive.dais.po1;

import it.unive.dais.po1.B.B_other;

public class A {
    public int pblc;
    private int prv;
    int dflt;

    void foo(A a, B_same b, B_other b1) {
        int a1 = this.dflt;
        a1 =this.pblc;
        a1 =this.prv;
        a1 =a.pblc;
        a1 =a.dflt;
        a1 =a.prv;
        a1 =b.pblc;
        a1 =b.dflt;
        //a1 = b.prv;
        a1 =b1.pblc;
        //a1 =b1.dflt;
        //a1 = b1.prv;
    }
}
