package vista;

import java.io.Console;

public class MenuEntrada {
    
    private Console csle;
    private String opcion;

    public MenuEntrada(){
        csle = System.console();
    }


    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



public void menuSeleccionEntrada(){
        
    System.out.println("##############################");
    System.out.println("#       Eco Dos Ruedas       #");
    System.out.println("##############################");
    System.out.println("1- Bicicletas");
    System.out.println("2- Motos Electricas");
    System.out.println("3- Clientes");
    System.out.println("4- Intencion de Compra");
    System.out.println("5- Consultas Reto 4");
    System.out.println("6- Salir");
    System.out.println();
    System.out.print("Ingrese opcion: ");
    opcion = csle.readLine();
    clearScreen();

   // if(opcion.equals("5")){opcion = "6";};


}

//GETTTER

public String getOpcion(){
    return this.opcion;
}

//SETTER

public void setOpcion(String unaOpcion){
    this.opcion = unaOpcion;
}

    
}
