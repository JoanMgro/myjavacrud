package controlador;

import vista.MenuBicicleta;
import vista.MenuCliente;
import vista.MenuConRetoCuatro;
import vista.MenuLogIn;
import vista.MenuMotocicleta;
import vista.MenuIntencionCompra;
import vista.MenuEntrada;

import java.io.Console;

import modelo.BaseDeDatos;
import modelo.DBBicicleta;
import modelo.DBCliente;
import modelo.DBMotocicleta;
import modelo.DBintencionCompra;
import modelo.RetoCuatro;




public class Controlador {

    //Menus
    private Console csle;

    private MenuBicicleta menuBicicleta;
    private MenuCliente menuCliente;
    private MenuLogIn menuLogIn;
    private MenuMotocicleta menuMotocicleta;
    private MenuIntencionCompra menuIntencionCompra;
    private MenuEntrada menuEntrada;
    
    //Base de Datos

    private BaseDeDatos dB;
    
    private DBBicicleta bicicletaDB;
    private DBMotocicleta motoDB;
    private DBCliente clienteDB;
    private DBintencionCompra intencionDB;

    

    public Controlador(){
        inicializarApp();
        

    }

    public void inicializarApp(){

        if(menuLogIn == null){ menuLogIn = new MenuLogIn();}
        
        //Menu de LogIn
        do {
            menuLogIn.clearScreen();
            menuLogIn.mostrarMenuIngreso();

            //intentar conectar aca
            if(dB == null){ dB = new BaseDeDatos();}
            dB.conectarDB(menuLogIn.getNombreUsuario(), menuLogIn.getPassword());
            

            menuLogIn.estadoIngreso(dB.getEstadoCon());

        }while(menuLogIn.getOpcion().equals("Retry"));
        
        dB.desconectasDB();

        menuLogIn.setOpcion("0");
        
        if(menuLogIn.getOpcion().equals("0")){ 

            iniciarProgPpal();

        }


    }

    public void iniciarProgPpal(){

        if(menuEntrada == null){ menuEntrada = new MenuEntrada();}
        
        do
        {
            //Llamar el menu de entrada y llamar el submenu adecuado
            menuEntrada.menuSeleccionEntrada();
            
            switch(menuEntrada.getOpcion()){

                case "1": 
                                                                
                    iniciarSubMenuBicicletas();
                    menuEntrada.setOpcion(menuBicicleta.getOpcion());        

                    break;

                case "2":

                    iniciarSubMenuMotos();
                    menuEntrada.setOpcion(menuMotocicleta.getOpcion());

                    break;
                case "3":

                    iniciarSubMenuClientes();
                    menuEntrada.setOpcion(menuCliente.getOpcion());


                    break;
                case "4":
                    iniciarSubMenuIntencion();
                    menuEntrada.setOpcion(menuIntencionCompra.getOpcion());

                    break;
                case "5":
                    MenuConRetoCuatro retoCuatro = new MenuConRetoCuatro();
                    inciarConsultasRetoCuatro(retoCuatro);
                    
                    menuEntrada.setOpcion(retoCuatro.getOpcion());
                default:
                    break;

            }
        }while(!menuEntrada.getOpcion().equals("6"));

        System.out.println("Presentado por:");
        System.out.println("Jelit Paola Manrique Fuentes CC.1010105885 EMAIL: manrique.paola1431@gmail.com");
        System.out.println("Joan Francisco Montenegro Gonzalez CC80096857 EMAIL: joanfcomontenegro@gmail.com");
        System.out.println("Jonnatan de Jesus García Ruiz CC 1094243984 EMAIL: jonnas.g.d@gmail.com");
        System.out.println();


    }


