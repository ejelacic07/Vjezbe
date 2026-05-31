package publikacije;

public class Publikacija implements Comparable<Publikacija> {

      private String naslov;
      private int godinaIzdanja;

    public Publikacija(String naslov, int godinaIzdanja) {
       this.naslov = naslov;
       this.godinaIzdanja = godinaIzdanja;

    }

    @Override
    public int compareTo(Publikacija publikacija) {
        return Integer.compare(this.godinaIzdanja, publikacija.godinaIzdanja);
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public String getNaslov() {
        return naslov;
    }

    public String toString() {
        return "Naslov ove publikacije je "  + getNaslov() + ", a godina izdanja je  " + getGodinaIzdanja() + ".";
    }
}
