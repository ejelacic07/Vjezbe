import java.util.ArrayList;
import java.util.Scanner;

public class EvidencijaPolaznika {

    // public static Scanner input() = new Scanner(System.in);
    public static ArrayList<Polaznik> polaznici = new ArrayList<>();

    public static void main(String[] args) throws Exception {


        System.out.println("\n\nDobrodošli u sustav za evidenciju polaznika!\n");

        int unos;
        do {

            System.out.println("\n\nOdaberite jednu od opcija: ");

            System.out.println("\n1. Unos novog polaznika\n2. " +
                    "Ispis svih polaznika\n3. Pronađi polaznika");

            System.out.print("Odabir: ");
            unos = input().nextInt();


            switch (unos) {
                case 1:
                    System.out.println(1);
                    unosPolaznika();
                    break;
                case 2:
                    System.out.println(2);
                    pregledPolaznika();
                    break;
                case 3:
                    System.out.println(3);
                    pretragaPolaznika();
                    break;
            }

        } while (unos != 0);

    }


    public static void unosPolaznika() {


        System.out.print("Ime: ");
        String ime = input().nextLine();

        System.out.print("Prezime: ");
        String prezime = input().nextLine();

        System.out.print("E-mail: ");
        String email = input().nextLine();

        polaznici.add(new Polaznik(ime, prezime, email));

    }

    public static void pregledPolaznika() throws Exception {
//
//        Polaznik polaznik1 = new Polaznik("Sven", "Mišić", "smisi225@gmail.com");
//        polaznici.add(polaznik1);

        System.out.printf("%-1s%1s  %10s  %-12s  %20s  %n", "ID", ".", "Ime", "Prezime", "Email");
        System.out.printf("-------------------------------------------------%n");

        try {
            int counter = 0;
            for (Polaznik polaznik : polaznici) {
                System.out.printf("%-1d%1s  %10s  %-12s  %20s  %n", ++counter, ".", polaznik.getIme(), polaznik.getPrezime(), polaznik.getEmail());
            }
        } catch (NullPointerException e) {
            throw new Exception("" +
                    "Popis polaznika je prazan.");
        }

    }


    public static void pretragaPolaznika() {
//
//        Polaznik polaznik1 = new Polaznik("Sven", "Mišić", "smisi225@gmail.com");
//        polaznici.add(polaznik1);


        System.out.print("Upišite E-mail adresu polaznika: ");
        String email = input().nextLine();

        for (Polaznik polaznik : polaznici) {
            if (email.equals(polaznik.getEmail())) {
                System.out.println(polaznik.toString());
            }
        }


    }

    public static Scanner input() {
        return new Scanner(System.in);
    }
}
