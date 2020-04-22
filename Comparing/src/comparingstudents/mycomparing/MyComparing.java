/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents.mycomparing;

/**
 *
 * @author vojta
 */
public class MyComparing {
    public static void sort(Object[] array, ComparatorInterface o){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-1; j++) {
              if(o.bigger(array[j-1], array[j])){
                  Object temp = array[j];
                  array[j] = array[j-1];
                  array[j-1] = temp;
              }
                
                
            }
            
        }
        
    }
    
}
