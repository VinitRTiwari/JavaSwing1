
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaDB {
    public static void main(String[] args) {
        String user = "root";
        String pass = "root";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/readers_haven",user,pass);
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String query = "select _name from user where _userid = 101;";
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                
                String val = rs.getString(1);
                
                System.out.println(val);
                
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){

        }
    }
}
