package vista;

import java.io.Console;

public class MenuConRetoCuatro {

    String opcion;


    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public void menuRetoCuatro(){
        Console csle = System.console();


        clearScreen();
        System.out.println("##############################");
        System.out.println("#       Eco Dos Ruedas       #");
        System.out.println("##############################");
        System.out.println("Consultas ejemplo Reto 4");
        System.out.println("##############################");
        System.out.println();
        System.out.println("1. Cambiar el año de la bicicleta \"Cannondale\" por 2017");
        System.out.println("2. Cambiar el teléfono del cliente \"ninja\" por 3115678432");
        System.out.println("3. Borrar la intención de compra del cliente \"green\" de la bicicleta \"Trek\"");
        System.out.println("4. Mostrar el nombre de los fabricantes de todas las bicicletas y motocicletas");
        System.out.println("5. Mostrar la información de las bicicletas (fabricante, precio unitario, año) que se han estrenado posteriormente al año 2019, ordenadas por Fabricante.");
        System.out.println("6. Mostrar los fabricantes de las motocicletas eléctricas donde Auteco les provee el motor.");
        System.out.println("7. Mostrar la información de las bicicletas y motocicletas eléctricas (solo los fabricantes) que ha visto un cliente con alias \"lucky\", ordenadas por fabricante.");
        System.out.println("8. Mostrar la información de los clientes (alias y nombre y apellidos) que tienen la intención de comprar la bicicleta \"Yeti\" ordenados alfabéticamente.");
        System.out.println("9. Mostrar cuantas bicicletas se han fabricado después del año 2019.");
        System.out.println();
        System.out.print("Escriba opcion o <enter> para salir: ");
        opcion = csle.readLine();


    }

    public String getOpcion(){
        return this.opcion;
    }


    
}
