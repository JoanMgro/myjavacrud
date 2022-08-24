package vista;

import java.io.Console;

public class MenuLogIn{

    private Console csle;
    private String NombreUsuario;
    private String Password;
    private String opcion;

    public MenuLogIn(){
        csle = System.console();
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void mostrarMenuIngreso(){
        clearScreen();
        csle = System.console();

        System.out.println("##############################");
        System.out.println("#       Eco Dos Ruedas       #");
        System.out.println("##############################");
        System.out.println();
        System.out.print("Ingrese Usuario: ");
        NombreUsuario = csle.readLine();
        System.out.print("Ingrese Password: ");
        Password = String.valueOf(csle.readPassword());
               
    }

    public void estadoIngreso(String unMensaje){
        clearScreen();
        System.out.println(unMensaje);

        if(unMensaje.equals("Conectado")) {
            System.out.println("Enter para continuar");
            csle.readLine();
            opcion = "0";          
                 
        }
        else{
            
            System.out.print("Enter para Reintentar / Q para salir: ");

            opcion = csle.readLine().toLowerCase();

            if(!opcion.equals("q")){opcion = "Retry";};                 
            
        }  
        clearScreen();


    }


    //GETTER

    public String getNombreUsuario(){
        return this.NombreUsuario;
    }

    public String getPassword(){
        return this.Password;
    }

    public String getOpcion(){
        return this.opcion;
    }

    //SETTER

    public void setOpcion(String unaOpcion){
        this.opcion = unaOpcion;
    }
    
}
