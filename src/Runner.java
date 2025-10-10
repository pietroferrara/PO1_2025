public class Runner {

    public static void main(String[] args) {;
        Mazzo m = new Mazzo();
        m.mischia();


        Card c1 = m.get(0);
        Card c2 = m.get(1);
        c1.seme = Seme.Denari;

        Seme briscola = m.get(2).seme;;
        c1.print();
        c2.print();
        System.out.println("Briscola: "+briscola);
        System.out.println(Briscola.vince(c1, c2,briscola));

        System.out.println("Ho costruito "+c1.carte_costruite+" carte");

        IntWrapper w1 = new IntWrapper();
        w1.value=10;
        IntWrapper w2 = w1;
        w2.value=20;
        int value1 = 10;
        int value2 = value1;
        value2 = 20;
    }

}
