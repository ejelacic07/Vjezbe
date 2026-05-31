package model;

public class Krug extends GeometrijskiLik {

    private double polumjer;
    private double opseg;
    private double povrsina;

    public Krug(String naziv, double polumjer) {
        super(naziv);
        this.polumjer = polumjer;
    }


   @Override
    public double izracunajPovrsinu() {
         povrsina = Math.PI * Math.pow(polumjer, 2);
         return povrsina;
    }

    @Override
    public double izracunajOpseg() {
        opseg = 2 * polumjer * Math.PI;
        return opseg;
    }
}
