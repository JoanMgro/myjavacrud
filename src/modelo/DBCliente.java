package modelo;

import java.io.Console;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import vista.MenuBicicleta;
import vista.MenuCliente;

public class DBCliente implements EcoDosRuedas{
    
    private String idProducto; //Alias
    private String nombres;
    private String apellidos;
    private String email;
    private String celular;
    private int contrasena;
    private Date fechaNacimiento;

    private Boolean esAsignado;
    private String mensajeDB;

    private ArrayList<ArrayList<String>> arrayResultadoQuery;
    private ArrayList<String> resultadoQuery;

     

    @Override
    public void ingresarProducto(BaseDeDatos unaDb){        

        try {

            String sql = "INSERT INTO clientes(id_alias, nombres, apellidos, email, celular, contrasena, fecha_nac) " + 
                         "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);
            pstmt.setString(1, idProducto);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellidos);

            pstmt.setString(4, email);
            pstmt.setString(5, celular);
            pstmt.setInt(6, contrasena);
            pstmt.setDate(7, fechaNacimiento);

       
    
            int columnasInsertadas = pstmt.executeUpdate();

            if(columnasInsertadas > 0){
                mensajeDB = "Ingreso Exitoso";}
            
        } catch (Exception e) {
            //TODO: handle excepti
            mensajeDB = "Error ingresando datos Cliente al DB";


        }

    }

    @Override
    public void eliminarProducto(BaseDeDatos unaDb){

        try {

            String sql = "DELETE FROM clientes WHERE LOWER(id_alias)=?";
            PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);
            pstmt.setString(1, idProducto.toLowerCase());
                
            int filasBorradas = pstmt.executeUpdate();

            if(filasBorradas > 0){
                mensajeDB = "Borrado Exitoso";}
            
        } catch (Exception e) {
            //TODO: handle excepti
            mensajeDB = "Error Borrando datos del DB";


        }
        
    }

    @Override
    public void actualizarProducto(BaseDeDatos unaDb){
        mensajeDB = "actualizando datos  DB";
        String sql="";

        if(!nombres.equals(""))
        {
            try {
                sql = "UPDATE clientes SET nombres=? WHERE id_alias=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

                pstmt.setString(1, nombres);
                pstmt.setString(2, idProducto);
        
                pstmt.executeUpdate();
                
                mensajeDB = "Carga exitosa";
                
            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Error modificante DB";
            }


        }


        if(!apellidos.equals(""))
        {
            try {
                sql = "UPDATE clientes SET apellidos=? WHERE id_alias=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

                pstmt.setString(1, apellidos);
                pstmt.setString(2, idProducto);
        
                pstmt.executeUpdate();
                
                mensajeDB = "Carga exitosa";
                
            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Error modificante DB";
            }


        }



        if(!email.equals(""))
        {
            try {
                sql = "UPDATE clientes SET email=? WHERE id_alias=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

                pstmt.setString(1, email);
                pstmt.setString(2, idProducto);
        
                pstmt.executeUpdate();
                
                mensajeDB = "Carga exitosa";
                
            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Error modificante DB";
            }


        }
        
           if(!celular.equals(""))
        {
            try {
                sql = "UPDATE clientes SET celular=? WHERE id_alias=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

                pstmt.setString(1, celular);
                pstmt.setString(2, idProducto);
        
                pstmt.executeUpdate();
                
                mensajeDB = "Carga exitosa";
                
            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Error modificante DB";
            }


        }
        
            if(contrasena != 0)
            {
            try {
                sql = "UPDATE clientes SET contrasena=? WHERE id_alias=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

                pstmt.setInt(1, contrasena);
                pstmt.setString(2, idProducto);
        
                pstmt.executeUpdate();
                
                mensajeDB = "Carga exitosa";
                
            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Error modificante DB";
            }


        }

        if(fechaNacimiento != null)
        {
            try {
                sql = "UPDATE clientes SET fecha_nac=? WHERE id_alias=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

                pstmt.setDate(1, fechaNacimiento);
                pstmt.setString(2, idProducto);
        
                pstmt.executeUpdate();
                
                mensajeDB = "Carga exitosa";
                
            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Error modificante DB";
            }


        }

        

        
    }

    @Override
    public void buscarProducto(BaseDeDatos unaDb){
        
        String filter ="";

        if(fechaNacimiento != null){
            filter = " WHERE fecha_nac = " + "'" + fechaNacimiento.toString() +"'";
        }
        if(contrasena != 0){
            filter = " WHERE contrasena = " + contrasena;
        }
        if(!celular.equals("")){
            filter = " WHERE celular = \"" + celular +"\"";

        }

        if(!email.equals("")){
            filter = " WHERE LOWER email = \"" + email.toLowerCase() +"\"";

        }
        if(!apellidos.equals("")){
            filter = " WHERE LOWER (apellidos) = \"" + apellidos.toLowerCase() +"\"";

        }
        if(!nombres.equals("")){
            filter = " WHERE LOWER (nombres) = \"" + nombres.toLowerCase() +"\"";

        }
        if(!idProducto.equals("")){
            filter = " WHERE LOWER (id_alias) = \"" + idProducto.toLowerCase() +"\"";

        }

        String sql = "SELECT * FROM clientes" + filter;

        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();

            

            rs = stmt.executeQuery(sql);
            
            arrayResultadoQuery = new ArrayList<>();

            int count = 0;

            while(rs.next()){
                resultadoQuery = new ArrayList<>();

                String unId =rs.getString(1);
                resultadoQuery.add(unId);
                
                String unNombre =rs.getString(2);
                resultadoQuery.add(unNombre);
                
                String unApellido =rs.getString(3);
                resultadoQuery.add(unApellido);

                String unEmail =rs.getString(4);
                resultadoQuery.add(unEmail);
                String unCelu =rs.getString(5);
                resultadoQuery.add(unCelu);
                
                String unaContra =String.valueOf(rs.getInt(6));
                resultadoQuery.add(unaContra);

                String unaFecha =String.valueOf(rs.getDate(7));
                resultadoQuery.add(unaFecha);
                
                
                arrayResultadoQuery.add(resultadoQuery);
                
                
            }

            mensajeDB = "Carga exitosa";

            
        } catch (Exception e) {
            //TODO: handle exception
            mensajeDB = "Error Cargando datos del DB";
        }   




  
    }

    public Boolean getEsAsignado(){
        return this.esAsignado;
    }


    public String getMsg(){
        return  this.mensajeDB;
    }



    public ArrayList<ArrayList<String>> getArrayList(){
        return this.arrayResultadoQuery;

    }


    //SETTER

    public void setProductoIngresar(MenuCliente unProducto){
        try {
            
            this.idProducto = unProducto.getIdProducto();
            this.nombres = unProducto.getNombres();
            this.apellidos = unProducto.getApellidos();
            this.email = unProducto.getEmail();
            this.celular = unProducto.getCelular();
            if(unProducto.getContrasena().equals(""))
            {
                this.contrasena = 0;

            }
            else
            {
                this.contrasena = Integer.parseInt(unProducto.getContrasena());
            }
            
            if(!unProducto.getFechaNacimiento().equals(""))
            {
                this.fechaNacimiento = Date.valueOf(unProducto.getFechaNacimiento());
            }
            else{

                this.fechaNacimiento = null;

            }
            


            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }

    }

    public void setIdProducto(String unId){

        try {
            this.idProducto = unId;  
            esAsignado = true;          
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de dato ingresado.";
        }
       
    }

    public void setProductoEliminar(String unId){

        try {
            this.idProducto = unId;  
            esAsignado = true;          
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de dato ingresado.";
        }
       
    }   
    
    public void setProductoActualizar(MenuCliente unProducto){

        try {
            
            this.idProducto = unProducto.getIdProducto();

            this.nombres = unProducto.getNombres();
            this.apellidos = unProducto.getApellidos();
            this.email = unProducto.getEmail();
            this.celular = unProducto.getCelular();
            if(unProducto.getContrasena().equals(""))
            {
                this.contrasena = 0;

            }
            else
            {
                this.contrasena = Integer.parseInt(unProducto.getContrasena());
            }
            
            if(!unProducto.getFechaNacimiento().equals(""))
            {
                this.fechaNacimiento = Date.valueOf(unProducto.getFechaNacimiento());
            }
            else{

                this.fechaNacimiento = null;

            }
            


            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }

    }

    public void setProductoBuscar(MenuCliente unProducto){

        try {
            
            this.idProducto = unProducto.getIdProducto();

            this.nombres = unProducto.getNombres();
            this.apellidos = unProducto.getApellidos();
            this.email = unProducto.getEmail();
            this.celular = unProducto.getCelular();
            if(unProducto.getContrasena().equals(""))
            {
                this.contrasena = 0;

            }
            else
            {
                this.contrasena = Integer.parseInt(unProducto.getContrasena());
            }
            
            if(!unProducto.getFechaNacimiento().equals(""))
            {
                this.fechaNacimiento = Date.valueOf(unProducto.getFechaNacimiento());
            }
            else{

                this.fechaNacimiento = null;

            }
            


            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }

    }

    public void setCampos(String unId, String unNombre, String unApellido, String unEmail, String unCel, int unaContrasena, Date unaFecha){
        this.idProducto = unId;
        this.nombres = unNombre;
        this.apellidos =unApellido;
        this.email = unEmail;
        this.celular = unCel;
        this.contrasena = unaContrasena;
        this.fechaNacimiento = unaFecha;
    }

        
}
