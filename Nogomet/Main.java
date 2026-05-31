package nogomet;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Nogometas> nogometasi = new ArrayList<>();

        Nogometas nogometas1 = new Nogometas("Ivan Perišić", 14, 38);
        Nogometas nogometas2 = new Nogometas("Andrej Kramarić", 27, 36);
        Nogometas nogometas3 = new Nogometas("Mislav Oršić", 16, 2);

        nogometasi.add(nogometas1);
        nogometasi.add(nogometas2);
        nogometasi.add(nogometas3);

        Collections.sort(nogometasi);

        for(Nogometas nogometas : nogometasi) {
            System.out.println(nogometas);
        }

    }
}
