package it.unive.dais.po1.carte;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class Risultati {
    @XmlElement
    private String giocatore1, giocatore2;
    @XmlAttribute
    private double punteggio1, punteggio2;

    private Risultati() {
        System.out.println("Risultati vuoto");

    }

    public Risultati(String giocatore1, String giocatore2) {
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.punteggio1 = 0;
        this.punteggio2 = 0;
    }

    public void winGiocatore1() {
        this.punteggio1++;
    }
    public void winGiocatore2() {
        this.punteggio2++;
    }
    public void draw() {
        this.punteggio1=this.punteggio1+0.5;
        this.punteggio2=this.punteggio2+0.5;

    }

    public void print() {
        System.out.println(this.giocatore1 + " " + this.punteggio1 + " " + this.giocatore2 + " " + this.punteggio2);
    }

    @Points
    public double getPunteggio1() {
        return punteggio1;
    }

    @Points(type="1 punto per vittoria")
    public double getPunteggio2() {
        return punteggio2;
    }
}