package it.unive.dais.po1.gioco.carte;

abstract public class StackCarte {
    protected Card[] stack;
    protected int first_empty_slot;
    protected StackCarte(int size) {
        this.stack = new Card[size];
        first_empty_slot = 0;
    }
    protected Card pop() {
        return stack[--first_empty_slot];
    }
    protected void push(Card c) {
        stack[first_empty_slot++] = c;
    }
    protected Card peek() {
        return stack[first_empty_slot -1];
    }
    protected int size() {
        return stack.length;
    }
    protected int getEmptySlots() {
        return size()-getFirstEmptySlot();
    }
    protected int getFirstEmptySlot() {
        return first_empty_slot;
    }
}
