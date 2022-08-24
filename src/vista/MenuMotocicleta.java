package vista;

public class MenuMotocicleta extends MenuProductos{

    private MenuFabricante fabricante;
    private String precio;
    private String autonomia;
    private MenuProovedorMotor proveedorMotor;
    
      
    public MenuMotocicleta(){
      super("Motos Electricas");
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
  System.out.print("Ingrese Autonomia o <Enter> para no modificar ");
  autonomia = csle.readLine();

  //Llamar al el menu de proveedor motor:--------
  proveedorMotor = new MenuProovedorMotor();
  proveedorMotor.menuIngresarDatosNuevoRegistro();
  //---------------------------------------------

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
  System.out.print("Ingrese Autonomia o <Enter>: ");
  autonomia = csle.readLine();
  
  //Llamar al el menu de proveedor motor:--------
  proveedorMotor = new MenuProovedorMotor();
  proveedorMotor.menuPedirDatosParaBuscar();
  //--------------------------------------------

  clearScreen();
}

public void menuIngresarDatosNuevoRegistro() {
  
  System.out.print("Ingrese Id: ");
  idProducto = csle.readLine();  

  //Llamar menu fabricante:------------------
  fabricante = new MenuFabricante();
  fabricante.menuIngresarDatosNuevoRegistro();
  //-----------------------------------------

  System.out.print("Ingrese Precio: ");
  precio = csle.readLine();
  System.out.print("Ingrese Autonomia: ");
  autonomia = csle.readLine();

  //Llamar al el menu de proveedor motor:--------
  proveedorMotor = new MenuProovedorMotor();
  proveedorMotor.menuIngresarDatosNuevoRegistro();
  //---------------------------------------------

  clearScreen();
      
}


  //GETTER


  public MenuFabricante getFabricante(){
    return this.fabricante;
  }

  public String getPrecio(){
    return this.precio;
  }

  public String getAutonomia(){
    return this.autonomia;
  }

  public MenuProovedorMotor getProveedor(){
    return this.proveedorMotor;
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

  public void setAutonomia(String unAnio){
  
  }
}
