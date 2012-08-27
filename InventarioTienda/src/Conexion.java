import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    public static Connection obtenerConexion(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection("jdbc:mysql://localhost/tienda?user=root&password=root");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        return conn;
    }
    
    
   
}
