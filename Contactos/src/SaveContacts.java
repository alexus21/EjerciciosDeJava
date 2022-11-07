import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveContacts {

    static GenerateConnection genConnection = new GenerateConnection();

    public static void SaveData(int id, String name, String phone, String relationship) throws SQLException {
        Connection myConnection = genConnection.generateConnection();
        Statement st = myConnection.createStatement();
        ResultSet rs = st.executeQuery("INSERT INTO tbl_contactList(" +
                "contactID, " +
                "contactName, " +
                "contactPhone, " +
                "contactRelationship) VALUES(" +
                "'"+id+"', " +
                "'"+name+"', " +
                "'"+phone+"', " +
                "'"+relationship+"')");
    }
}
