import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("UPRAVLJANJE DATOTEKAMA  \n 1. Provjera postoji li datoteka \n 2. Kopiranje datoteke " +
                "\n 3. Brisanje datoteke \n 4. Izlaz iz programa \n\n\n Vaš odabir: ");

        Scanner sc = new Scanner(System.in);
        int izbor = sc.nextInt();
        switch (izbor) {
            case 1:
                System.out.print("1. Provjera postoji li datoteka. \n Unesite naziv datoteke: ");
                String datoteka = unosDatoteke();
                File f = new File(datoteka);
                if (f.exists()) {
                    System.out.println("Datoteka " + datoteka + " postoji.");
                }
                break;
            case 2:
                System.out.print("2. Kopiranje datoteke. \n Unesite naziv datoteke koju želite kopirati: ");
                String datOriginal = unosDatoteke();
                System.out.print("Unesite naziv destinacijskog foldera i datoteke: ");
                String datKopija = unosDatoteke();
                kopiranjeDatoteke(datOriginal, datKopija);
                File kopijaF = new File(datKopija);

                if (kopijaF.exists() && kopijaF.length() == datOriginal.length()) {
                    System.out.print("Kopiranje uspješno!");
                }
                break;
            case 3:
                System.out.println("3. Unesite putanju datoteke za brisanje: ");
                String datBrisanje = unosDatoteke();
                brisanjeDatoteke(datBrisanje);
                break;
            case 4:
                System.out.println("Izlaz iz programa ");
                break;
        }
    }

    public static String unosDatoteke() {
        Scanner sc = new Scanner(System.in);
        String unosDatoteke = sc.nextLine();
        return unosDatoteke;
    }

    public static void kopiranjeDatoteke(String datoteka, String kopija) {
        try (FileInputStream fis = new FileInputStream(datoteka);
             FileOutputStream fos = new FileOutputStream(kopija)) {
            int c;
            while ((c = fis.read()) != -1) {
                System.out.print((char) c + " ");
                fos.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
            System.out.println("  Provjerite putanju i pokušajte ponovno.");
        } catch (SecurityException e) {
            System.out.println("✗ " + e.getMessage());
            System.out.println("  Provjerite dozvole za datoteku.");
        } catch (Exception e) {
            System.out.println("✗ Neočekivana greška: " + e.getMessage());
        }

    }

    public static void brisanjeDatoteke(String datoteka) throws FileNotFoundException {
        try {
            File f = new File(datoteka);
            if (!f.exists()) {
                throw new FileNotFoundException("Datoteka ne postoji!");
            }
            if (!f.canWrite()) {
                throw new SecurityException("Nemate prava obrisati ovu datoteku!");
            }
            boolean deleted = f.delete();
            if (deleted) {
                System.out.println("Datoteka je uspješno obrisana!");
            } else {
                System.out.println("Brisanje nije uspjelo!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
            System.out.println("  Provjerite putanju i pokušajte ponovno.");
        } catch (SecurityException e) {
            System.out.println("✗ " + e.getMessage());
            System.out.println("  Provjerite dozvole za datoteku.");
        } catch (Exception e) {
            System.out.println("✗ Neočekivana greška: " + e.getMessage());
        }
    }

}