package vista;

import java.sql.Date;

public class MenuCliente extends MenuProductos{

    private String nombres;
    private String apellidos;
    private String email;
    private String celular;
    private String contrasena;
    private String fechaNacimiento;

      
    public MenuCliente(){
      super("Clientes");
    }
  
   
    public void menuPedirDatosParaActualizar(){
  
      System.out.print("Ingrese Alias (id) del registro a actualizar: ");
      idProducto = csle.readLine(); //Alias
      System.out.print("Ingrese Nombres o <Enter> para no modificar: ");
      nombres = csle.readLine();
      System.out.print("Ingrese Apellidos o <Enter> para no modificar: ");
      apellidos = csle.readLine();
      System.out.print("Ingrese E-mail o <Enter> para no modificar: ");
      email = csle.readLine();
      System.out.print("Ingrese Celular o <Enter> para no modificar: ");
      celular = csle.readLine();
      System.out.print("Ingrese Contraseña o <Enter> para no modificar: ");
      contrasena = csle.readLine();
      System.out.print("Ingrese Flecha Nacimiento (AAAA-MM-DD) o <Enter> para no modificar: ");
      fechaNacimiento = csle.readLine();
      //fechaNacimiento = "'" + fechaNacimiento + "'";
      clearScreen();
    
    }
  
    public void menuPedirDatosParaBuscar(){
    
      System.out.print("Ingrese Alias o <Enter>: ");
      idProducto = csle.readLine(); //Alias
      System.out.print("Ingrese Nombres o <Enter>: ");
      nombres = csle.readLine();
      System.out.print("Ingrese Apellidos o <Enter>: ");
      apellidos = csle.readLine();
      System.out.print("Ingrese E-mail o <Enter>: ");
      email = csle.readLine();
      System.out.print("Ingrese Celular o <Enter>: ");
      celular = csle.readLine();
      System.out.print("Ingrese Contraseña o <Enter>: ");
      contrasena = csle.readLine();
      System.out.print("Ingrese Flecha Nacimiento (AAAA-MM-DD) o <Enter> ");
      fechaNacimiento = csle.readLine();
      clearScreen();
    
    }
    
  
  
  
  
  public void menuIngresarDatosNuevoRegistro() {
    
  
    System.out.print("Ingrese Alias: ");
    idProducto = csle.readLine(); //Alias
    System.out.print("Ingrese Nombres: ");
    nombres = csle.readLine();
    System.out.print("Ingrese Apellidos: ");
    apellidos = csle.readLine();
    System.out.print("Ingrese E-mail: ");
    email = csle.readLine();
    System.out.print("Ingrese Celular: ");
    celular = csle.readLine();
    System.out.print("Ingrese Contraseña: ");
    contrasena = csle.readLine();
    System.out.print("Ingrese Flecha Nacimiento (AAAA-MM-DD): ");
    fechaNacimiento = csle.readLine();
    //fechaNacimiento = "'" + fechaNacimiento + "'";
    clearScreen();
  }
  
    //GETTER
  
    public String getNombres(){
      return this.nombres;
    }
  
    public String getApellidos(){
      return this.apellidos;
    }
  
    public String getEmail(){
      return this.email;
    }

      
    public String getCelular(){
        return this.celular;
      }

      
    public String getFechaNacimiento(){
        return this.fechaNacimiento;
      }

    public String getContrasena(){
        return this.contrasena;
    }
  
    //SETTER
    
    
}
