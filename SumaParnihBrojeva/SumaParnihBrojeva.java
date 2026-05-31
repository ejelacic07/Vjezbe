public class SumaParnihBrojeva {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 1; i <= 90; i++) {
            if(i % 2 == 0) {
                suma += i;
            }

        }
        System.out.println(suma);
    }

}
