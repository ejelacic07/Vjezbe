package model;

public abstract class GeometrijskiLik implements Comparable<GeometrijskiLik> {
    private String naziv;

    public GeometrijskiLik(String naziv) {
        this.naziv = naziv;
    }

    public abstract double izracunajPovrsinu();

    public abstract double izracunajOpseg();


    public String toString() {
        return "Geometrijski lik:  Naziv -  " + naziv + ", površina " + izracunajPovrsinu() + ", opseg " + izracunajOpseg();

    }

    // "Ja sam student s brojem indexa [brojIndexa] na [godinaStudija]. godini."

    @Override
    public int compareTo(GeometrijskiLik o) {
        return Double.valueOf(izracunajOpseg()).compareTo(Double.valueOf(o.izracunajPovrsinu()));

    }

}
