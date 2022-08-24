package modelo;



//interfaz funciones del modelo.

public interface EcoDosRuedas {

    void ingresarProducto(BaseDeDatos unaDb);
    void eliminarProducto(BaseDeDatos unaDb);
    void actualizarProducto(BaseDeDatos unaDb);
    void buscarProducto(BaseDeDatos unaDb);

    

    
}
