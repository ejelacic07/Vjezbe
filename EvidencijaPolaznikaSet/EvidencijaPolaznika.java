import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvidencijaPolaznika {


    public static HashSet<Polaznik> polaznici = new HashSet<>();
    //public static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(EvidencijaPolaznika.class.getName());


    public static void main(String[] args) throws Exception {

        System.out.println("\n\nDobrodošli u sustav za evidenciju polaznika!\n");

        int unos;

        do {
            System.out.println("\n\nOdaberite jednu od opcija: ");

            System.out.println("\n1. Unos novog polaznika\n2. " +
                    "Ispis svih polaznika\n3. Izađi iz programa");

            System.out.print("Odabir: ");
            unos = scanner().nextInt();

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
                    System.exit(0);
                    break;
            }
        } while (unos != 0);

    }


    public static void unosPolaznika() {

        System.out.print("Ime: ");
        String ime = scanner().nextLine();

        System.out.print("Prezime: ");
        String prezime = scanner().nextLine();

        System.out.print("E-mail: ");
        String email = scanner().nextLine();

        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);

        if(polaznici.contains(noviPolaznik)) {
            logger.log(Level.WARNING, "Ne možete unijeti istog polaznika na tečaj! Polaznik s ovom mail adresom već postoji!");
            return;
        } else polaznici.add(noviPolaznik);

    }

    public static void pregledPolaznika() throws Exception {

        ArrayList<Polaznik> sortirano = new ArrayList<>(polaznici);
        Collections.sort(sortirano);

        System.out.printf("%-1s%1s  %10s  %-12s  %20s  %n", "ID", ".", "Ime", "Prezime", "Email");
        System.out.printf("-------------------------------------------------%n");

        try {
            int counter = 0;
            for (Polaznik polaznik : sortirano) {
                System.out.printf("%-1d%1s  %10s  %-12s  %20s  %n", ++counter, ".", polaznik.getIme(), polaznik.getPrezime(), polaznik.getEmail());
            }

        } catch (NullPointerException e) {
            throw new Exception("Popis polaznika je prazan.");
        }

    }


    public static Scanner scanner() {
        return new Scanner(System.in);
    }

}