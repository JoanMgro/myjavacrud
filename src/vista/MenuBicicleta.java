package vista;


public class MenuBicicleta extends MenuProductos{

  
  private MenuFabricante fabricante;
  private String precio;
  private String anio;
    
  public MenuBicicleta(){
    super("Bicicletas"); 
  }


public void menuPedirDatosParaActualizar(){

  System.out.print("Ingrese Id del registro a actualizar: ");
  idProducto = csle.readLine();

  //Llamar menu fabricante:------------------
  fabricante = new MenuFabricante();
  fabricante.menuPedirDatosParaActualizar();
  //-----------------------------------------

   System.out.print("Ingrese Precio o <Enter> para no modificar : ");
  precio = csle.readLine();
  System.out.print("Ingrese año o <Enter> para no modificar ");
  anio = csle.readLine();
 
  clearScreen();

}

public void menuPedirDatosParaBuscar(){
  System.out.print("Ingrese Id  o <Enter> : ");
  idProducto = csle.readLine();

  //Llamar menu fabricante:------------------
  fabricante = new MenuFabricante();
  fabricante.menuPedirDatosParaBuscar();
  //-----------------------------------------

  System.out.print("Ingrese Precio o <Enter>: ");
  precio = csle.readLine();
  System.out.print("Ingrese año o <Enter>: ");
  anio = csle.readLine();

  // System.out.print("Ingrese Fabricante o <Enter> : ");
  // fabricante = csle.readLine();
  clearScreen();
}

public void menuIngresarDatosNuevoRegistro() {
  
  System.out.print("Ingrese Id: ");
  idProducto = csle.readLine();  

  //Llamar menu fabricante:------------------
  //Cargo el fabricante con su id.
  fabricante = new MenuFabricante();
  fabricante.menuIngresarDatosNuevoRegistro(); 
  //-----------------------------------------

  System.out.print("Ingrese Precio: ");
  precio = csle.readLine();
  System.out.print("Ingrese año: ");
  anio = csle.readLine();




  clearScreen();
      
}


  //GETTER


  public MenuFabricante getFabricante(){
    return this.fabricante;
  }

  public String getPrecio(){
    return this.precio;
  }

  public String getAnio(){
    return this.anio;
  }

  //SETTER

  public void setFabricante(MenuFabricante unFabricante){
    this.fabricante = unFabricante;
  }

  public void setIdProducto(String unId){
  
  }

  public void setPrecio(String unPrecio){
    this.precio = unPrecio;
  }

  public void setAnio(String unAnio){
    this.anio = unAnio;
  }
    
}
