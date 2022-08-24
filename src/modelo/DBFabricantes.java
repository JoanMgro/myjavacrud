package modelo;


import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import vista.MenuFabricante;
 
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBFabricantes implements EcoDosRuedas{

    private String idProducto;


    private Boolean esAsignado;
    private String mensajeDB;

    private ArrayList<ArrayList<String>> arrayResultadoQuery;
    private ArrayList<String> resultadoQuery;




    @Override
    public void ingresarProducto(BaseDeDatos unaDb){

        //mensajeDB = "Ingresando datos al DB";

        //Buscamos para evitar erro de Duplicidad;
        
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

                String sql = "INSERT INTO fabricantes(id_fabricante) VALUES (?)";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);
                pstmt.setString(1, idProducto);
    
        
                pstmt.executeUpdate();
                
            } catch (Exception e) {
                //TODO: handle excepti
                mensajeDB = "Error ingresando datos Fabricantes al DB";
    
    
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

        mensajeDB = "buscando datos  DB";

        String filter ="";

        if(!idProducto.equals("")){
            filter = " WHERE LOWER(id_fabricante) = \"" + idProducto.toLowerCase() + "\"";

        }      
    
        String sql = "SELECT * FROM fabricantes" + filter;


        
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

     
   
   
   
    public Boolean getEsAsignado(){
        return this.esAsignado;
    }
    public String getMsg(){
        return  this.mensajeDB;

    
    }

    public String getIdProducto(){
        return this.idProducto;
       }


    //SETTER


    //

    public void setProductoIngresar(MenuFabricante unProducto){

        try {
            
            this.idProducto = unProducto.getIdProducto();
          
            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception 
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
            
        }
        
    }

    public void setProductoBuscar(MenuFabricante unProducto){

        try {
            
            this.idProducto = unProducto.getIdProducto();
          
            esAsignado = true;
            
            
        } catch (Exception e) {
            //TODO: handle exception 
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
            
        }

        
    }
  
    public void setProductoActualizar(MenuFabricante unProducto){

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
