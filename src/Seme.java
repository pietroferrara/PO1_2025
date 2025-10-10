enum Seme {
    Spade, Denari, Bastoni, Coppe;

    void print() {
        switch (this) {
            case Spade:
                System.out.println("Spade");
                break;
            case Denari:
                System.out.println("Denari");
                break;
            case Bastoni:
                System.out.println("Bastoni");
                break;
            case Coppe:
                System.out.println("Coppe");
        }
    }

    /*

    final static Seme spade = new Seme(1),
            denari = new Seme(2),
            bastoni = new Seme(3),
            coppe = new Seme(4);

    static Seme getSeme(int value) {
        switch (value) {
            case 1:
                return spade;
            case 2:
                return denari;
            case 3:
                return bastoni;
            case 4:
                return coppe;
            default:
                return null;
        }
    }
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
            case -1:
                System.out.println("Valore passato in costruzione errato");
                break;
            default:
                System.exit(-1);
        }
    }
*/
}