    public void inciarConsultasRetoCuatro(MenuConRetoCuatro retoCuatro){
        
        do{
            retoCuatro.menuRetoCuatro();

        switch(retoCuatro.getOpcion()){
            case "1":
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.queryUno(dB);                
                dB.desconectasDB();
                break;
            case "2":
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.queryDos(dB);                
                dB.desconectasDB();
                break;
            case "3":
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.queryTres(dB);                
                dB.desconectasDB();
                break;
            case "4":
                
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.queryCuatro(dB);                
                dB.desconectasDB();
                break;
            case "5":
                
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.queryCinco(dB);                
                dB.desconectasDB();
                break;  
            case "6":
                
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.querySeis(dB);                
                dB.desconectasDB();
                break;
            case "7":
                
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.querySiete(dB);                
                dB.desconectasDB();
                break;
            case "8":
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.queryOcho(dB);                
                dB.desconectasDB();
                break;
            case "9":
                dB.conectarDB(dB.getNombreUsuario(),dB.getPassword());
                RetoCuatro.queryNueve(dB);                
                dB.desconectasDB();
                break;
            default:
                break;
        }

        }while(!retoCuatro.getOpcion().equals(""));
        

    }

    public void iniciarSubMenuBicicletas(){
        
        if(menuBicicleta == null){ menuBicicleta = new MenuBicicleta();}
                
        do{
            menuBicicleta.menuPrincipalProducto();   
                   
            switch(menuBicicleta.getOpcion()){

                case "1":

                    subMenuBicicletasIngresarDatos();
                    break;

                case "2":

                    subMenuBicicletasEliminar();                   
                    break;

                case "3": 

                    subMenuBicicletasActualizar();
                    break;

                case "4":

                    subMenuBicicletasBuscar(); 
                    break;

                default:                   
                    break;
                }      

        }while(!(menuBicicleta.getOpcion().equals("5") || menuBicicleta.getOpcion().equals("6")));
  


    }
    public void iniciarSubMenuMotos(){

        if(menuMotocicleta == null){ menuMotocicleta = new MenuMotocicleta();}
                
        do{
            menuMotocicleta.menuPrincipalProducto();   
                   
            switch(menuMotocicleta.getOpcion()){

                case "1":

                    subMenuMotosIngresarDatos();
                    break;

                case "2":

                    subMenuMotosEliminar();                   
                    break;

                case "3": 

                    subMenuMotosActualizar();
                    break;

                case "4":

                    subMenuMotosBuscar(); 
                    break;

                default:                   
                    break;
                }      

        }while(!(menuMotocicleta.getOpcion().equals("5") || menuMotocicleta.getOpcion().equals("6")));
  



    }


    public void iniciarSubMenuClientes(){

        if(menuCliente == null){ menuCliente = new MenuCliente();}
                
        do{
            menuCliente.menuPrincipalProducto();   
                   
            switch(menuCliente.getOpcion()){

                case "1":

                    subMenuClientesIngresarDatos();
                    break;

                case "2":

                    subMenuClientesEliminar();                   
                    break;

                case "3": 

                    subMenuClientesActualizar();
                    break;

                case "4":

                    subMenuClientesBuscar(); 
                    break;

                default:                   
                    break;
                }      

        }while(!(menuCliente.getOpcion().equals("5") || menuCliente.getOpcion().equals("6")));
  



    }

    public void iniciarSubMenuIntencion(){

        if(menuIntencionCompra == null){ menuIntencionCompra = new MenuIntencionCompra();}
                
        do{
            menuIntencionCompra.menuPrincipalProducto();   
                   
            switch(menuIntencionCompra.getOpcion()){

                case "1":

                    subMenuIntencionIngresarDatos();
                    break;

                case "2":

                    subMenuIntencionEliminar();                   
                    break;

                case "3": 

                    subMenuIntencionActualizar();
                    break;

                case "4":

                    subMenuIntencionBuscar(); 
                    break;

                default:                   
                    break;
                }      

        }while(!(menuIntencionCompra.getOpcion().equals("5") || menuIntencionCompra.getOpcion().equals("6")));
  



    }


    //----------------------------------------------------------------
//FUNCIONES INGRESAR
    
    public void subMenuBicicletasIngresarDatos(){

        //Ejecutando Vista para ingresar Datos
        do{

            menuBicicleta.menuLogoIngresarProducto();
            menuBicicleta.menuIngresarDatosNuevoRegistro();
            prepararDatosBicicletaParaIngresar();                              
            
        }while(!bicicletaDB.getEsAsignado());
        
        ingresarDatosBicicletaBasedeDatos();
        
    }
    public void subMenuMotosIngresarDatos(){

        //Ejecutando Vista para ingresar Datos
        do{

            menuMotocicleta.menuLogoIngresarProducto();
            menuMotocicleta.menuIngresarDatosNuevoRegistro();
            prepararDatosMotosParaIngresar();                              
            
        }while(!motoDB.getEsAsignado());
        
        ingresarDatosMotoBasedeDatos();
        

    }

