public class MojaIznimka extends RuntimeException {

   private String korisnik;

    public MojaIznimka(String message, String korisnik) {
        super(message);
        this.korisnik = korisnik;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }
}
