/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parkingalcala.dao;

import es.daw.parkingalcala.model.ParkingPrivado;
import es.daw.parkingalcala.model.ParkingPublico;
import es.daw.parkingalcala.model.Profitable;
import java.util.ArrayList;

/**
 *
 * @author VSPC
 */
public class ParkingDAO {
    private final ArrayList<Profitable> parkings = new ArrayList<>();
    
    public ParkingDAO(){
        
        ParkingPublico ppubl = new ParkingPublico(1, "P PUBLI 1", "Camino de la Esgaravita", 5);
        ParkingPublico ppubl2 = new ParkingPublico(2, "P PUBLI 2", "Camino de la Esgaravita 2", 3);
        
        ParkingPrivado priv = new ParkingPrivado(1, 5, "P PRIVADO 1", "Dir 1");
        ParkingPrivado priv2 = new ParkingPrivado(2, "P PRIVADO 2", "Dir 2", 2);
        
        parkings.add(ppubl);
        parkings.add(ppubl2);
        parkings.add(priv);
        parkings.add(priv2);
        
    }
    public ArrayList<Profitable> select(){
        return (ArrayList<Profitable>) parkings.clone();
    }
    
}
