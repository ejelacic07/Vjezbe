public class Zadatak {
    public static void main(String[] args) {


         //Zadatak 1:
        //Korištenjem petlje do while izračunaj zbroj brojeva od 1 do 1000 djeljivih sa 7.


        int suma = 0;
        int a = 1;
        int b = 1000;

        do {
            if(a % 7 == 0) {
                suma += a;
            }

            a++;
        } while (a < b);

        System.out.println("Suma  brojeva je  " + suma);
    }
}
