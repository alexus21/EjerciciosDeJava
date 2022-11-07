package store;

import java.sql.*;

public class DeleteData {

    public static void DeleteFromDB(String selectedID){
        Connection connection = CreateConnection.getDbConnection();
        String myQuery = "DELETE FROM tbl_providers WHERE idprovider = '"+selectedID+"'";

        try {
            PreparedStatement statement = connection.prepareStatement(myQuery);

            if(statement.executeUpdate() > 0){
                System.out.println("Dato eliminado correctamente");
            }else{
                System.out.println("Error en la eliminacion");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
