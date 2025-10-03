public class Seme {
    //1 spade, 2 denari, 3 bastoni, 4 coppe
    int value;
    void print() {
        switch (value) {
            case 1:
                System.out.println("Spade");
                break;
            case 2:
                System.out.println("Denari");
                break;
            case 3:
                System.out.println("Bastoni");
                break;
            case 4:
                System.out.println("Coppe");
                break;
            default:
                System.out.println("Errore");
                break;
        }
    }

}
