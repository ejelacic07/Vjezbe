package model;

public class Pravokutnik extends GeometrijskiLik {

    private double stranaA;
    private double stranaB;
    private double opseg;
    private double povrsina;

    public Pravokutnik(String naziv, double stranaA1, double stranaB1) {
        super(naziv);
        this.stranaA = stranaA1;
        this.stranaB = stranaB1;
    }


    @Override
    public double izracunajPovrsinu() {
        povrsina = stranaA * stranaB;
        return povrsina;
    }

    @Override
    public double izracunajOpseg() {
        opseg = 2 * stranaA + 2 * stranaB;
        return opseg;
    }
}