    public void subMenuClientesIngresarDatos(){
            //Ejecutando Vista para ingresar Datos
            do{

                menuCliente.menuLogoIngresarProducto();
                menuCliente.menuIngresarDatosNuevoRegistro();
                prepararDatosClienteParaIngresar();                              
                
            }while(!clienteDB.getEsAsignado());
            
            ingresarDatosClienteBasedeDatos();
}

    public void subMenuIntencionIngresarDatos(){
    //Ejecutando Vista para ingresar Datos
    do{

        menuIntencionCompra.menuLogoIngresarProducto();
        menuIntencionCompra.menuIngresarDatosNuevoRegistro();
        prepararDatosIntencionParaIngresar();                              
        
    }while(!intencionDB.getEsAsignado());
    
    ingresarDatosIntencionBasedeDatos();
}

    public void  prepararDatosBicicletaParaIngresar(){

        if(bicicletaDB == null){ bicicletaDB = new DBBicicleta();};

            bicicletaDB.setProductoIngresar(menuBicicleta);
            
            if(!bicicletaDB.getEsAsignado()){
                menuBicicleta.menuMensajes(bicicletaDB.getMsg());
                
            }                              

    }
    public void prepararDatosMotosParaIngresar(){

        if(motoDB == null){ motoDB = new DBMotocicleta();};

            motoDB.setProductoIngresar(menuMotocicleta);
            
            if(!motoDB.getEsAsignado()){
                menuMotocicleta.menuMensajes(motoDB.getMsg());
                
            }                              


    }

    public void prepararDatosClienteParaIngresar(){

        if(clienteDB == null){ clienteDB = new DBCliente();};

            clienteDB.setProductoIngresar(menuCliente);
            
            if(!clienteDB.getEsAsignado()){
                menuCliente.menuMensajes(clienteDB.getMsg());
                
            }                              


    }

    public void prepararDatosIntencionParaIngresar(){

        if(intencionDB == null){ intencionDB = new DBintencionCompra();};

            intencionDB.setProductoIngresar(menuIntencionCompra);
            
            if(!intencionDB.getEsAsignado()){
                menuIntencionCompra.menuMensajes(intencionDB.getMsg());
                
            }                              


    }

    public void ingresarDatosBicicletaBasedeDatos(){

        if(bicicletaDB.getEsAsignado()){
            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            bicicletaDB.ingresarProducto(dB); //llama a base de datos
            menuBicicleta.menuMensajes(bicicletaDB.getMsg());
            dB.desconectasDB();
        }


    }
    public void ingresarDatosMotoBasedeDatos(){

        if(motoDB.getEsAsignado()){
            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            motoDB.ingresarProducto(dB); //llama a base de datos
            menuMotocicleta.menuMensajes(motoDB.getMsg());
            dB.desconectasDB();
        }


    }
   
    public void ingresarDatosClienteBasedeDatos(){

        if(clienteDB.getEsAsignado()){
            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            clienteDB.ingresarProducto(dB); //llama a base de datos
            menuCliente.menuMensajes(clienteDB.getMsg());
            dB.desconectasDB();
        }


    }

    public void ingresarDatosIntencionBasedeDatos(){

        if(intencionDB.getEsAsignado()){
            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            intencionDB.ingresarProducto(dB); //llama a base de datos
            menuIntencionCompra.menuMensajes(intencionDB.getMsg());
            dB.desconectasDB();
        }


    }
   
   
    //---------------------------------------------------------

//FUNCIONES ELIMINAR 
    
