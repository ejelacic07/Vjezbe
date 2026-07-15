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

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return this.prezime.compareTo(polaznik.prezime);
    }
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}

