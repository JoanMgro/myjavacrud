package modelo;


import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
 
import vista.MenuBicicleta;

import java.util.ArrayList;

public class DBBicicleta implements EcoDosRuedas {
    
    private int idProducto;
    private DBFabricantes fabricante;
    private int precio;
    private int anio;
    private Boolean esAsignado;
    private String mensajeDB;

    private ArrayList<ArrayList<String>> arrayResultadoQuery;
    private ArrayList<String> resultadoQuery;

 

    
   
    @Override
    public void ingresarProducto(BaseDeDatos unaDb){

        fabricante.ingresarProducto(unaDb); 
            

        try {

            String sql = "INSERT INTO bicicletas(id_bici, fabricante, precio, anio) VALUES (?,?,?,?)";
            PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

            pstmt.setInt(1, idProducto);
            pstmt.setString(2, fabricante.getIdProducto());
            pstmt.setInt(3, precio);
            pstmt.setInt(4, anio);
    
            int columnasInsertadas = pstmt.executeUpdate();

            if(columnasInsertadas > 0){
                mensajeDB = "Ingreso Exitoso";}
            
        } catch (Exception e) {
            //TODO: handle excepti
            mensajeDB = "Error ingresando datos al DB";


        }



    }

    @Override
    public void eliminarProducto(BaseDeDatos unaDb){
    

        try {

            String sql = "DELETE FROM bicicletas WHERE id_bici=?";
            PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);
            pstmt.setInt(1, idProducto);
                
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
        
        
        if(!fabricante.getIdProducto().equals(""))      
        {
            fabricante.actualizarProducto(unaDb);

            try {

                String sql = "UPDATE bicicletas SET fabricante=?  WHERE id_bici=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setString(1, fabricante.getIdProducto());
                pstmt.setInt(2, idProducto);            
                pstmt.executeUpdate();

                mensajeDB = "Update exitoso";

            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Updagte no Exitoso Fabricante";
            }
 





        }

        if(precio != 0){


            try {

                String sql = "UPDATE bicicletas SET precio=?  WHERE id_bici=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setInt(1, precio);
                pstmt.setInt(2, idProducto);            
                pstmt.executeUpdate();

                mensajeDB = "Ingreso Exitoso";

            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Ingreso no Exitoso precio";
            }
 
        }

        if(anio != 0){
            try {
                String sql = "UPDATE bicicletas SET anio=?  WHERE id_bici=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setInt(1, anio);
                pstmt.setInt(2, idProducto);            
                pstmt.executeUpdate();

                mensajeDB = "Ingreso Exitoso";
            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Ingreso no Exitoso año";
            }
                  
        }
            
     
    }

    @Override
    public void buscarProducto(BaseDeDatos unaDb){
        
        String filter ="";

        if(anio != 0){
            filter = " WHERE anio >= " + anio;
        }
        if(precio != 0){
            filter = " WHERE precio >= " + precio;
        }
        if(!fabricante.getIdProducto().equals("")){

            filter = " WHERE LOWER(fabricante) = \"" + fabricante.getIdProducto().toLowerCase() +"\"";

        }
        if(idProducto != 0){
            filter = " WHERE id_bici = " + idProducto;}
        
       
    
        String sql = "SELECT * FROM bicicletas" + filter;



        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();

            

            rs = stmt.executeQuery(sql);
            
            
            arrayResultadoQuery = new ArrayList<>();

            int count = 0;

            while(rs.next()){

                resultadoQuery = new ArrayList<>();

                String unId = String.valueOf(rs.getInt(1));
                resultadoQuery.add(unId);
                
                String unfabricante = rs.getString(2);
                resultadoQuery.add(unfabricante);
                
                String unPrecio = String.valueOf(rs.getInt(3));
                resultadoQuery.add(unPrecio);
                
                String unAnio = String.valueOf(rs.getInt(4));
                resultadoQuery.add(unAnio);
                
                
                arrayResultadoQuery.add(resultadoQuery);
                
                count++;
                
            }
            if(count > 0){ mensajeDB = "Carga exitosa";}
           

            
        } catch (Exception e) {
            //TODO: handle exception
            mensajeDB = "Error Cargando datos del DB";
        }   



        
    }


    public Boolean getEsAsignado(){
        return this.esAsignado;
    }

//ALISTAR DATOS PARA OPERACION EN BD
    public void setProductoBuscar(MenuBicicleta unProducto){

        try {

            if(unProducto.getIdProducto().equals(""))
            {
                this.idProducto = 0;
            }
            else{                
              this.idProducto = Integer.parseInt(unProducto.getIdProducto());

            }              
            
            //Llamar al manejador de fabricante---------------------
            this.fabricante = new DBFabricantes();
            this.fabricante.setProductoBuscar(unProducto.getFabricante());
             //-------------------------------------------------------

            if(unProducto.getPrecio().equals(""))
            {
                this.precio = 0;
            }
            else{
                this.precio = Integer.parseInt(unProducto.getPrecio());

            }


            if(unProducto.getAnio().equals(""))
            {
                this.anio = 0;
            }
            else{
                this.anio = Integer.parseInt(unProducto.getPrecio());

            }

            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }


    }

    public void setProductoActualizar(MenuBicicleta unProducto){

        try {
            
            this.idProducto = Integer.parseInt(unProducto.getIdProducto());
             
            //Llamar al manejador de fabricante---------------------
            this.fabricante = new DBFabricantes();
            this.fabricante.setProductoActualizar(unProducto.getFabricante());
            //-------------------------------------------------------
           
            if(unProducto.getPrecio().equals(""))
            {
                this.precio = 0;
            }
            else{
                this.precio = Integer.parseInt(unProducto.getPrecio());

            }

            if(unProducto.getAnio().equals(""))
            {
                this.anio = 0;
            }
            else{
                
                this.anio = Integer.parseInt(unProducto.getAnio());

            }

            esAsignado = true;
            mensajeDB = "Datos preparados ok";
            
            
        } catch (Exception e) {
            
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }

    }
    
    public void setProductoIngresar(MenuBicicleta unProducto){//Prepara productos para ingresar datos
        try {

            this.idProducto = Integer.parseInt(unProducto.getIdProducto());
            //Llamar al manejador de fabricante---------------------
            this.fabricante = new DBFabricantes();
            this.fabricante.setProductoIngresar(unProducto.getFabricante());
            //-------------------------------------------------------
           
            this.precio = Integer.parseInt(unProducto.getPrecio());
            this.anio = Integer.parseInt(unProducto.getAnio());
            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error al ingresar los datos.";
        }

    }
    
    public void setProductoEliminar(String unId){

        try {
            this.idProducto = Integer.parseInt(unId);  
            esAsignado = true;          
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de dato ingresado.";
        }
       
    }   
   
 //SETTER


    




    //getter

    public String getMsg(){
        return  this.mensajeDB;
    }

    public int getIdProducto(){
        return this.idProducto;
    }

    public int getPrecio(){
        return this.precio;
    }

    public DBFabricantes getFabricante(){
        return this.fabricante;
    }


    public ArrayList<ArrayList<String>> getArrayList(){
        return this.arrayResultadoQuery;

    }






    
}
