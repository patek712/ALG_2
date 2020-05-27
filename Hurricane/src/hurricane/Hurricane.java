/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurricane;

/**
 *
 * @author vojta
 */
public class Hurricane implements Comparable<Hurricane> {
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;

    public Hurricane(int year, String month, int pressure, int speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
    
    

    @Override
    public int compareTo(Hurricane h) {
         if(this.speed > h.speed){
             return 1;
         } else if(this.speed == h.speed){
             return 0;
         } else {
             return -1;
         }
    }
    
    public double speedInKmh(){
        double speedKmh = speed * 1.852;
        return speedKmh;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-10s %-10d %-20d %-15s", year, month, pressure, speed, name);
    }
    
    public String cathegory(){
        double speed = speedInKmh();
        if (speed < 154){
            return "Category 1";
        }else if(speed < 178){
            return "Category 2";
        }else if(speed < 209){
            return "Category 3";
        }else if(speed < 252){
            return "Category 4";
        }else{
            return "Category 5";
        }
                
    }
    
    
    
}
