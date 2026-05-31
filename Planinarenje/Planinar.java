package planinarenje;

public class Planinar {

    private String ime;
    private String prezime;
    private int brojOsvojenihVrhova;
    private double visinaNajvisegVrha;


    public Planinar(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public double getVisinaNajvisegVrha() {
        return visinaNajvisegVrha;
    }

    public int getBrojOsvojenihVrhova() {
        return brojOsvojenihVrhova;
    }

    public String getIme() {
        return ime;
    }

    public void setBrojOsvojenihVrhova(int brojOsvojenihVrhova) {
        this.brojOsvojenihVrhova = brojOsvojenihVrhova;
    }

    public void setVisinaNajvisegVrha(double visinaNajvisegVrha) {
        this.visinaNajvisegVrha = visinaNajvisegVrha;
    }

    public String toString() {
        return "planinarenje.Planinar je "  + getIme() + " " + getPrezime() + ". Osvojio je " + getBrojOsvojenihVrhova() +
                " vrhova, a visina najvišeg bila je " + getVisinaNajvisegVrha();
    }

}
