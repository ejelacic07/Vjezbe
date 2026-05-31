package publikacije;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//Popravit ovo
        ArrayList<Publikacija> publikacije = new ArrayList<>();

         System.out.println("Odaberite tip publikacije koji želite unjeti: \n 1 - Knjiga\n 2 - Časopis\n 3 - Znanstveni rad\n 4- Izlaz");
         System.out.print("Unesite jedan broj između 1 i 4: ");
         Scanner ulaz = new Scanner(System.in);
         int ulazInt = ulaz.nextInt();

              System.out.println("Unesite podatke o publikaciji: Naslov, Godina izdanja");

              System.out.println("Naslov: ");
              Scanner ulaz2 = new Scanner(System.in);
              String naslov2 = ulaz2.nextLine();

              System.out.println("Godina izdanja: ");
              Scanner ulaz3 = new Scanner(System.in);
              int naslov3 = ulaz3.nextInt();

                if(ulazInt == 1) {

                    System.out.println("Ime i prezime autora: ");
                    Scanner ulaz4 = new Scanner(System.in);
                    String naslov4 = ulaz4.nextLine();

                    Knjiga knjiga1 = new Knjiga(naslov2, naslov3, naslov4);
                    publikacije.add(knjiga1);

                } else if (ulazInt == 2) {

                    System.out.println("Broj izdanja: ");
                    Scanner ulaz4 = new Scanner(System.in);
                    int naslov4 = ulaz4.nextInt();

                   Casopis casopis = new Casopis(naslov2, naslov3, naslov4);
                   publikacije.add(casopis);

                } else if (ulazInt == 3) {

                    System.out.println("Znanstveno područje: ");
                    Scanner ulaz4 = new Scanner(System.in);
                    String naslov4 = ulaz4.nextLine();

                    ZnanstveniRad zr = new ZnanstveniRad(naslov2, naslov3, naslov4);
                    publikacije.add(zr);
                }

           for (Publikacija element : publikacije) {
                System.out.println("***Podaci o publikaciji:***");
                System.out.println(element.toString());
           }

      ulaz.close();
    }
}
