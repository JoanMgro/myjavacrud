package vista;

public class MenuIntencionCompra extends MenuProductos{

    private String alias;
    private String fechaHora;
    private MenuFabricante fabricante;

      
    public MenuIntencionCompra(){
      super("Intencion De Compra");
    }
  
   
  public void menuPedirDatosParaConsultas(){
  
    System.out.print("Ingrese Id o *: ");
    idProducto = csle.readLine(); 
    System.out.print("Ingrese Alias o *: ");
    alias = csle.readLine();

 


    System.out.print("Ingrese Fecha y Hora (AAAA-MM-DD HH:MM:SS) o *: ");
    fechaHora = csle.readLine();
    clearScreen();
  
  }
  
  public void menuIngresarDatosNuevoRegistro() {
  
    System.out.print("Ingrese Id: ");
    idProducto = csle.readLine(); 
    System.out.print("Ingrese Alias: ");
    alias = csle.readLine();

     //Llamar menu fabricante:------------------
  //Cargo el fabricante con su id.
  fabricante = new MenuFabricante();
  fabricante.menuIngresarDatosNuevoRegistro(); 
  //-----------------------------------------
    
    
    System.out.print("Ingrese Fecha y Hora (AAAA-MM-DD HH:MM:SS): ");
    fechaHora = csle.readLine();
    clearScreen();
        
  }
  
    //GETTER
  
    public String getAlias(){
      return this.alias;
    }
  
    public MenuFabricante getFabricante(){
      return this.fabricante;
    }
  
    public String getFechaHora(){
      return this.fechaHora;
    }


    public void menuPedirDatosParaActualizar() {

    System.out.print("Ingrese Id a actualizar : ");
    idProducto = csle.readLine();

  //Llamar menu fabricante:------------------
    fabricante = new MenuFabricante();
    fabricante.menuPedirDatosParaActualizar();
  //-----------------------------------------

    System.out.print("Ingrese Alias o <Enter>: ");
    alias = csle.readLine();
    System.out.print("Ingrese Fecha y hora (AAAA-MM-DD HH:MM:SS) o <Enter>: ");
    fechaHora = csle.readLine();

  clearScreen();


    }

    public void menuPedirDatosParaBuscar() {


    System.out.print("Ingrese Id o <enter> : ");
    idProducto = csle.readLine();

  //Llamar menu fabricante:------------------
    fabricante = new MenuFabricante();
    fabricante.menuPedirDatosParaBuscar();
  //-----------------------------------------

    System.out.print("Ingrese Alias o <Enter>: ");
    alias = csle.readLine();
    System.out.print("Ingrese Fecha y hora (AAAA-MM-DD HH:MM:SS) o <Enter>: ");
    fechaHora = csle.readLine();

  clearScreen();


    }



      
   
    //SETTER

    
}
