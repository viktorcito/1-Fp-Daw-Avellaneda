/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Porductos;

import java.util.ArrayList;
import model.Producto;

/**
 *
 * @author VSPC
 */
public class Ordenaciones {
    
    private ArrayList<Producto> listaClonada;
    
    public ArrayList<Producto> ordenarAltoProducto(ArrayList<Producto> coleccion){
        
        listaClonada = (ArrayList<Producto>) coleccion.clone();
        
        listaClonada.sort((pa,pb) -> Integer.compare(pb.getAlto(),pa.getAlto()));
        
        
        
        return listaClonada;
    }
    
    
    public ArrayList<Producto> ordenarAnchoProducto(ArrayList<Producto> coleccion){
        
        listaClonada= (ArrayList<Producto>) coleccion.clone();
        
        listaClonada.sort((pa,pb)-> Integer.compare(pb.getAncho(), pa.getAncho()));
        
        
        return listaClonada;
        
    }
    
      public ArrayList<Producto> ordenarLargoProducto(ArrayList<Producto> coleccion){
    
          listaClonada= (ArrayList<Producto>) coleccion.clone();
          listaClonada.sort((pa,pb) -> Integer.compare(pb.getLargo(),pa.getLargo()));
          
          return listaClonada;
          
    }
      
}
