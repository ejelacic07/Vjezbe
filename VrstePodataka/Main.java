public class Main {
    public static void main(String[] args) {

        byte a = 5;
        int b = 55;
        long l = 5L;
        float f = 55.5f;
        double d = 55.5;
        char c = 'a';
        boolean g = true;

        int ivo = 13;
        int maja = 17;
        int perica = 22;

        double prosjek = (double) (ivo + maja + perica) / 3;
        double kvadrat = Math.pow(a, b);
        double korijen = Math.sqrt(kvadrat);
        double trecaPotencija = Math.pow(b, 3);
    

        if (b > 25) System.out.println("Broj " + b + " je veći od 25.");
        else {
            System.out.println("Broj " + b + " je manji ili jednak 25.");
        }
        ocijena(5);
    }


    public static void ocijena(int broj) {
        if (broj == 5) {
            System.out.println("Odličan");
        } else if (broj == 4) {
            System.out.println("Vrlo dobar");
        } else if (broj == 3) {
            System.out.println("Dobar");
        } else if (broj == 2) {
            System.out.println("Dovoljan");
        } else if (broj == 1) {
            System.out.println("Nedovoljan");
        } else {
            System.out.println("Unesite ocjenu!");
        }
      //  return "";
    }
}