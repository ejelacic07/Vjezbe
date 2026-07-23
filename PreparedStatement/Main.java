import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Drzava> drzave = new ArrayList<>();

        DataSource dataSource = createDataSource();
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Uspješno ste spojeni na bazu podataka!\n");

            String izbor = "";
            System.out.println("===Unos i brisanje država===\n");

            do {

                System.out.println("1. Unesite nazive pet država\n2. Obrišite države od ID\n3. Izlaz");
                System.out.print("Izbor: ");
                izbor = sc.nextLine();

                if (izbor.equals("1")) {
                    int counter = 0;
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Unesite nazive pet država: ");
                        System.out.print(++counter + ": ");
                        String naziv = sc.nextLine();

                        drzave.add(new Drzava(counter, naziv));

                    }
                    for (Drzava drzava : drzave) {
                        System.out.println(drzava.toString());
                        dodajDrzave(drzava.getNaziv(), connection);
                    }
                    ispisDrzava(connection);

                } else if (izbor.equals("2")) {
                    System.out.print("Unesite ID države od koje želite pobrisati tablicu: ");
                    String id = sc.nextLine();
                    obrisiDrzave(Integer.parseInt(id), connection);

                } else System.exit(0);

            } while(!izbor.equals("0"));

        } catch (SQLException e) {
            System.err.println("Greška prilikom spajanja na bazu podataka!");
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void dodajDrzave(String naziv, Connection connection) throws SQLException {
            String sql = "INSERT INTO Drzava(Naziv) VALUES(?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, naziv);
            pstmt.executeUpdate();
            System.out.println("Dodana je država " + naziv);
    }

    public static void ispisDrzava(Connection connection) throws SQLException {
        System.out.println("\n\nSve države");
        PreparedStatement pstmt = connection.prepareStatement("SELECT *  FROM Drzava");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%d %s\n", rs.getInt(1), rs.getString(2));
        }
        System.out.println("\n\n");

        rs.close();
    }

    public static void obrisiDrzave(int id, Connection connection) throws SQLException {

            try(CallableStatement cs = connection.prepareCall("{CALL obrisiDrzavu(?)}");) {
                cs.setInt(1, id);

                int rowsAffected =  cs.executeUpdate();
                System.out.println("Obrisano je " + rowsAffected + " država.\n\n");

            }  catch (SQLException e) {
                System.err.println("Greška pri spajanju na bazu");
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
    }

    private static DataSource createDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("AdventureWorksOBP");
        ds.setUser("sa");
        ds.setPassword("SQL");
        ds.setEncrypt("false");

        return ds;
    }

}