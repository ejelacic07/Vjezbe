import java.util.Scanner;

public class DrugiZadatak {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite broj: ");
        int unos = sc.nextInt();
        int count = 0;
        int zbroj = 0;

        while (unos > 0) {
            int zadnji =  unos % 10;
            count++;
            zbroj += zadnji;
            unos /= 10;
            System.out.println(zadnji);

        }


        System.out.println("broj znamenki: " + count);
        System.out.println("zbroj: " + zbroj);

    }
}
