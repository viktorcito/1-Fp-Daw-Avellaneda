/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.poo.tiendaOrdenadores;

import es.daw.poo.tiendaOrdenadores.model.Ordenador;
import es.daw.poo.tiendaOrdenadores.model.Portatil;
import es.daw.poo.tiendaOrdenadores.model.Sobremesa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author VSPC
 */
public class tiendaApp {
    
    static List<Ordenador> listaOrdenadores;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        listaOrdenadores = new ArrayList<>();
        
        Portatil p1 = new Portatil (1.5f,"ASUS TUF",800);
        Portatil p2 = new Portatil (1.7f,"hp",1100);
        Sobremesa s1 = new Sobremesa("torre compacta","lenovo",1000);
        Sobremesa s2 = new Sobremesa("torre gamer","dell",1200);
        
        listaOrdenadores = new ArrayList<>(Arrays.asList(p1,p2,s1,s2));
        
        printList();
        
        deleteByCode("hp");
        System.out.println("Despues de borrar...");
        printList();
    }
    
    public static void printList(){
        System.out.println("*****LISTADO DE ORDENADORES*****");
        listaOrdenadores.forEach(System.out::println);
    }
    
    
    private static void printListByNaturalOrder(){
        listaOrdenadores.sort(Comparator.naturalOrder());
        
        System.out.println("*****Listado de ordenadores ordenados de forma natural (codigo)****");
        listaOrdenadores.forEach(System.out::println);
    }
    
    
    private static void printListByPrice(){
        listaOrdenadores.sort((o1,o2) -> Float.compare(o1.getPrecio(), o2.getPrecio()));
                
                System.out.println("Listado por preciooooooooo");
                listaOrdenadores.forEach(System.out::println);
    }
    
    private static void deleteByCode (String code){
        
        Iterator<Ordenador>it = listaOrdenadores.iterator();
        
        while(it.hasNext()){
            Ordenador o = it.next();
            if (o.getCodigo().contains(code))
                it.remove();
        }
    }
    
}
