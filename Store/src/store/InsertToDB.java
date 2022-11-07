package store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertToDB {

    public static void InsertValues(String productName, float productPrice, String providerName){
        
        Connection conn = CreateConnection.getDbConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(""
                    + "INSERT INTO tbl_providers(providername) VALUES(?);"
                    + "INSERT INTO tbl_product(productname, price) VALUES(?, ?)"
            );
            statement.setString(1, providerName);
            statement.setString(2, productName);
            statement.setFloat(3, productPrice);
            
            if(statement.executeUpdate() > 0){
                System.out.println("Datos guardados");
            }else{
                System.out.println("Error al guardar los datos");
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
