/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Porductos;

import dao.ProductoDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import model.Producto;

/**
 *
 * @author VSPC
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ProductoDao dao = new ProductoDao();
        
        ArrayList<Producto> productos =dao.select();//listado de productos original
        
        
        System.out.println("CATALOGO DE PRODUCTOS ORIGINAL: ");
        
        pintarLista(productos);
        
        
        //-----------------------------------------------------------------------
        
        Ordenaciones servicioOrdenaciones = new Ordenaciones();
        
        ArrayList<Producto> productosCopia = (ArrayList<Producto>)productos.clone();
        
        //-----Ordenar por nombre
        Collections.sort(productosCopia);
        
        System.out.println("CATALOGO ORDEENADOS POR NOMBRE");
        pintarLista(productosCopia);
        
        
        
        //--------------------------LLAMARLOS ORDENADOS POR CADA ACOMPARADOR----
        System.out.println("ALTO");
        productosCopia = servicioOrdenaciones.ordenarAltoProducto(productos);
        pintarLista(productosCopia);
        
        System.out.println("ANCHO");
        productosCopia = servicioOrdenaciones.ordenarAnchoProducto(productos);
        pintarLista(productosCopia);
        
        System.out.println("LARGO");
        productosCopia= servicioOrdenaciones.ordenarLargoProducto(productos);
        pintarLista(productosCopia);
    }

    private static void pintarLista(ArrayList<Producto> lista) {
        
        for (Producto p : lista) {
            System.out.println(p);
        }
    }
    
}
