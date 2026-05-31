import java.util.Scanner;

public class SumaBrojeva {
    public static void main(String[] args) {

        System.out.println("*** PROGRAM KOJI RAČUNA SUMU IZMEĐU DVA BROJA KOJA UNESEŠ ***");

        Scanner input = new Scanner(System.in);
        System.out.print("Unesite manji broj: ");
        int manji  = input.nextInt();
        System.out.print("Unesite veći broj: ");
        int veci = input.nextInt();
        int suma = 0;


        for (int i = manji; i < veci; i++) {
            suma+=i;

        }

        System.out.print("Suma je  " + suma);
    }
}
