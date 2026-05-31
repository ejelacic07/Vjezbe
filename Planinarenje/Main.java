package planinarenje;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


     //   List<planinarenje.Planinar> planinari = Arrays.asList(new planinarenje.Planinar[3]);
        Planinar[] planinari = new Planinar[3];
        Scanner input = new Scanner(System.in);

        System.out.print("Koliko planinara želite unijeti? ");
        int brojPlaninara = input.nextInt();
        input.nextLine();


        for (int i = 0; i < brojPlaninara; i++) {

            System.out.print("Ime: ");
            String ime = input.nextLine();

            System.out.print("Prezime: ");
            String prezime = input.nextLine();

            System.out.print("Broj osvojenih vrhova: ");
            int brojVrhova = input.nextInt();

            System.out.print("Visina najvišeg vrha (metri) ");
            double visina = input.nextDouble();


            Planinar noviPlaninar = new Planinar(ime, prezime);
            //dovršit ovo

        }


        for (Planinar planinar : planinari) {
            //System.out.println(p.toString());
        }

        input.close();
    }
}
