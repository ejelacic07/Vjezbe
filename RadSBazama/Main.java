import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//21. 7. 2026. -- nastava
//https://github.com/DinkoAlgebra/21_7_2026_JDBC/blob/master/src/Main.java

public class Main {
    public static void main(String[] args) {

        //1. Kreiranje DataSource objekta i stvaranje konekcije prema bazi
        DataSource dataSource = createDataSource();
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) { //connection se zatvara sam u try dijelu, inače zatvori
            System.out.println("Uspješno ste spojeni na bazu podataka!\n");


           // 2. preimenovanje države
           //  int rowsAffected = stmt.executeUpdate("UPDATE Drzava SET Naziv='Hrvatska' WHERE idDrzava=1");
            String drzava = "Hrvatska";
            String sql = "UPDATE Drzava SET Naziv='" + drzava + "' WHERE idDrzava=1";
           //  String sql = "UPDATE Drzava SET Naziv='" + drzava +"' WHERE idDrzava=1";
            String sql1 = String.format("UPDATE Drzava SET Naziv='%s'  WHERE idDrzava=1", drzava);
            int rowsAffected = stmt.executeUpdate(sql1);
            System.out.println("Država je uspješno preimenovana.");
            System.out.println("Broj promijenjenih redaka: " + rowsAffected);

            int rowsAffected1 = stmt.executeUpdate("DELETE FROM Drzava WHERE idDrzava=12");
            String sqlIdentity = "SET IDENTITY_INSERT dbo.kATEGORIJA ON";
                    stmt.executeUpdate(sqlIdentity);

            //1. INSERT
//            String sql = "INSERT INTO Kategorija(IDKategorija, Naziv) VALUES (6, 'Obuća')";
//            int rowsAffected = stmt.executeUpdate(sql);
//            System.out.println("Novi podatak je dodan u tablicu");

            //2. DELETE
//            String sql2 = "DELETE FROM Potkategorija WHERE KategorijaID = 4";
//            int rowsAffected2 = stmt.executeUpdate(sql2);
//            System.out.println("Potkategorija je izbrisana. " + rowsAffected2);

            //3. UPDATE ---> rezultat više redaka
//            String sql3 = "UPDATE Kupac SET Ime = 'Alfred' WHERE GradID = 4";
//            int rowsAffected3 = stmt.executeUpdate(sql3);
//            System.out.println("Uspješna promjena u tablici Kupac. Promijenjeno je " + rowsAffected3 + " redova.");

//
            System.out.println("\nPopis Kategorija");
            ResultSet rs = stmt.executeQuery("SELECT *  FROM Kategorija");
            while (rs.next()) {
                System.out.printf("%d %s\n", rs.getInt(1), rs.getString(2));
            }
//
//            System.out.println("\nPopis Potkategorija");
//            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Potkategorija WHERE KategorijaID = 4");
//            while (rs2.next()) {
//                System.out.printf("%d %d %s\n", rs2.getInt(1), rs2.getInt(2), rs2.getString(3));
//            }
//
//            System.out.println("\nPopis Kupaca");
//            ResultSet rs3 = stmt.executeQuery("SELECT IDKupac, Ime FROM Kupac WHERE GradID = 4");
//            while (rs3.next()) {
//                System.out.printf("%d %s\n", rs3.getInt(1), rs3.getString(2));
//            }


            rs.close();
//            rs2.close();
//            rs3.close();

        } catch (SQLException e) {
            System.err.println("Greška prilikom spajanja na bazu podataka!");
            e.printStackTrace();
        }
    }


    //Metoda za stvaranje DataSource objekta

    private static DataSource createDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("AdventureWorksOBP");
        ds.setUser("sa");
        ds.setPassword("SQL");
        ds.setEncrypt(false);
        return ds;


    }
}