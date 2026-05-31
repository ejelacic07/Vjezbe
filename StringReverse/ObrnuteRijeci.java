import java.util.Scanner;

public class ObrnuteRijeci {
    static void main() {

    String input;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Unos: ");
    input = scanner.nextLine();

    String[] inputArr = input.split(" ");

    for (int i = inputArr.length - 1; i >= 0; i--) {
        System.out.print(inputArr[i] + " ");
    }

    }
}
