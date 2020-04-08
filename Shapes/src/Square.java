/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vojta
 */
public class Square extends Rectangle {
    // data
    

    public Square(double a, double b) {
        super(a, b);
    }

    

    public static Square getInstance(double a){
        return new Square(a,a);
    }

    

  
    
   
    
    
}
