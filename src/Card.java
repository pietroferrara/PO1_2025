public class Card {
    //1 asso, 2, 3, 4, 5, 6, 7, 8 fante, 9 cavallo, 10 re
    int valore;
    Seme seme;


    void printValore() {
        switch (valore) {
            case 1:
                System.out.println("Asso");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                System.out.println(valore);
                break;
            case 8:
                System.out.println("Fante");
                break;
            case 9:
                System.out.println("Cavallo");
                break;
            case 10:
                System.out.println("Re");
                break;
            default:
                System.out.println("Errore");

        }
    }

    void printCard() {
        System.out.println("Carta---------");
        printValore();
        printSeme();
        System.out.println("--------------");
    }


}
