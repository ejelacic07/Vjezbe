public class ArmstrongoviBrojevi {
    public static void main(String[] args) {


        for (int i = 1; i < 10000; i++) {
            int privremeni = i;
            int zbroj = 0;
            double sumaKubova = 0;

            while (privremeni > 0) {
                int zadnji = privremeni % 10;
                zbroj += zadnji;
                sumaKubova += Math.pow(zadnji, 3);
                privremeni /= 10;

            }

            if (i == sumaKubova) {
                System.out.println(i + " je Armstrongov broj (suma kubova: " + sumaKubova + ")");
            }
        }


    }
}
