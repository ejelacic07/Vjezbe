import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Upišite iznos koji je potrebno vratiti: ");
        double cijeliBroj =  input.nextDouble();

        int iznosUCentima = (int) (cijeliBroj * 100 + 0.5);

        int[] cijeli ={500, 200, 100, 50, 20, 10, 5,
                2, 1};

        double[] polovicni = {0.50, 0.20, 0.10, 0.05, 0.02, 0.01};


        int euri = iznosUCentima / 100;
        System.out.println(/****Morate vratiti****/);

        for (int element : cijeli) {
            if (euri >= element) {
                int broj = euri / element;
                System.out.println(broj + "*" + element + " eura");
                euri = euri % element;
            }
        }

        int centi = iznosUCentima % 100;
        for (double element : polovicni) {
            int vrijednostUCentima = (int) (element * 100);
            if (centi >= vrijednostUCentima) {
                int broj = centi / vrijednostUCentima;
                System.out.println(broj + "*" + element + " eura");
                centi %= vrijednostUCentima;
            }
        }

        input.close();
    }

}