public class NaredbaThrow {

    public static void main(String[] args)
    {
        try {
            double rezultat = izracunajKorijen(-1);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static double izracunajKorijen(double broj) throws Exception, RuntimeException {
        if (broj<0.0) {
            throw new Exception("Broj ne smije imati negativnu vrijednost.");
        }
        return Math.sqrt(broj);
    }


}
