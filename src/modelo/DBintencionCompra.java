package modelo;


import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Timestamp;
import java.util.ArrayList;

import vista.MenuBicicleta;
import vista.MenuIntencionCompra;

public class DBintencionCompra implements EcoDosRuedas {

    private int idProducto; 
    private String alias;
    private DBFabricantes fabricante;
    
    private Timestamp fechaHora;

    private Boolean esAsignado;
    private String mensajeDB;

    private ArrayList<ArrayList<String>> arrayResultadoQuery;
    private ArrayList<String> resultadoQuery;

     
   

    @Override
    public void ingresarProducto(BaseDeDatos unaDb){

        fabricante.ingresarProducto(unaDb);
        actualizarCliente(unaDb);
        validarId(unaDb);

   
        try {

            String sql = "INSERT INTO intencion(id_intencion, alias, fabricante, fecha_hora) VALUES (?,?,?,?)";
            PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);

            pstmt.setInt(1, idProducto);
            pstmt.setString(2, alias);
            pstmt.setString(3, fabricante.getIdProducto());
            pstmt.setTimestamp(4, fechaHora);
                           
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

            String sql = "DELETE FROM intencion WHERE id_intencion=?";
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
        mensajeDB = "actualizando datos  DB";

        if(!fabricante.getIdProducto().equals(""))      
        {
            fabricante.actualizarProducto(unaDb);

            try {

                String sql = "UPDATE intencion SET fabricante=?  WHERE id_intencion=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setString(1, fabricante.getIdProducto());
                pstmt.setInt(2, idProducto);            
                pstmt.executeUpdate();

                mensajeDB = "Update exitoso";

            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Update no Exitoso Fabricante";
            }
 





        }

        if(!alias.equals("")){
            actualizarCliente(unaDb);
            try {

                String sql = "UPDATE intencion SET alias=?  WHERE id_intencion=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setString(1, alias);
                pstmt.setInt(2, idProducto);            
                pstmt.executeUpdate();

                mensajeDB = "Ingreso Exitoso";

            } catch (Exception e) {
                //TODO: handle exception
                mensajeDB = "Ingreso no Exitoso precio";
            }
 
        }

        if(fechaHora != null){
            try {
                String sql = "UPDATE intencion SET fecha_hora=?  WHERE id_intencion=?";
                PreparedStatement pstmt = unaDb.getConnection().prepareStatement(sql);    
                pstmt.setTimestamp(1, fechaHora);
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

        if(fechaHora != null){
            filter = " WHERE fecha_hora = " + "'" + fechaHora.toString() +"'";
        }
       
        if(!fabricante.getIdProducto().equals("")){
            filter = " WHERE LOWER (fabricante) = \"" + fabricante.getIdProducto().toLowerCase() +"\"";

        }
        if(!alias.equals("")){
            filter = " WHERE LOWER (alias) = \"" + alias.toLowerCase() +"\"";

        }

        if(idProducto != 0){
            filter = " WHERE LOWER (id_intencion) = \"" + idProducto +"\"";

        }

        String sql = "SELECT * FROM intencion" + filter;

        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();

            

            rs = stmt.executeQuery(sql);
            
            arrayResultadoQuery = new ArrayList<>();

            int count = 0;

            while(rs.next()){
                resultadoQuery = new ArrayList<>();

                String unId =String.valueOf(rs.getInt(1));
                resultadoQuery.add(unId);
                
                String unAlias =rs.getString(2);
                resultadoQuery.add(unAlias);
                
                String unFab =rs.getString(3);
                resultadoQuery.add(unFab);

                String unaFechaHora =String.valueOf(rs.getTimestamp(4));
                resultadoQuery.add(unaFechaHora);
                
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

    public void setProductoIngresar(MenuIntencionCompra unProducto){
        try {
            
            this.idProducto = Integer.parseInt(unProducto.getIdProducto());

            this.alias = unProducto.getAlias();

                      

            //Llamar al manejador de fabricante---------------------
            this.fabricante = new DBFabricantes();
            this.fabricante.setProductoIngresar(unProducto.getFabricante());
            //-------------------------------------------------------

           
            if(unProducto.getFechaHora().equals("")){
                this.fechaHora = null;
            }
            else{
                this.fechaHora = Timestamp.valueOf(unProducto.getFechaHora());
            }
            
 
            
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

    public void setProductoActualizar(MenuIntencionCompra unProducto){
       
        try {
            
            this.idProducto = Integer.parseInt(unProducto.getIdProducto());



            this.alias = unProducto.getAlias();


            //Llamar al manejador de fabricante---------------------
            this.fabricante = new DBFabricantes();
            this.fabricante.setProductoActualizar(unProducto.getFabricante());
            //-------------------------------------------------------
                       

            if(!unProducto.getFechaHora().equals(""))
            {
                this.fechaHora = Timestamp.valueOf(unProducto.getFechaHora());
            }
            else{
                this.fechaHora = null;

            }

           
            esAsignado = true;
            mensajeDB = "Datos preparados ok";
            
            
        } catch (Exception e) {
            
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }

    }

    public void setProductoBuscar(MenuIntencionCompra unProducto){


        try {

            if(!unProducto.getIdProducto().equals("")) 
            {
                this.idProducto = Integer.parseInt(unProducto.getIdProducto());
            }  
            else{
                this.idProducto = 0;
            }        
           



            this.alias = unProducto.getAlias();


            //Llamar al manejador de fabricante---------------------
            this.fabricante = new DBFabricantes();
            this.fabricante.setProductoBuscar(unProducto.getFabricante());
            //-------------------------------------------------------

            
                         

            if(!unProducto.getFechaHora().equals(""))
            {
                this.fechaHora = Timestamp.valueOf(unProducto.getFechaHora());
            }
            else{
                this.fechaHora = null;

            }

           
            esAsignado = true;
            mensajeDB = "Datos preparados ok";
            
            
        } catch (Exception e) {
            
            esAsignado = false;
            mensajeDB = "Hubo un error en el tipo de datos ingresados.";
        }


    }


    public void actualizarCliente(BaseDeDatos unaDb){
        DBCliente unCliente = new DBCliente();
        unCliente.setCampos(alias,"", "", "", "", 0, null);
        unCliente.buscarProducto(unaDb);
            if(unCliente.getArrayList().size() == 0)
            {
               unCliente.setCampos(alias,"unknown", "unknown", "unknown", "unknown", 0, null);
               unCliente.ingresarProducto(unaDb);
            }
            else{
                alias = unCliente.getArrayList().get(0).get(0);
            }


    }

   public void validarId(BaseDeDatos unaDb){
    

        String sql = "SELECT id_intencion FROM intencion";

        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){

                if(idProducto == rs.getInt(1)){
                    idProducto++;
                }                 
                
            }
  
           
        } catch (Exception e) {
            //TODO: handle exception
            mensajeDB = "Error consulta id";
        }   


   }

   



}