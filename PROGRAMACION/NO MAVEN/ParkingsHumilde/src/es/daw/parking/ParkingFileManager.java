/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.parking;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.daw.parking.model.Parking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author VSPC
 */
//PROCEDO A CAMBIAR ESTOS METODOS A GSON ACOTUALIZANDOLOS CAMBIANDO ALGUNAS COSAS DEJARE AQUI LOS CAMBIOS DE LOS NOMBRES: 

public class ParkingFileManager {
    
    /*
    public static ArrayList<Parking> readParkingsFromCSV(String filename){
        ArrayList<Parking> parkings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine())!=null){
                String[] data = line.split(",");
                Parking parking = new Parking(data[0].trim(), Integer.parseInt(data[1].trim()), Integer.parseInt(data[2].trim()), Integer.parseInt(data[3].trim()), Integer.parseInt(data[4].trim()));
                parkings.add(parking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parkings;
    }
    public static void writeParkingsToCSV(String filename, ArrayList<Parking> parkings) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Parking parking : parkings) {
                bw.write(parking.getNombre() + "," + parking.getPlazasCoches() + "," + parking.getPlazasMotos() + "," + parking.getPlazasFurgonetas() + "," + parking.getPlazasCamiones());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    
    public static ArrayList<Parking> readParkingsFromJSON(String filename) {
        ArrayList<Parking> parkings = new ArrayList<>();
        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            Type parkingListType = new TypeToken<ArrayList<Parking>>(){}.getType();
            parkings = gson.fromJson(reader, parkingListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parkings;
    }

    public static void writeParkingsToJSON(String filename, ArrayList<Parking> parkings) {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new Gson();
            gson.toJson(parkings, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