    public void subMenuBicicletasEliminar(){

        do{
            menuBicicleta.menuLogoEliminarProducto();
            menuBicicleta.menuElminarProducto();

            prepararDatosBicicletaParaEliminar(); 
            
        }while(!bicicletaDB.getEsAsignado());

            eliminarDatosBicicletaBasedeDatos();                                           
        
        //Llamar la base de datos.

    }
    public void subMenuMotosEliminar(){

        do{
            menuMotocicleta.menuLogoEliminarProducto();
            menuMotocicleta.menuElminarProducto();

            prepararDatosMotoParaEliminar(); 
            
        }while(!motoDB.getEsAsignado());

            eliminarDatosMotoBasedeDatos();                                           
        
        //Llamar la base de datos.

    }

    public void subMenuClientesEliminar(){

        do{
            menuCliente.menuLogoEliminarProducto();
            menuCliente.menuElminarProducto();

            prepararDatosClienteParaEliminar(); 
            
        }while(!clienteDB.getEsAsignado());

            eliminarDatosClienteBasedeDatos();                                           
        
        //Llamar la base de datos.

    }

    public void subMenuIntencionEliminar(){

        do{
            menuIntencionCompra.menuLogoEliminarProducto();
            menuIntencionCompra.menuElminarProducto();

            prepararDatosIntencionParaEliminar(); 
            
        }while(!intencionDB.getEsAsignado());

            eliminarDatosIntencionBasedeDatos();                                           
        
        //Llamar la base de datos.

    }

    public void prepararDatosBicicletaParaEliminar(){

        if(bicicletaDB == null){ bicicletaDB = new DBBicicleta();};
        bicicletaDB.setProductoEliminar(menuBicicleta.getIdProducto());
        if(!bicicletaDB.getEsAsignado()){
            menuBicicleta.menuMensajes(bicicletaDB.getMsg());
            
        }  

    }

    public void prepararDatosClienteParaEliminar(){

        if(clienteDB == null){ clienteDB = new DBCliente();};
        clienteDB.setProductoEliminar(menuCliente.getIdProducto());
        if(!clienteDB.getEsAsignado()){
            menuCliente.menuMensajes(clienteDB.getMsg());
            
        }  

    }

    public void prepararDatosIntencionParaEliminar(){

        if(intencionDB == null){ intencionDB = new DBintencionCompra();}

        intencionDB.setProductoEliminar(menuIntencionCompra.getIdProducto());
        if(!intencionDB.getEsAsignado()){
            menuIntencionCompra.menuMensajes(intencionDB.getMsg());
            
        }  

    }

    public void prepararDatosMotoParaEliminar(){

        if(motoDB == null){ motoDB = new DBMotocicleta();};
        motoDB.setProductoEliminar(menuMotocicleta.getIdProducto());
        if(!motoDB.getEsAsignado()){
            menuMotocicleta.menuMensajes(motoDB.getMsg());
            
        }  

    }
    public void eliminarDatosBicicletaBasedeDatos(){

        if(bicicletaDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            bicicletaDB.eliminarProducto(dB); //llama a base de datos
            menuBicicleta.menuMensajes(bicicletaDB.getMsg());
            dB.desconectasDB();
        } 

    }
    public void eliminarDatosMotoBasedeDatos(){

        if(motoDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            motoDB.eliminarProducto(dB); //llama a base de datos
            menuMotocicleta.menuMensajes(motoDB.getMsg());
            dB.desconectasDB();
        } 

    }

    public void eliminarDatosClienteBasedeDatos(){

        if(clienteDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            clienteDB.eliminarProducto(dB); //llama a base de datos
            menuCliente.menuMensajes(clienteDB.getMsg());
            dB.desconectasDB();
        } 

    }

    public void eliminarDatosIntencionBasedeDatos(){

        if(intencionDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            intencionDB.eliminarProducto(dB); //llama a base de datos
            menuIntencionCompra.menuMensajes(intencionDB.getMsg());
            dB.desconectasDB();
        } 

    }




    //------------------------------------------------------
//FUNCIONES ACTUALIZAR 

