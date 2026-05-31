package nogomet;

public class Sportas {

    private String ime;
    private int brojDresa;


    public Sportas(String ime, int brojDresa) {
        this.ime = ime;
        this.brojDresa = brojDresa;
    }

    public String getIme() {
        return this.ime;
    }

    public int getBrojDresa() {
        return this.brojDresa;
    }
}
