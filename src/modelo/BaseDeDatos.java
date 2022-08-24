package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BaseDeDatos {

    private Connection conn;
    private String url;
    private String estadoConn;
    private String nombreUsuario;
    private String password;

    

    public BaseDeDatos(){
        conn = null;
        url = "jdbc:mysql://localhost:3306/ecodosruedas";
    }










    public void conectarDB(String unUsuario, String unPassword){

        setNombreUsuario(unUsuario);
        setPassword(unPassword);

        try {
            conn = DriverManager.getConnection(url, nombreUsuario, password);
            
            if(conn != null) {
                estadoConn = "Conectado";
                         
            }
                    
        } 
        catch (SQLException ex) {
            //ex.printStackTrace();
            estadoConn = "Error al ingresar datos";
        }

    }

    public void desconectasDB(){

        try {
            
            if(conn != null) {conn.close();}
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //GETTER
    public String getEstadoCon(){
        return this.estadoConn;
    }

    public String getNombreUsuario(){
        return this.nombreUsuario;
    }

    public String getPassword(){
        return this.password;
    }

    public Connection getConnection(){
        return this.conn;
    }

    //SETTER
    public void setNombreUsuario(String unUsuario){
        this.nombreUsuario = unUsuario;
    }

    public void setPassword(String unPassword){
        this.password = unPassword;
    }
    
}