    public void subMenuBicicletasActualizar(){

        do{
            menuBicicleta.menuLogoActualizarProducto();
            menuBicicleta.menuPedirDatosParaActualizar();
            prepararDatosBicicletaParaActualizar();

            
        }while(!bicicletaDB.getEsAsignado());
        actualizarDatosBicicletaBasedeDatos();
        
    }
    public void subMenuMotosActualizar(){

        do{
            menuMotocicleta.menuLogoActualizarProducto();
            menuMotocicleta.menuPedirDatosParaActualizar();
            prepararDatosMotosParaActualizar();

            
        }while(!motoDB.getEsAsignado());
        actualizarDatosMotosBasedeDatos();
        
    }

    public void subMenuClientesActualizar(){

        do{
            menuCliente.menuLogoActualizarProducto();
            menuCliente.menuPedirDatosParaActualizar();
            prepararDatosClientesParaActualizar();

            
        }while(!clienteDB.getEsAsignado());
        actualizarDatosClientesBasedeDatos();
        
    }

    public void subMenuIntencionActualizar(){

        do{
            menuIntencionCompra.menuLogoActualizarProducto();
            menuIntencionCompra.menuPedirDatosParaActualizar();

            prepararDatosIntencionParaActualizar(); 
            
        }while(!intencionDB.getEsAsignado());

            actualizarDatosIntencionBasedeDatos();                                           
        
        //Llamar la base de datos.

    }

    public void prepararDatosIntencionParaActualizar(){

        if(intencionDB == null){ intencionDB = new DBintencionCompra();}

        intencionDB.setProductoActualizar(menuIntencionCompra);
        if(!intencionDB.getEsAsignado()){
            menuIntencionCompra.menuMensajes(intencionDB.getMsg());
            
        }  

    }



    public void prepararDatosBicicletaParaActualizar(){

        if(bicicletaDB == null){ bicicletaDB = new DBBicicleta();};
        bicicletaDB.setProductoActualizar(menuBicicleta);//preparar los datos para el ingreso
        if(!bicicletaDB.getEsAsignado()){
            menuBicicleta.menuMensajes(bicicletaDB.getMsg());
            
        }   
    }
    public void prepararDatosMotosParaActualizar(){

        if(motoDB == null){ motoDB = new DBMotocicleta();};
        motoDB.setProductoActualizar(menuMotocicleta);//preparar los datos para el ingreso
        if(!motoDB.getEsAsignado()){
            menuMotocicleta.menuMensajes(motoDB.getMsg());
            
        }   
    }




    public void prepararDatosClientesParaActualizar(){

        if(clienteDB == null){ clienteDB = new DBCliente();};
        clienteDB.setProductoActualizar(menuCliente);//preparar los datos para el ingreso
        if(!clienteDB.getEsAsignado()){
            menuCliente.menuMensajes(clienteDB.getMsg());
            
        }   
    }

    public void actualizarDatosBicicletaBasedeDatos(){

        if(bicicletaDB.getEsAsignado()){
            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            bicicletaDB.actualizarProducto(dB);; //llama a base de datos
            menuBicicleta.menuMensajes(bicicletaDB.getMsg());
            dB.desconectasDB();
        }    
    }
    public void actualizarDatosMotosBasedeDatos(){

        if(motoDB.getEsAsignado()){
            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            motoDB.actualizarProducto(dB);; //llama a base de datos
            menuMotocicleta.menuMensajes(motoDB.getMsg());
            dB.desconectasDB();
        }    
    }

    public void actualizarDatosClientesBasedeDatos(){

        if(clienteDB.getEsAsignado()){
            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            clienteDB.actualizarProducto(dB);; //llama a base de datos
            menuCliente.menuMensajes(clienteDB.getMsg());
            dB.desconectasDB();
        }    
    }

    public void actualizarDatosIntencionBasedeDatos(){

        if(intencionDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            intencionDB.actualizarProducto(dB); //llama a base de datos
            menuIntencionCompra.menuMensajes(intencionDB.getMsg());
            dB.desconectasDB();
        } 

    }

    //-----------------------------------------------------------
//FUNCIONES BUSCAR 
    public void subMenuBicicletasBuscar(){
                
        do{
            menuBicicleta.menuLogoBuscarProducto();
            menuBicicleta.menuPedirDatosParaBuscar();
            prepararDatosBicicletaParaBuscar();

            
        }while(!bicicletaDB.getEsAsignado());

        buscarDatosBicicletaBasedeDatos();

        menuBicicleta.mostrarResultados(bicicletaDB.getArrayList());

    }  

