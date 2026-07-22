import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

     public static int izbor;

    public static void main(String[] args) {

        System.out.println("Unos i pregled države");

        do {

        System.out.println("Odaberite \n1. Unos nove države \n2. Izmjena postojeće države\n3. Brisanje postojeće države\n" +
                "4. Prikaz svih država sortiranih po nazivu\n5. Izađi iz programa");

            System.out.print("Vaš izbor (1-5): ");
            izbor = unos().nextInt();


        DataSource dataSource = createDataSource();

        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {

            System.out.println("Uspješno ste spojeni na bazu podataka!\n");

            switch (izbor) {
                case 1:
                    System.out.println(izbor);
                    System.out.print("Unesite naziv države: ");
                    String drzava = unos().nextLine();

                    unosDrzave(stmt, drzava);
                    break;

                case 2:
                    System.out.println("Izmjena postojeće države");
                    ispisDrzava(stmt);

                    System.out.print("Unesite id: ");
                    int id = unos().nextInt();
                    System.out.print("Unesite novi naziv: ");
                    String noviNaziv = unos().nextLine();

                    izmjenaDrzave(stmt, id, noviNaziv);
                    break;

                case 3:
                    System.out.println("Brisanje države ");
                    ispisDrzava(stmt);

                    System.out.print("Unesite ID države koju želite izbrisati: ");
                    int drzavaZaBrisanje = unos().nextInt();
                    brisanjeDrzave(stmt, drzavaZaBrisanje);
                    break;

                case 4:
                    prikazDrzava(stmt);
                    break;

                case 5:
                    System.exit(0);
                    break;
            }

        } catch (SQLException e) {
            System.err.println("Greška prilikom spajanja na bazu podataka!");
            e.printStackTrace();
        }

        } while (izbor != 0);
    }


    public static void unosDrzave(Statement stmt, String drzava) throws SQLException {
        String sql = "INSERT INTO Drzava(Naziv) VALUES ('" + drzava + "')";
        int rowsAffected = stmt.executeUpdate(sql);
        System.out.println("Novi podatak je dodan u tablicu");

    }

    public static void izmjenaDrzave(Statement stmt, int id, String drzava) throws SQLException {
        String sql1 = String.format("UPDATE Drzava SET Naziv='%s'  WHERE idDrzava='%d'", drzava, id);
        stmt.executeUpdate(sql1);
        System.out.println("Država je uspješno preimenovana.");
    }

    public static void brisanjeDrzave(Statement stmt, int id) throws SQLException {
        String sql2 = "DELETE FROM Drzava WHERE IDDrzava= '" + id + "'";
        int rowsAffected2 = stmt.executeUpdate(sql2);
        System.out.println("Država je izbrisana. " + rowsAffected2);
    }

    public static void prikazDrzava(Statement stmt) throws SQLException {
        System.out.println("\nPopis Država\n");

        ResultSet rs = stmt.executeQuery("SELECT *  FROM Drzava ORDER BY Naziv ASC");
        System.out.printf("%-4s %4s\n", "ID", "Naziv");
        System.out.printf("--------------------%n");
        while (rs.next()) {
            System.out.printf("%-4d %4s\n", rs.getInt(1), rs.getString(2));

        }
        System.out.println("\n\n");
    }


    public static void ispisDrzava (Statement stmt) throws SQLException {
        System.out.println("\nIspis Država");

        ResultSet rs = stmt.executeQuery("SELECT *  FROM Drzava");
        System.out.printf("%-4s %4s\n", "ID", "Naziv");
        System.out.printf("--------------------%n");
        while (rs.next()) {
            System.out.printf("%-4d %4s\n", rs.getInt(1), rs.getString(2));

        }
        System.out.println("\n");
    }


    public static Scanner unos() {
        return new Scanner(System.in); // ako ga hoces jednom inicijalizirati, treba parseInt i sve ko string
    }

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