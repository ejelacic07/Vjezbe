import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataSource dataSource = createDataSource();


        try(Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to database.");

            try (Statement statement1 = connection.createStatement();
                 Statement statement2 = connection.createStatement()) {

                connection.setAutoCommit(false);

                statement1.executeUpdate("UPDATE Stavka \n" +
                        "SET CijenaPoKomadu = CijenaPoKomadu + 10\n" +
                        "WHERE IDStavka = 8");

                statement2.executeUpdate("UPDATE Stavka \n" +
                        "SET CijenaPoKomadu = CijenaPoKomadu - 10\n" +
                        "WHERE IDStavka = 9");

                connection.commit();
                System.out.println("Transakcija izvršena!");

            }  catch (SQLException e)  {
                connection.rollback();

                System.err.println("Transakcija poništena.");
                }
            }

         catch (SQLException e)  {
            System.out.println("Error connecting to database");
            e.printStackTrace();
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