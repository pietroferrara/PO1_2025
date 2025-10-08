public class Runner {

    public static void main(String[] args) {;
        Seme s = new Seme(0);
        s.print();

        for(int i =1; i<=4; i++) {
            for(int j =1; j<=10; j++) {
                Card c = new Card(new Seme(i), new Value(j));
                c.print();
            }
        }
        Card c1 = new Card(new Seme(1), new Value(1));
        Card c2 = new Card(new Seme(2), new Value(2));
        Seme briscola = new Seme(2);
        c1.print();
        c2.print();
        briscola.print();
        System.out.println(c1.vince(c2,briscola));

        System.out.println("Ho costruito "+c1.carte_costruite+" carte");
    }

}
