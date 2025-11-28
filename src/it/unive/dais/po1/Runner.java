package it.unive.dais.po1;

import it.unive.dais.po1.carte.*;
import it.unive.dais.po1.carte.briscola.BriscolaADue;
import it.unive.dais.po1.carte.briscola.BriscolaAQuattro;
import it.unive.dais.po1.carte.briscola.BriscolaException;
import it.unive.dais.po1.carte.francese.CartaFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreBirscolaIntelligente;
import it.unive.dais.po1.carte.francese.MazzoFrancese;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscola;
import it.unive.dais.po1.carte.giocatori.briscola.GiocatoreDiBriscolaNaive;
import it.unive.dais.po1.carte.gioco.GiocoDiCarteException;
import it.unive.dais.po1.carte.trevigiane.CartaTrevigiana;
import it.unive.dais.po1.carte.trevigiane.MazzoTrevigiano;
import it.unive.dais.po1.carte.trevigiane.SemeTrevigiano;
import it.unive.dais.po1.carte.trevigiane.ValueTrevigiano;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class Runner {

    public static void main(String[] args) throws GiocoDiCarteException, JAXBException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Risultati r = JAXB.unmarshal(new File("./risultati.xml"), Risultati.class);
        Class cls = r.getClass();
        System.out.println("----------- Construttori");
        printDeclaredConstructors(cls);
        System.out.println("----------- Metodi");
        printDeclaredMethods(cls);
        System.out.println("----------- Campi");
        printDeclaredFields(cls);

        /*Risultati old_risultati = JAXB.unmarshal(new File("./risultati.xml"), Risultati.class);

        Risultati r = playManyMatches2Players();
        JAXBContext jc = JAXBContext.newInstance(Risultati.class);
        Marshaller m = jc.createMarshaller();
        m.marshal(r, new File("./risultati.xml"));*/
    }

    private static void inspectConstructor(Constructor<?> c) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(c.getParameterCount()+" parametri");
        if(c.getParameterCount()==0) {
            c.setAccessible(true);
            Risultati t = (Risultati) c.newInstance();
            for(Field f : t.getClass().getDeclaredFields()) {
                Type type = f.getType();
                if(type.getTypeName().equals("double")) {
                    f.setAccessible(true);
                    f.set(t, -10.0);
                    double d = ((Double) f.get(t)).doubleValue();
                    System.out.println(d);
                }
                if(type.getTypeName().equals("java.lang.String")) {
                    f.setAccessible(true);
                    f.set(t, "pippo");
                }
            }
            for(Method m : t.getClass().getDeclaredMethods()) {
                m.invoke(t);
            }
            System.out.println("Ho creato un nuovo oggetto di tipo Risultati invocando il costruttore privato");
        }
    }

    private static void printConstructors(Class cls) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for(Constructor<?> c : cls.getConstructors()) {
            System.out.println(c);
            inspectConstructor(c);
        }
    }
    private static void printMethods(Class cls) {
        for(Method c : cls.getMethods()) {
            System.out.println(c);
        }
    }
    private static void printFields(Class cls) {
        for(Field c : cls.getFields()) {
            System.out.println(c);
        }
    }


    private static void printDeclaredConstructors(Class cls) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for(Constructor<?> c : cls.getDeclaredConstructors()) {
            System.out.println(c);
            inspectConstructor(c);
        }
    }
    private static void printDeclaredMethods(Class cls) {
        for(Method c : cls.getDeclaredMethods()) {
            System.out.println(c);
            Annotation[] annotations = c.getDeclaredAnnotations();
            System.out.println(annotations.length);
            if(c.isAnnotationPresent(Points.class)) {
                Points p = c.getAnnotation(Points.class);
                System.out.println(p.type());
            }
        }
    }
    private static void printDeclaredFields(Class cls) {
        for(Field c : cls.getDeclaredFields()) {
            System.out.println(c);
        }
    }
    private static Risultati playManyMatches2Players() throws GiocoDiCarteException {
        double vinteg1 = 0, vinteg2 = 0;
        GiocatoreDiBriscola g1 = null, g2 = null;
        g1 = new GiocatoreBirscolaIntelligente("Pietro");
        g2=new GiocatoreBirscolaIntelligente("Alessio");
        Risultati risultati = new Risultati(g1.getName(), g2.getName());

        try {
            for (int i = 0; i < 1000; i++) {
                g1 = new GiocatoreBirscolaIntelligente("Pietro");
                g2 = new GiocatoreBirscolaIntelligente("Alessio");

                BriscolaADue b = new BriscolaADue(g1, g2);

                try {
                    GiocatoreDiBriscola g = b.giocaPartita();
                    if (g == null) {
                        risultati.draw();
                        vinteg1 = vinteg1 + 0.5;
                        vinteg2 = vinteg2 + 0.5;
                    } else if (g.getName().equals("Pietro")) {
                        vinteg1++;
                        risultati.winGiocatore1();
                    }
                    else if (g.getName().equals("Alessio")) {
                        vinteg2++;
                        risultati.winGiocatore2();
                    }
                    if (g == null) System.out.println("Partita patta");
                    else System.out.println("Ha vinto " + g.getName());
                } catch (BriscolaException e) {
                    System.err.println("Errore durante la partita, partita invalida");
                } finally {
                    System.out.println("Reset delle carte");
                    CartaTrevigiana.reset();
                }

            }
        }
        catch(Throwable e) {
            throw new BriscolaException("Errore durante la partita", e);
        }
        System.out.println("Vinte g1: " + vinteg1 + ", vinte g2: " + vinteg2);
        return risultati;
    }
/*
    private static void playManyMatches4Players() {
        double vintesquadra1 = 0, vintesquadra2 = 0;
        GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g1, g2, g3, g4;
        if(new Random().nextBoolean())
            g1 = new GiocatoreBirscolaIntelligente("Pietro");
        else g1 = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Pietro");
        if(new Random().nextBoolean())
            g2=new GiocatoreBirscolaIntelligente("Alessio");
        else g2=new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Alessio");
        if(new Random().nextBoolean())
            g3 = new GiocatoreBirscolaIntelligente("Gianluca");
        else g3 = new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Gianluca");
        if(new Random().nextBoolean())
            g4=new GiocatoreBirscolaIntelligente("Mario");
        else g4=new GiocatoreBirscolaIntelligente.GiocatoreDiBriscolaNaive("Mario");

        for(int i = 0; i < 1000; i++) {
            CartaTrevigiana.reset();

            BriscolaAQuattro b = new BriscolaAQuattro(g1, g2, g3, g4);
            GiocatoreBirscolaIntelligente.GiocatoreDiBriscola g = b.giocaPartita();
            if(g==null) {
                vintesquadra1 = vintesquadra1 + 0.5;
                vintesquadra2 =vintesquadra2  + 0.5;
                System.out.println("Partita patta");
            }
            else if(g.getName().equals("Pietro") || g.getName().equals("Gianluca")) vintesquadra1++;
            else if(g.getName().equals("Alessio") || g.getName().equals("Mario")) vintesquadra2++;

        }

        System.out.println("Vinte squadra 1: " + vintesquadra1 + ", vinte squadra 2: " + vintesquadra2);
    }
*/

}
