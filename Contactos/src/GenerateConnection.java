import javax.swing.*;
import java.sql.*;

public class GenerateConnection {

    String dbConnectionURL = "jdbc:postgresql://localhost:5432/db_contacts";
    String username = "postgres";
    String password = "heil hitler";

    Connection connection;

    public Connection generateConnection(){
        try {
            connection = DriverManager.getConnection(dbConnectionURL, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT VERSION()");

            System.out.println("Successfully connected.");

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return connection;
    }

}
