package vista;

public class MenuFabricante extends MenuProductos { 

    
    public MenuFabricante(){
        super("Fabricantes"); 
      }

    
  public void menuPedirDatosParaActualizar(){

    System.out.print("Ingrese Fabricante a actualizar <Enter> para no modificar: ");
    idProducto = csle.readLine();
   
  }
  
  public void menuPedirDatosParaBuscar(){
    System.out.print("Ingrese Fabricante  o <Enter> : ");
    idProducto = csle.readLine();

  }
  
  public void menuIngresarDatosNuevoRegistro() {
    
    System.out.print("Ingrese Fabricante: ");
    idProducto = csle.readLine();    
    //clearScreen();
        
  }
  
  
    //GETTER
  

    public String getIdProducto(){
      return this.idProducto;
    }
  
    //SETTER
  
  
    public void setIdProducto(String unId){
      this.idProducto = unId;
    
    }
  
 
    
}
