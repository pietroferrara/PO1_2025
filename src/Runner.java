public class Runner {

    public static void main(String[] args) {
        System.out.println("Hello world");
        int x = fattoriale(10);
        System.out.println(x);
    }

    static int fattoriale(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * fattoriale(i-1);
        }
    }

}
