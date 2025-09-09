/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasiterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author VSPC
 */
public class PruebasITERATOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        System.out.println("EJEMPLO");
        
        List<Integer> listInt= new ArrayList<>(Arrays.asList(1,5,4,1,2));
        
        System.out.println("Lista"+listInt);
        Iterator<Integer> it2 = listInt.iterator();
        
        while(it2.hasNext()){
            int item = it2.next();
            if(item %2 ==0)
                it2.remove();
        }
        System.out.println("Lista sin pares"+listInt);
                }
    
}
