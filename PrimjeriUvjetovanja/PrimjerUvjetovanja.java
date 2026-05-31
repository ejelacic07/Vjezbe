
public class PrimjerUvjetovanja {
    //switch
    public static void main(String[] args) {

        int b = 55;

        int ocjena = 2;
        //uvjetovanje korištenjem znakova
        char spol = 'm';

        if (spol == 'm') {
            System.out.println("Korisnik je muška osoba!");
        } else if (spol == 'ž') {
            System.out.println("Korisnik je ženska osoba!");
        } else {
            System.out.println("Nije unesen ispravan znak");
        }

        System.out.println("Switch naredba");
        switch (ocjena) {
            case 1:
                System.out.println("Ocjena je nedovoljan.");
                break;
            case 2:
                System.out.println("Ocjena je dovoljan.");
                break;
            case 3:
                System.out.println("Ocjena je dobar.");
                break;
            case 4:
                System.out.println("Ocjena je vrlo dobar.");
                break;
            case 5:
                System.out.println("Ocjena je odličan.");
                break;
            default:
                System.out.println("Nije unesena ispavna ocjena.");
        }


        System.out.println("\n\n\n****** Provjera parnih brojeva do 5 *******");


         String dan = "subota";
        int brojDana = 0;


        switch (dan) {
            case "ponedjeljak":
                brojDana = 1;
                break;
            case "utorak":
                brojDana = 2;
                break;
            case "srijeda":
                brojDana = 3;
                break;
            case "četvrtak":
                brojDana = 4;
                break;
            case "petak":
                 brojDana = 5;
                 break;
            case "subota":
                brojDana = 6;
                break;
            case "nedjelja":
                brojDana = 7;
                break;
            default:
                System.out.println("Nije unesen točan naziv dana.");
        }

        radniNeradni(brojDana);

    }

    public static void radniNeradni(int broj) {
        switch (broj) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            System.out.println("Unesen je radni rad.");
            break;
            case 6:
            case 7:
            System.out.println("Unesen je neradni dan.");
            default:
                System.out.println("Nije unesen ispavan broj.");
        }

    }
}



/*
        switch (ocjena) {
            case 2:
            case 4:
                System.out.println("Broj je paran.");
                break;
            case 1:
            case 3:
            case 5:
                System.out.println("Broj je neparan.");
                break;
            default:
                System.out.println("Nije unesena ispavan broj.");
        }
*/
