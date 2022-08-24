package vista;

import java.io.Console;

import java.util.ArrayList;

interface Menus {

    void menuPrincipalProducto();
    void menuLogoEliminarProducto();
    void menuLogoActualizarProducto();
    void menuLogoBuscarProducto();
    void menuLogoIngresarProducto();
    void menuElminarProducto();
    void menuMensajes(String unMensaje);
    void mostrarResultados(ArrayList <ArrayList<String>> unArrayList);
} 

public class MenuProductos implements Menus {
    
    protected String opcion;
    protected String tipoProducto;
    protected Console csle;
    protected String idProducto;
    
  

    public MenuProductos(String unProducto){

        csle = System.console();
        tipoProducto = unProducto;
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


   
    public void menuPrincipalProducto(){
        
        clearScreen();        
        System.out.println("##############################");
        System.out.println("#       Eco Dos Ruedas       #");
        System.out.println("##############################");
        System.out.println("Menu: " + tipoProducto);
        System.out.println("##############################");
        System.out.println("1. Ingresar nuevo");
        System.out.println("2. Eliminar registro");
        System.out.println("3. Actualizar regitro");
        System.out.println("4. Buscar un registro");
        System.out.println("5. Volver a menu");
        System.out.println("6. Salir del programa");
        System.out.println();
        System.out.print("Ingrese una opcion: ");
        opcion = csle.readLine();
        clearScreen();

    }
    
    @Override
    public void menuLogoEliminarProducto(){
        clearScreen();
        System.out.println("##############################");
        System.out.println("#       Eco Dos Ruedas       #");
        System.out.println("##############################");
        System.out.println("Eliminar: " + tipoProducto);
        System.out.println("##############################");

    }

    @Override
    public void menuElminarProducto(){

              
        System.out.print("Ingrese Id a eliminar: ");
        idProducto = csle.readLine();
        clearScreen();

    }

    @Override
    public void menuLogoActualizarProducto(){
        clearScreen();
        System.out.println("##############################");
        System.out.println("#       Eco Dos Ruedas       #");
        System.out.println("##############################");
        System.out.println("Actualizar: " + tipoProducto);
        System.out.println("##############################");
    }

    @Override
    public void menuLogoBuscarProducto(){
        clearScreen();
        System.out.println("##############################");
        System.out.println("#       Eco Dos Ruedas       #");
        System.out.println("##############################");
        System.out.println("Buscar: " + tipoProducto);
        System.out.println("##############################");
    }

    @Override
    public void menuLogoIngresarProducto(){
        clearScreen();
        System.out.println("##############################");
        System.out.println("#       Eco Dos Ruedas       #");
        System.out.println("##############################");
        System.out.println("Ingresar: " + tipoProducto);
        System.out.println("##############################");
    }

    @Override
    public void menuMensajes(String unMensaje){
        clearScreen();
        System.out.println(unMensaje);
        System.out.println("Enter para Continuar");
        csle.readLine();




    }

    public void mostrarResultados(ArrayList <ArrayList<String>> unArrayList){

        clearScreen();



        for(int i = 0; i < unArrayList.size(); i ++){
             System.out.println(unArrayList.get(i));
            }
        

        System.out.println("Oprimir enter para continuar");
        csle.readLine();
        
    }

    //GETTER

    public String getIdProducto(){
        return this.idProducto;
    }
    public String getOpcion(){
        return this.opcion;
    }

    //SETTET

    public void setOpcion(String unaOpcion){
        this.opcion = unaOpcion;
    }

    
}