package publikacije;

public class Casopis extends Publikacija{

     private int brojIzdanja;


    public Casopis(String naslov, int godinaIzdanja, int brojIzdanja) {
        super(naslov, godinaIzdanja);
        this.brojIzdanja = brojIzdanja;
    }

    public int getBrojIzdanja() {
        return brojIzdanja;
    }

    @Override
     public String toString() {
        return "Naziv ovog časopisa je " + getNaslov() + ", godina izdanja je " + getGodinaIzdanja() + ", a broj izdanja je " + getBrojIzdanja();
     }

}
