import java.util.Arrays;
import java.util.Scanner;

public class PrijestupnaGodina {
    public static void main(String[] args) {

        int godina;
        int[] godine = new int[7];

        for (int i = 0; i < 7; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Unesite godinu: ");
           godina = sc.nextInt();
           godine[i] =  godina;
        }

       //  System.out.println(Arrays.toString(godine));

        for (int j : godine) {
           // System.out.println(j);
            if((j % 4 == 0 && j % 100 != 0) || (j % 400 == 0)) {
                System.out.println("Godina " + j + ". je prijestupna");
            } else {
                System.out.println("Godina " + j + ". nije prijestupna");
            }

        }





    }
}
