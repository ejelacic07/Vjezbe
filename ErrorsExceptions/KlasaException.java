public class KlasaException {
    public static void main(String[] args) {
        int broj;
        String unos = "1234d";

        try {
            broj = Integer.parseInt(unos);
        } catch (NumberFormatException e) {
            System.out.println("Unijeli ste pogrešan unos!");
            System.out.println("Postavljanje unosa na defaultnu vrijednost 1!");
            broj = 1;

        }
    }
}