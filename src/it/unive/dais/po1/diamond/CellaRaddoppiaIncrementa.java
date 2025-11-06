package it.unive.dais.po1.diamond;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CellaRaddoppiaIncrementa
        implements CellaRaddoppia, CellaIncrementa {

    private int value;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void step() {
        CellaRaddoppia.super.step();
        CellaIncrementa.super.step();
    }
}
