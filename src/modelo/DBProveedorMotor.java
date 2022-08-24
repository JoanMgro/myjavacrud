package modelo;

import java.util.ArrayList;

import vista.MenuProovedorMotor;


import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBProveedorMotor implements EcoDosRuedas{

    private String idProducto;
    private String direccion;
    private String telefono;


    private Boolean esAsignado;
    private String mensajeDB;

    private ArrayList<ArrayList<String>> arrayResultadoQuery;
    private ArrayList<String> resultadoQuery;


    @Override
    public void ingresarProducto(BaseDeDatos unaDb){

        //mensajeDB = "Ingresando datos al DB";

        buscarProducto(unaDb);

        if(arrayResultadoQuery.size() != 0)
        {
            System.out.println(arrayResultadoQuery.get(0));
        }
        else {
            System.out.println("nada");
        }

        if(!idProducto.toLowerCase().equals(arrayResultadoQuery.get(0).get(0).toLowerCase())){

            try { 

                String sql = "INSERT INTO prov_motores(id_prov_motor, direccion, telefono) VALUES (?,?,?)";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);
                pstmt.setString(1, idProducto);
                pstmt.setString(2, direccion);
                pstmt.setString(3, telefono);
        
                pstmt.executeUpdate();
                
            } catch (Exception e) {
                //TODO: handle excepti
                mensajeDB = "Error ingresando datos Proveedr al DB";
    
    
            }

        }
          
    }

    @Override
    public void eliminarProducto(BaseDeDatos unaDb){

        mensajeDB = "Eliminando datos  DB";
        
    }

    @Override
    public void actualizarProducto(BaseDeDatos unaDb){
        ingresarProducto(unaDb); //Inserta si no esta.

        
    }

    @Override
    public void buscarProducto(BaseDeDatos unaDb){
      
        String filter ="";

        if(!idProducto.equals("")){
            filter = " WHERE LOWER(id_prov_motor) = \"" + idProducto.toLowerCase() + "\"";

        }      
    
        String sql = "SELECT * FROM prov_motores" + filter;


        
        try {

            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();           

            rs = stmt.executeQuery(sql);
            
            //Inicializamos el Arreglo para meter el arreglo que guarda los resultados
            arrayResultadoQuery = new ArrayList<>();

            int count = 0;

            while(rs.next()){
                //Inicializamos el arreglo los resultados
                resultadoQuery = new ArrayList<>();                
                String unId = rs.getString(1);
                resultadoQuery.add(unId);
                                
                arrayResultadoQuery.add(resultadoQuery);
                
                count ++;
                
            }
            
            if(count > 0){mensajeDB = "Carga exitosa";}
            else{
                resultadoQuery = new ArrayList<>();
                resultadoQuery.add("No hay resultado");
                arrayResultadoQuery.add(resultadoQuery);
            }
 

            
        } catch (Exception e) {
            //TODO: handle exception
            mensajeDB = "Error Cargando datos del DB";
        }   


        
    }

     
   
   public String getIdProducto(){
    return this.idProducto;
   }
   
    public Boolean getEsAsignado(){
        return this.esAsignado;
    }
    public String getMsg(){
        return  this.mensajeDB;
    }


    //SETTER


    //

    public void setProductoIngresar(MenuProovedorMotor unProducto){

        try {
            
            this.idProducto = unProducto.getIdProducto();
            this.direccion = unProducto.getDireccion();
            this.telefono =  unProducto.getTelefono();            
            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception 
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
            
        }

    }

    public void setProductoBuscar(MenuProovedorMotor unProducto){

        try {
            
            this.idProducto = unProducto.getIdProducto();
          
            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception 
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
            
        }

        
    }

    public void setProductoActualizar(MenuProovedorMotor unProducto){

        try {
            
            this.idProducto = unProducto.getIdProducto();
          
            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception 
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
            
        }

        
    }
}
