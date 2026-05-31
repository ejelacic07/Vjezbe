import model.*;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Ucilica ucilica = new Ucilica();


        Pravokutnik prav1 = new Pravokutnik("Plavi pravokutnik", 15, 7);
        Trokut trok1 = new Trokut("Zeleni", 9, 13, 7, 8);
        Krug krug1 = new Krug("veliki", 15);


        ucilica.getLikovi().add(prav1);
        ucilica.getLikovi().add(trok1);
        ucilica.getLikovi().add(krug1);


        for (GeometrijskiLik gl : ucilica.getLikovi()) {
                    System.out.println(gl);
        }

    }
}
