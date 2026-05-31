package nogomet;

public class Nogometas extends Sportas implements Comparable<Nogometas> {

    private int brojGolova;

    public Nogometas(String ime, int brojDresa, int brojGolova) {
        super(ime, brojDresa);
        this.brojGolova = brojGolova;
    }
    @Override
    public int compareTo(Nogometas nogometas) {
        return Integer.compare(nogometas.brojGolova, this.brojGolova);
    }


    @Override
    public String toString() {
        return "Nogometaš: " + getIme() + ", broj dresa: " + getBrojDresa();
    }
}
