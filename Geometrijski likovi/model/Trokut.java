package model;


public class Trokut extends GeometrijskiLik{

    private double stranaA;
    private double stranaB;
    private double stranaC;
    private double visina;
    private double opseg;
    private double povrsina;

    public Trokut(String naziv, double stranaA, double stranaB, double stranaC, double visina) {
        super(naziv);
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = stranaC;
        this.visina = visina;
    }
 

    @Override
    public double izracunajPovrsinu() {
        povrsina = 0.5 * stranaB * visina;
        return povrsina;
    }

    @Override
    public  double izracunajOpseg() {
      opseg = stranaA + stranaB + stranaC;
      return opseg;
    }

}
