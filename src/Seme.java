public class Seme {
    //1 spade, 2 denari, 3 bastoni, 4 coppe
    int value;

    Seme(int value1) {
        if(value1 >= 1 && value1 <= 4)
            this.value = value1;
        else this.value = -1;
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

}
