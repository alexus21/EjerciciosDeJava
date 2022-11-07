package store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

    public static void UpdateValues(String providerid, String productName, float productPrice, String providerName){

        Connection conn = CreateConnection.getDbConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(""
                    + "UPDATE tbl_providers SET providerName = '"+providerName+"';"
                    + "UPDATE tbl_product SET productname = '"+productName+"', price = '"+productPrice+"'" +
                    "WHERE providerid = '"+providerid+"'"
            );

            if(statement.executeUpdate() > 0){
                System.out.println("Datos actualizados");
            }else{
                System.out.println("Error al guardar los datos");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

}
