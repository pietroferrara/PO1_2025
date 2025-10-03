public class Runner {

    public static void main(String[] args) {
        int x = 0;
        int j = 12;
        if(x < 0)
            j = -12;
    }

    static int sum(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

}
