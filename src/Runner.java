public class Runner {

    public static void main(String[] args) {;
        Seme s = new Seme(0);
        s.print();

        Mazzo m = new Mazzo();
        m.mischia();


        Card c1 = m.get(0);
        Card c2 = m.get(1);
        Seme briscola = m.get(2).seme;;
        c1.print();
        c2.print();
        System.out.println("Briscola: ");
        briscola.print();
        System.out.println(Briscola.vince(c1, c2,briscola));

        System.out.println("Ho costruito "+c1.carte_costruite+" carte");
    }

}
