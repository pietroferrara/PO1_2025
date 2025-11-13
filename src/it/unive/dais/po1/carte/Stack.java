package it.unive.dais.po1.carte;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    protected List<T> list;
    private int max_size = 0;
    protected Stack(int size) {
        this.list = new ArrayList<T>();
        this.max_size = size;
    }
    public Stack() {
        this(Integer.MAX_VALUE);
    }
    public T pop() {
        return list.remove(0);
    }
    public void push(T c) {
        //DesignByContract.checkPrecondition(max_size<list.size());
        for(int i = 0; i < list.size(); i++)
            if(list.get(i)==null) {
                list.set(i, c);
                return;
            }
        if(list.size() < max_size)
            list.add(c);
        else {
            System.err.println("Stack pieno");
            System.exit(-1);
        }
    }
    protected T peek() {
        return list.get(0);
    }
    protected int nonEmptySlots() {
        int values = 0;
        for(T c : this.list)
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
