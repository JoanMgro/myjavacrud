package vista;

public class MenuProovedorMotor extends MenuProductos{
    private String direccion;
    private String telefono;

    public MenuProovedorMotor(){
      super("Proveedor Motor"); 
    }



public void menuPedirDatosParaActualizar(){

  System.out.print("Ingrese Proveedor del <Enter> para no modificar : ");
  idProducto = csle.readLine();
  System.out.print("Ingrese Nuevo Fabricante o <Enter> para no modificar  : ");
  direccion = csle.readLine();
  System.out.print("Ingrese telefono o <Enter> para no modificar : ");
  telefono = csle.readLine();

  clearScreen();

}

public void menuPedirDatosParaBuscar(){
  System.out.print("Ingrese Id  o <Enter> : ");
  idProducto = csle.readLine();
  System.out.print("Ingrese Fabricante o <Enter> : ");
  direccion = csle.readLine();
  System.out.print("Ingrese Precio o <Enter>: ");
  telefono = csle.readLine();

  clearScreen();
}

public void menuIngresarDatosNuevoRegistro() {
  
  System.out.print("Ingrese Id (Proveedor) : ");
  idProducto = csle.readLine();  
  System.out.print("Ingrese Direccion: ");
  direccion = csle.readLine();
  System.out.print("Ingrese Telefono: ");
  telefono = csle.readLine();

  clearScreen();
      
}


  //GETTER


  public String getDireccion(){
    return this.direccion;
  }

  public String getTelefono(){
    return this.telefono;
  }

  public String getIdProducto(){
    return this.idProducto;
  }

  //SETTER

  public void setDireccion(String unaDireccion){
    this.direccion = unaDireccion;
  }

  public void setIdProducto(String unId){
    this.idProducto = unId;
  
  }

  public void setTelefono(String unTel){
    this.telefono = unTel;
  }



}
