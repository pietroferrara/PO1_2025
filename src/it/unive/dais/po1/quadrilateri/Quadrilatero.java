package it.unive.dais.po1.quadrilateri;

public class Quadrilatero {
    private int lato1, lato2, lato3, lato4;
    private float area;

    public Quadrilatero(int lato1, int lato2, int lato3, int lato4, float area) {
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;
        this.lato4 = lato4;
        this.area = area;
    }

    public int getPerimetro() {
        return lato1 + lato2 + lato3 + lato4;
    }

    public float getArea() {
        return area;
    }
}
