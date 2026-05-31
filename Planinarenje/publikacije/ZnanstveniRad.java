package publikacije;

public class ZnanstveniRad extends Publikacija {

    private String podrucje;

    public ZnanstveniRad(String naslov, int godinaIzdanja, String podrucje) {
        super(naslov, godinaIzdanja);
        this.podrucje = podrucje;
    }

    public String getPodrucje() {
        return this.podrucje;
    }

    @Override
    public String toString() {
        return "Naziv ovog rada je " + getNaslov() + ", godina izdanja je " + getGodinaIzdanja() + "., a znanstveno područje je " +getPodrucje() + ".";
    }

}
