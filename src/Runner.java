public class Runner {

    public static void main(String[] args) {;
        for(int i =1; i<=4; i++) {
            for(int j =1; j<=10; j++) {
                Card c = new Card();
                c.seme = new Seme();
                c.seme.value = i;
                c.valore = j;
                c.printCard();
            }
        }
    }

}
