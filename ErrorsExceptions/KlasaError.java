import java.util.ArrayList;

public class KlasaError {
    public static void main(String[] args) {
        try {
            ArrayList<String> znakovniNiz = new ArrayList<>();
            while (true) {
                System.out.println("Sad sam u dijelu za izvršenje zadatka ");
                znakovniNiz.add("Znakovni dodatak");
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Greška: " + e.getMessage()); //Svako pokretanje baca grešku zbog manjka memorije
        }
    }
}