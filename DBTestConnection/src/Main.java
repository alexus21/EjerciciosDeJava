import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //System.out.println("Hello world!");

        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_productos", "postgres", "heil hitler");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM db_productos.tbl_productos");

            while(rs.next()){
                System.out.println("Column: ");
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
