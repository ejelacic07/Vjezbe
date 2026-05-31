import java.util.Scanner;

public class UnosKonzola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Unesite prvi broj: ");
        int a  = input.nextInt();
        System.out.print("Unesite drugi broj: ");
        int b = input.nextInt();

        int c = a + b;
        System.out.print("Zbroj broja " +  a + " i broja b je " + c);

    }
}
