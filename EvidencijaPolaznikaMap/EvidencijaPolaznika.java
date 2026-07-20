import java.util.*;

public class EvidencijaPolaznika {



    public static HashMap<String, Polaznik> polaznici = new HashMap<>();
    //public static Scanner scanner = new Scanner(System.in);
    public static String email;
    public static int izbor;

    public static void main(String[] args) throws Exception {


        System.out.println("\n\nDobrodošli u sustav za evidenciju polaznika!\n");

        do {
            System.out.println("Odaberite \n1. Unos polaznika \n2. Ispis podataka o polaznicima\n3. Izađi iz programa");
            izbor = scanner().nextInt();

            if (izbor == 1) {
                dodajPolaznika();
            } else if (izbor == 2) {
                ispisPolaznika();
            } else if (izbor == 3) System.exit(0);
        } while (izbor != 0);
    }

    public static void dodajPolaznika() {

        System.out.println("1. Unesite podatke o polazniku ");

        System.out.print("Ime: ");
        String ime = scanner().nextLine();

        System.out.print("\nPrezime: ");
        String prezime = scanner().nextLine();

        System.out.print("\nEmail: ");
        email = scanner().nextLine();

        if (polaznici.containsKey(email)) {
            System.err.println("Polaznik je već unijet u evidenciju!.");
        } else {
            polaznici.put(email, new Polaznik(ime, prezime, email));
            System.out.println("Polaznik je uspješno unijet u evidenciju!.");
        }
    }


    public static void ispisPolaznika() throws Exception {


        System.out.println("2. Ispis polaznika:  ");


        TreeMap<String, Polaznik> sortirano = new TreeMap<>(polaznici);

        for (Map.Entry<String, Polaznik> polaznik :
                sortirano.entrySet()) {
            System.out.println("Key : " + polaznik.getKey()
                    + ", Value : "
                    + polaznik.getValue());
        }


        System.out.printf("%-1s%1s  %10s  %-12s  %20s  %n", "ID", ".", "Ime", "Prezime", "Email");
        System.out.printf("-------------------------------------------------%n");

        try {
            int counter = 0;
            for (Polaznik polaznik : polaznici.values()) {
                System.out.printf("%-1d%1s  %10s  %-12s  %20s  %n", ++counter, ".", polaznik.getIme(), polaznik.getPrezime(),
                        polaznik.getEmail());
            }
        } catch (NullPointerException e) {
            throw new Exception("Popis polaznika je prazan.");
        }
    }

    public static Scanner scanner() {
        return new Scanner(System.in);
    }

}





