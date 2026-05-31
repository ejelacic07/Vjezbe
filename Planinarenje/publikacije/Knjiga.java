package publikacije;

import java.util.ArrayList;

public class Knjiga extends Publikacija {

     private String autor;

     ArrayList<Publikacija> publikacija = new ArrayList<>();

    public Knjiga(String naslov, int godinaIzdanja, String autor) {
        super(naslov, godinaIzdanja);
        this.autor = autor;
    }

    public String getAutor() {
        return this.autor;
    }

    @Override
    public String toString() {
        return "Naziv ove knjige je " + getNaslov() + ", godina izdanja je " + getGodinaIzdanja() + ". Autor je " +  getAutor();
    }
}
