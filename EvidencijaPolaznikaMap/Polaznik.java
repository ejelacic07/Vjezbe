import java.util.Objects;

public class Polaznik implements Comparable<Polaznik> {

    private String ime;
    private String prezime;
    private String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Polaznik je: " +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + ".";
    }

    @Override
    public int compareTo(Polaznik polaznik) {
        return this.email.compareTo(polaznik.email);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polaznik polaznik = (Polaznik) o;
        return email.equals(polaznik.email);
    }



    @Override
    public int hashCode() {
        return email.hashCode();
    }
}


