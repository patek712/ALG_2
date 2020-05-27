/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurricane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author vojta
 */
public class HurricanesData {

    private ArrayList<Hurricane> hurricanes;
    private String file;

    public HurricanesData(String file) {
        hurricanes = new ArrayList<>();
        this.file = file;
    }

    public void addHurricane(int year, String month, int pressure, int speed, String name) {
        Hurricane h = new Hurricane(year, month, pressure, speed, name);
        hurricanes.add(h);
    }

    /*public void load() throws IOException {
        hurricanes.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] rozdeleno = s.split(";");
                int year = Integer.parseInt(rozdeleno[0]);
                String month = rozdeleno[1];
                int pressure = Integer.parseInt(rozdeleno[2]);
                int speed = Integer.parseInt(rozdeleno[3]);
                String name = rozdeleno[4];
                addHurricane(year, month, pressure, speed, name);
            }

        }
    }*/
    
    public void load() throws FileNotFoundException{
        File file = new File("hurricanedata.txt");
        Scanner inFile = new Scanner(file);
        while(inFile.hasNext()){
            int year = inFile.nextInt();
            String month = inFile.next();
            int pressure = inFile.nextInt();
            int speed = inFile.nextInt();
            String name = inFile.next();
            Hurricane h = new Hurricane(year,month,pressure,speed,name);
            hurricanes.add(h);
        }
    }
    
     public String getHurricanesByPeriod(int yearFrom, int yearTo) {
        StringBuilder sb = new StringBuilder("");
        if(yearFrom != Integer.MIN_VALUE){
           sb.append(String.format("Huricany od roku %d do roku %d:\n",yearFrom, yearTo)); 
        }
        sb.append(String.format("%15s %15s %15s %15s %15s\n","name","year","month","pressure[hPa]","speed[kn]"));
        for (Hurricane hurricane : hurricanes) {
            if(hurricane.getYear() >= yearFrom && hurricane.getYear() <= yearTo){
                sb.append(hurricane);
                sb.append("\n");
            }
        }
        return sb.toString();
     }
     
     
     public String getCategoryAndSpeed(String name) {
        for (Hurricane hurricane : hurricanes) {
            if(hurricane.getName().equals(name)){
                return String.format("%10s: %15s, rychlost: %4.2f km/h",name,hurricane.cathegory(),hurricane.speedInKmh());
            }
        }
        return "Neplatný vstup";
    }
     
      public void sortBySpeed() {
        Collections.sort(hurricanes, Comparator.comparingDouble(Hurricane::speedInKmh));
        for (int i = 0; i < (hurricanes.size()); i++) {
            System.out.println((hurricanes.get(i)).toString());
        }

    }
     
}
