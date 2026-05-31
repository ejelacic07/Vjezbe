import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Polje {
    public static void main(String[] args) {


        Integer[] brojevi = new Integer[5];

        brojevi[0] = 11;
        brojevi[1] = 5;
        brojevi[2] = 15;
        brojevi[3] = 4;
        brojevi[4] = 22;

        System.out.println("*****Ispis cijele kolekcije*****");

        for (int i : brojevi) { //ForEach petlja
            System.out.println(i);
        }

        //Ispiši vrijednosti ove kolekcije korištenjem petlje for
        //System.out.println("****Ispis svih elemenata korištenjem petlje for******");


//        System.out.println("*****Sortiranje polja*****");
//        Arrays.sort(brojevi);
//
//        for (int i = 0; i < brojevi.length; i++) {
//            System.out.println(brojevi[i]);
//        }

        System.out.println("*****Okretanje polja*****");

        List<Integer> list = Arrays.asList(brojevi);
        Collections.reverse(list);

      for (Integer i : list) {
          System.out.println(i);
      }

    }

}
