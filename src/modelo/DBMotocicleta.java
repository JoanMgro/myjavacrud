package modelo;

import java.util.ArrayList;


import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import vista.MenuBicicleta;
import vista.MenuMotocicleta;

public class DBMotocicleta implements EcoDosRuedas {

    private int idProducto;
    private DBFabricantes fabricante;
    private int precio;
    private String autonomia;
    private DBProveedorMotor proveedorMotor;
    private Boolean esAsignado;
    private String mensajeDB;

    private ArrayList<ArrayList<String>> arrayResultadoQuery;
    private ArrayList<String> resultadoQuery;


    @Override
    public void ingresarProducto(BaseDeDatos unaDb){

        //mensajeDB = "Ingresando datos al DB";

        proveedorMotor.ingresarProducto(unaDb); 
        fabricante.ingresarProducto(unaDb);    


        try { 

            String sql = "INSERT INTO motocicletas_electricas(id_moto, fabricante, precio, autonomia, prov_motor)" + 
            " VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);
            pstmt.setInt(1, idProducto);
            pstmt.setString(2, fabricante.getIdProducto());
            pstmt.setInt(3, precio);
            pstmt.setString(4, autonomia);
            pstmt.setString(5, proveedorMotor.getIdProducto());
    
            
            int columnasInsertadas = pstmt.executeUpdate();

            if(columnasInsertadas > 0){
                mensajeDB = "Ingreso Exitoso";}
            
        } catch (Exception e) {
            //TODO: handle excepti
            mensajeDB = "Error ingresando datos Proveedor al DB";


        }
    


    }

    @Override
    public void eliminarProducto(BaseDeDatos unaDb){

        mensajeDB = "Eliminando datos  DB";
        try {

            String sql = "DELETE FROM motocicletas_electricas WHERE id_moto=?";
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

                String sql = "UPDATE motocicletas_electricas SET fabricante=?  WHERE id_moto=?";
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

        if(!proveedorMotor.getIdProducto().equals(""))      
        {
            proveedorMotor.actualizarProducto(unaDb);

            try {

                String sql = "UPDATE motocicletas_electricas SET prov_motor=?  WHERE id_moto=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setString(1, proveedorMotor.getIdProducto());
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

                String sql = "UPDATE motocicletas_electricas SET precio=?  WHERE id_moto=?";
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

        if(!autonomia.equals("")){


            try {

                String sql = "UPDATE motocicletas_electricas SET autonomia=?  WHERE id_moto=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setString(1, autonomia);
                pstmt.setInt(2, idProducto);            
                pstmt.executeUpdate();

                mensajeDB = "Ingreso Exitoso";

            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Ingreso no Exitoso precio";
            }
 
        }
 
        
    }

    @Override
    public void buscarProducto(BaseDeDatos unaDb){

        String filter ="";

        if(!autonomia.equals("")){
            filter = " WHERE autonomia = \"" + autonomia +"\"";
        }
        if(precio != 0){
            filter = " WHERE precio >= " + precio;
        }

        if(!fabricante.getIdProducto().equals("")){

            filter = " WHERE LOWER(fabricante) = \"" + fabricante.getIdProducto().toLowerCase() +"\"";
        }

        if(!proveedorMotor.getIdProducto().equals("")){

            filter = " WHERE LOWER(prov_motor) = \"" + proveedorMotor.getIdProducto().toLowerCase() +"\"";

        }

        if(idProducto != 0){
            filter = " WHERE id_moto = " + idProducto;}
        
       
    
        String sql = "SELECT * FROM motocicletas_electricas" + filter;



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
                
                String unAutonomia = rs.getString(4);
                resultadoQuery.add(unAutonomia);

                String unProveedor = rs.getString(5);
                resultadoQuery.add(unProveedor);
                
                
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
    public String getMsg(){
        return  this.mensajeDB;
    }

    public ArrayList<ArrayList<String>> getArrayList(){
        return this.arrayResultadoQuery;

    }



    //SETTER

    //ALISTAR DATOS PARA OPERACION EN BD

    public void setProductoIngresar(MenuMotocicleta unProducto){

        try {
            
            this.idProducto = Integer.parseInt(unProducto.getIdProducto());

            //Llamar al manejador de proovedor motor---------------
            this.fabricante = new DBFabricantes();
            this.fabricante.setProductoIngresar(unProducto.getFabricante());
            //-------------------------------------------------------

            this.precio = Integer.parseInt(unProducto.getPrecio());
            this.autonomia = unProducto.getAutonomia();

            //Llamar al manejador de proovedor motor
            this.proveedorMotor = new DBProveedorMotor();
            this.proveedorMotor.setProductoIngresar(unProducto.getProveedor());
            
            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
            
        }

    }

    public void setProductoBuscar(MenuMotocicleta unProducto){

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


            this.autonomia = unProducto.getAutonomia();

            

            //Llamar al manejador de proveedor motor---------------------
            this.proveedorMotor = new DBProveedorMotor();
            this.proveedorMotor.setProductoBuscar(unProducto.getProveedor());
             //-------------------------------------------------------

            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
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
    
    public void setProductoActualizar(MenuMotocicleta unProducto){

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
            
           
                this.autonomia = unProducto.getAutonomia();

            
                

            

            //Llamar al manejador de proveedor motor---------------------
            this.proveedorMotor = new DBProveedorMotor();
            this.proveedorMotor.setProductoBuscar(unProducto.getProveedor());
             //-------------------------------------------------------

            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }


    }

}
