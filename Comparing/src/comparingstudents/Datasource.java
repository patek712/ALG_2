/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vojta
 */
public class Datasource {
    private static Student[] data = {
      new Student("Alice", "Mala", 345,1,2,3,2),
      new Student("Bob", "Velky", 123,1,1,2,1),
      new Student("Cyril", "Stredny", 567,3,3,2,3)
    };
    
    public static Student[] loadDataAsArray() {
        return Arrays.copyOf(data, data.length);
    }
    
    public static List<Student> loadDataAsList(){
        return Arrays.asList(data);
        //ArrayList<Student> students = new ArrayList<>
    }

    
    
}
