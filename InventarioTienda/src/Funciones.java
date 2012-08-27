
import java.security.MessageDigest;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Funciones{
   Connection conn;
   ResultSet rs;
   Statement stmt;
   //Esta Funcion convierte el formato total de fecha en formato aa-mm-dd para guardar en MySQL
    public String convertirFecha(String fecha){//Válido para JXDataPicker
        /*Se manda a llamar de esta manera
        fecha=jdpFecha.getDate().toString().substring(4, 10).concat(" "+jdpFecha.getDate().toString().substring(24, 28));
        fecha=Funciones.convertirFecha(fecha);
        donde jdpFecha es el objeto JXDataPicker
        */
        String mes,dia,anio;
        mes=fecha.substring(0, 3);
        dia=fecha.substring(4, 6);
        anio=fecha.substring(7, 11);
        if(mes.equals("Jan")){
            mes="01";
        }
        if(mes.equals("Feb")){
            mes="02";
        }
        if(mes.equals("Mar")){
            mes="03";
        }
        if(mes.equals("Apr")){
            mes="04";
        }
        if(mes.equals("May")){
            mes="05";
        }
        if(mes.equals("Jun")){
            mes="06";
        }
        if(mes.equals("Jul")){
            mes="07";
        }
        if(mes.equals("Aug")){
            mes="08";
        }
        if(mes.equals("Sep")){
            mes="09";
        }
        if(mes.equals("Oct")){
            mes="10";
        }
        if(mes.equals("Nov")){
            mes="11";
        }
        if(mes.equals("Dec")){
            mes="12";
        }
        fecha=anio+"-"+mes+"-"+dia;
        return fecha;
    }
  
    public void insertar(String sql){
        conn=Conexion.obtenerConexion();
        try {
            stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+ex);
        }
   
    }
    
    public ResultSet buscar(String sql){
        conn=Conexion.obtenerConexion();
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar: "+ex);
        }
        return rs;
    }
 
    public void cerrarConexion(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String md5(String clear) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b =  md.digest(clear.getBytes());
        
        int size=b.length;
        StringBuilder h= new StringBuilder(size);
        for(int i=0; i < size; i++){
            int u= b[i]&255;
            if(u<16){
                h.append("0").append(Integer.toHexString(u));      
            } else {
                h.append(Integer.toHexString(u));
            }       
        }
        return h.toString();
    }
    
}