    public void subMenuMotosBuscar(){
                
        do{
            menuMotocicleta.menuLogoBuscarProducto();
            menuMotocicleta.menuPedirDatosParaBuscar();
            prepararDatosMotosParaBuscar();

            
        }while(!motoDB.getEsAsignado());

        buscarDatosMotosBasedeDatos();

        menuMotocicleta.mostrarResultados(motoDB.getArrayList());

    }  

    public void subMenuClientesBuscar(){
                
        do{
            menuCliente.menuLogoBuscarProducto();
            menuCliente.menuPedirDatosParaBuscar();
            prepararDatosClienteParaBuscar();

            
        }while(!clienteDB.getEsAsignado());

        buscarDatosClienteBasedeDatos();

        menuCliente.mostrarResultados(clienteDB.getArrayList());

    }  

    public void subMenuIntencionBuscar(){

        do{
            menuIntencionCompra.menuLogoBuscarProducto();
            menuIntencionCompra.menuPedirDatosParaBuscar();

            prepararDatosIntencionParaBuscar(); 
            
        }while(!intencionDB.getEsAsignado());

            buscarDatosIntencionBasedeDatos(); 
                       
         menuIntencionCompra.mostrarResultados(intencionDB.getArrayList());
        //Llamar la base de datos.

    }

    public void prepararDatosBicicletaParaBuscar(){

        if(bicicletaDB == null){ bicicletaDB = new DBBicicleta();};
        bicicletaDB.setProductoBuscar(menuBicicleta);//preparar los datos para ña busqieda
        if(!bicicletaDB.getEsAsignado()){
            menuBicicleta.menuMensajes(bicicletaDB.getMsg());
            
        }   

    }
    public void prepararDatosMotosParaBuscar(){

        if(motoDB == null){ motoDB = new DBMotocicleta();};
        motoDB.setProductoBuscar(menuMotocicleta);//preparar los datos para ña busqieda
        if(!motoDB.getEsAsignado()){
            menuMotocicleta.menuMensajes(motoDB.getMsg());
            
        }   

    }

    public void prepararDatosClienteParaBuscar(){

        if(clienteDB == null){ clienteDB = new DBCliente();};
        clienteDB.setProductoBuscar(menuCliente);//preparar los datos para ña busqieda
        if(!clienteDB.getEsAsignado()){
            menuCliente.menuMensajes(clienteDB.getMsg());
            
        }   

    }


    public void prepararDatosIntencionParaBuscar(){

        if(intencionDB == null){ intencionDB = new DBintencionCompra();}

        intencionDB.setProductoBuscar(menuIntencionCompra);
        if(!intencionDB.getEsAsignado()){
            menuIntencionCompra.menuMensajes(intencionDB.getMsg());
            
        }  

    }


    public void buscarDatosBicicletaBasedeDatos(){

        if(bicicletaDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            bicicletaDB.buscarProducto(dB); //llama a base de datos
            menuBicicleta.menuMensajes(bicicletaDB.getMsg());
            dB.desconectasDB();

        }        

        

        

    }
    public void buscarDatosMotosBasedeDatos(){

        if(motoDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            motoDB.buscarProducto(dB); //llama a base de datos
            menuMotocicleta.menuMensajes(motoDB.getMsg());
            dB.desconectasDB();

        }        

        

        

    }

    public void buscarDatosClienteBasedeDatos(){

        if(clienteDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            clienteDB.buscarProducto(dB); //llama a base de datos
            menuCliente.menuMensajes(clienteDB.getMsg());
            dB.desconectasDB();

        }        

        

        

    }

    public void buscarDatosIntencionBasedeDatos(){

        if(intencionDB.getEsAsignado()){

            dB.conectarDB(dB.getNombreUsuario(), dB.getPassword());
            intencionDB.buscarProducto(dB); //llama a base de datos
            menuIntencionCompra.menuMensajes(intencionDB.getMsg());
            dB.desconectasDB();
        } 

    }

//--------------------------------------------------------------




    //GETTER

    

    //SETTER



    
}
