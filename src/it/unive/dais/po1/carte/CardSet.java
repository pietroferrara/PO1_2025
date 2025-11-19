package it.unive.dais.po1.carte;

import java.util.SortedSet;
import java.util.TreeSet;

public class CardSet<T extends Carta> {
    protected SortedSet<T> set;
    protected int max_size = 0;
    protected CardSet(int size) {
        this.set = new TreeSet<T>();
        this.max_size = size;
    }
    public CardSet() {
        this(Integer.MAX_VALUE);
    }
    public T pop() {
        return set.removeFirst();
    }
    public void push(T c) {
        set.add(c);
    }
    protected T peek() {
        return set.getFirst();
    }
    protected int nonEmptySlots() {
        int values = 0;
        for(T c : this.set)
            if(c!=null)
                values++;
        return values;
    }

    protected int size() {
        return this.max_size;
    }
    protected int getEmptySlots() {
        return max_size-this.nonEmptySlots();
    }
}
