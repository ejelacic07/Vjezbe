package publikacije;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Publikacija> publikacije = new ArrayList<>();

         System.out.println("Odaberite tip publikacije koji želite unjeti: \n 1 - Knjiga\n 2 - Časopis\n 3 - Znanstveni rad\n 4- Izlaz");
         System.out.print("Unesite jedan broj između 1 i 4: ");
         Scanner ulaz = new Scanner(System.in);
         int ulazInt = ulaz.nextInt();

         if(ulazInt == 4){
             System.exit(0);
         }

              System.out.println("Unesite podatke o publikaciji: Naslov, Godina izdanja");

              System.out.println("Naslov: ");
              Scanner ulaz2 = new Scanner(System.in);
              String naslov2 = ulaz2.nextLine();

              System.out.println("Godina izdanja: ");
              int naslov3 = ulaz2.nextInt();

                if(ulazInt == 1) {

                    System.out.println("Ime i prezime autora: ");
                    String naslov4 = ulaz2.nextLine();
                    Knjiga knjiga1 = new Knjiga(naslov2, naslov3, naslov4);
                    publikacije.add(knjiga1);

                } else if (ulazInt == 2) {

                    System.out.println("Broj izdanja: ");
                    int naslov4 = ulaz2.nextInt();
                   Casopis casopis = new Casopis(naslov2, naslov3, naslov4);
                   publikacije.add(casopis);

                } else if (ulazInt == 3) {

                    System.out.println("Znanstveno područje: ");
                    String naslov4 = ulaz2.nextLine();

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
