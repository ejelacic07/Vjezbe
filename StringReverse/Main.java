import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unos: ");
        input = scanner.nextLine();

        int brojacSlova = 0;
        int brojacBrojeva = 0;
        int brojacOstalih = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String charAsString = String.valueOf(c);

            if (jeLiSlovo(charAsString)) {
                brojacSlova++;
            } else if (jeLiBroj(charAsString)) {
                brojacBrojeva++;
            } else {
                brojacOstalih++;
            }
        }

        System.out.println("Slova: " + brojacSlova);
        System.out.println("Brojevi: " + brojacBrojeva);
        System.out.println("Ostali znakovi: " + brojacOstalih);

        scanner.close();
    }

    public static boolean jeLiBroj(String str) {
        return str.matches("\\d");
    }

    public static boolean jeLiSlovo(String str) {
        return str.matches("^\\p{L}$");
    }

    public static boolean jeLiZnak(String str) {
        return str.matches("[^A-Za-z0-9\\s]");
    }
}


