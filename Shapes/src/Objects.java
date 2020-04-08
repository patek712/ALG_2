
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vojta
 */
public class Objects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = new Rectangle(2 , 3);
        Circle c2 = Circle.getInstanceR(2.6);
        
        System.out.println("1.varianta");
        double allArea1 = c1.computeArea() + c2.computeArea() + r1.getArea();
        System.out.println(allArea1);
        
        System.out.println("2.varianta");
        ArrayList shapes2 = new ArrayList(); //dynamicke pole objektu typu Object
        //muze obsahovat cokoliv, co je typove kombatibilni s object
        shapes2.add(c1);
        shapes2.add(c2);
        shapes2.add(r1);
        
        double allArea2 = 0;
        for (int i = 0; i < shapes2.size(); i++) {
            if (shapes2.get(i) instanceof Circle){
            allArea2 += ((Circle)shapes2.get(i)).computeArea();
            } else if (shapes2.get(i) instanceof Rectangle){
                allArea2 += ((Rectangle)shapes2.get(i)).computeArea();
            }
        }
        System.out.println(allArea2);
        
        System.out.println("3.varianta");
        ArrayList<Shape> shapes3 = new ArrayList<>(); //dynamicke pole objektu typu Shape
        //muze obsahovat cokoliv, co je typove kompatibilni s Shape
        shapes3.add(c1);
        shapes3.add(c2);
        shapes3.add(r1);
        double allArea3 = 0;
        for (Shape shape : shapes3) { //foreach
            allArea3 += shape.computeArea(); //polymorfismus
        }
        System.out.println(allArea3);
    }
    
}
