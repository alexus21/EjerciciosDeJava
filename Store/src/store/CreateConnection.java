package store;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alexu
 */

public class CreateConnection {

    private static Connection dbConnection = null;
    private static final String connectionString = "jdbc:postgresql://localhost:5432/db_store";
    private static final String username = "postgres";
    private static final String password = "heil hitler";

    public static Connection getDbConnection(){

        try {
            dbConnection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("Connected to DB");
        } catch (SQLException e) {
            System.out.println("Error on connection: " + e);
        }
        return dbConnection;
    }

}
