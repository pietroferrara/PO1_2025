public class Value {
    //1 asso, 2, 3, 4, 5, 6, 7, 8 fante, 9 cavallo, 10 re
    final int value;

    static final Value asso = new Value(1),
            due = new Value(2),
            tre = new Value(3),
            quattro = new Value(4),
            cinque = new Value(5),
            sei = new Value(6),
            sette = new Value(7),
            fante = new Value(8),
            cavallo = new Value(9),
            re = new Value(10);

    Value(int value) {
        if(value>=1 && value<=10)
            this.value = value;
        else this.value = -1;
    }

    static Value getValue(int value) {
        switch (value) {
            case 1:
                return asso;
            case 2:
                return due;
            case 3:
                return tre;
            case 4:
                return quattro;
            case 5:
                return cinque;
            case 6:
                return sei;
            case 7: return sette;
            case 8: return fante;
            case 9: return cavallo;
            case 10: return re;
            default:
                return null;
        }
    }


    void print() {
        switch (value) {
            case 1:
                System.out.println("Asso");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                System.out.println(value);
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
            case -1:
                System.out.println("Errore nel valore passato in fase di costruzione");
                break;
            default:
                System.exit(-1);

        }
    }

    boolean maggiore(Value valore) {
        if(value==1)
            return true;
        else if(value==3) {
            if (valore.value == 1)
                return false;
            else
                return true;
        }
        else if(valore.value==1 || valore.value==3)
            return false;
        else
            return value>=valore.value;
    }
}
