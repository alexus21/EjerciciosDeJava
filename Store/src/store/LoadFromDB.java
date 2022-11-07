package store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadFromDB {

    public static ResultSet LoadContent(){

        Connection conn = CreateConnection.getDbConnection();
        ResultSet tableContent = null;
        Statement st = null;
        String query = "SELECT tbl_product.*, tbl_providers.providername" +
                "FROM tbl_providers " +
                "INNER JOIN tbl_product ON tbl_providers.idprovider = tbl_product.idprovider;";

        try {
            st = conn.createStatement();
            tableContent = st.executeQuery(query);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return tableContent;
    }

}
