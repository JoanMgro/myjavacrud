package modelo;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetoCuatro {

    


    public static void queryUno(BaseDeDatos unaDb){  
        
        
    
        String sql = "UPDATE bicicletas SET anio=? WHERE fabricante=?";
        try {
            PreparedStatement pstmt = null;
            //ResultSet  rs = null;
            
         
            pstmt = unaDb.getConnection().prepareStatement(sql); 
            pstmt.setInt(1, 2017);
            pstmt.setString(2, "Cannondale");  

            pstmt.executeUpdate();

            Console c = System.console();
            System.out.println();
            clearScreen();            
            System.out.println("Año cambiado");
            System.out.println("Enter para continuar");
            c.readLine();
            
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }

       


        
    }


    public static void queryDos(BaseDeDatos unaDb){

        String sql = "UPDATE clientes SET celular=? WHERE id_alias=?";
        try {
            PreparedStatement pstmt = null;
            //ResultSet  rs = null;
            
         
            pstmt = unaDb.getConnection().prepareStatement(sql); 
            pstmt.setString(1, "3115678432");
            pstmt.setString(2, "ninja");  

            pstmt.executeUpdate();

            Console c = System.console();
            System.out.println();
            clearScreen();            
            System.out.println("Telefono Cambiado");
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }

       
        
    }
    

    public static void queryTres(BaseDeDatos unaDb){

        String sql = "DELETE FROM intencion WHERE alias=? AND fabricante=?";
        try {
            PreparedStatement pstmt = null;
            //ResultSet  rs = null;
            
         
            pstmt = unaDb.getConnection().prepareStatement(sql); 
            pstmt.setString(1, "green");
            pstmt.setString(2, "Trek"); 
             

            pstmt.executeUpdate();

            Console c = System.console();
            System.out.println();
            clearScreen();            
            System.out.println("Registro borrado");
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }
        
    }
    

    public static void queryCuatro(BaseDeDatos unaDb){

        String sql = "SELECT id_fabricante FROM fabricantes ORDER BY id_fabricante ASC";
        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();     

            rs = stmt.executeQuery(sql);

            while(rs.next()){

                System.out.println(rs.getString(1));
              
            }
            Console c = System.console();
            System.out.println();
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }
        
    }
    

    public static void queryCinco(BaseDeDatos unaDb){

        String sql = "SELECT fabricante, precio, anio FROM bicicletas WHERE anio >= 2019 ORDER BY fabricante ASC";
        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();     

            rs = stmt.executeQuery(sql);

            while(rs.next()){

                System.out.print(rs.getString(1));
                System.out.print(", ");
                System.out.print(rs.getInt(2));
                System.out.print(", ");
                System.out.println(rs.getInt(3));                
              
            }
            Console c = System.console();
            System.out.println();
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }
        
    }
    

    public static void querySeis(BaseDeDatos unaDb){

        String sql = "SELECT fabricante FROM motocicletas_electricas WHERE prov_motor = \"Auteco\"";
        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();     

            rs = stmt.executeQuery(sql);

            while(rs.next()){

                System.out.println(rs.getString(1));
                           
              
            }
            Console c = System.console();
            System.out.println();
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }
        

        
    }
    

    public static void querySiete(BaseDeDatos unaDb){

        String sql = "SELECT alias, fabricante FROM intencion WHERE alias = \"lucky\" ORDER BY fabricante";
        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();     

            rs = stmt.executeQuery(sql);

            while(rs.next()){

                System.out.print(rs.getString(1));
                System.out.print(", ");
                System.out.println(rs.getString(2));
                           
              
            }
            Console c = System.console();
            System.out.println();
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }
        

        
    }
    

    public static void queryOcho(BaseDeDatos unaDb){

        String sql = "select C.id_alias, C.nombres, " +
        "C.apellidos from clientes C inner join intencion I on I.alias = C.id_alias " + 
        "where I.fabricante = \"Yeti\" order by C.id_alias";   
        
        
         try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();     

            rs = stmt.executeQuery(sql);

            while(rs.next()){

                System.out.print(rs.getString(1));
                System.out.print(", ");
                System.out.print(rs.getString(2));
                System.out.print(", ");
                System.out.println(rs.getString(3));
                           
              
            }
            Console c = System.console();
            
            System.out.println();
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }
        

        
        
    }


    public static void queryNueve(BaseDeDatos unaDb){

        String sql = "SELECT COUNT(*) FROM bicicletas WHERE anio >= 2019";
        try {
            Statement stmt = null;
            ResultSet  rs = null;  

            stmt = unaDb.getConnection().createStatement();     

            rs = stmt.executeQuery(sql);

            while(rs.next()){

                System.out.print(rs.getInt(1) + " Bicicletas");
                
                           
              
            }
            Console c = System.console();
            System.out.println();
            System.out.println("Enter para continuar");
            c.readLine();
            
            
        } catch (Exception e) {
            //TODO: handle exception
          
            
            
        }
        



    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
