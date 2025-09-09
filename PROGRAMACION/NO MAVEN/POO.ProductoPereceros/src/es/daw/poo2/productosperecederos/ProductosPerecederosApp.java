package es.daw.poo2.productosperecederos;

import es.daw.poo2.productosperecederos.model.Perecedero;
import es.daw.poo2.productosperecederos.model.Producto;
import es.daw.productosperecederos.dao.ProductoDAO;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 *
 * @author melol
 */
public class ProductosPerecederosApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.select();
        
        
        for (Producto p : productos) {
            System.out.println(p);
            System.out.println("Precio"+ p.calcular(5));
            
            System.out.println("Permite devolucion"+ p.permiteDevolucion());
            
            System.out.println("XML:"+ p.convert2XML());
        }
        
        System.out.println("Numero PRODUCTOS TOTALES EN ALMACEN" +productos.size());
    }
    
}
