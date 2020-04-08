/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vojta
 */
public class Circle extends Shape { //Circle je typove kompatibilni s Shape, Circle IS A Shape
    //data
    private double r;

    private Circle(double r) {
        this.r = r;
    }
    
    //abych mohl brát jako vstup průměr, udělám tovární metody
    public static Circle getInstanceD(double d){
       return new Circle(d/2);
    }
    
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }
    
    //methods
    @Override
    public double computeArea(){
        return Math.PI*r*r;
    }
    
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceR(4);
        System.out.println(c1);
        System.out.println(c1.computeArea());
    }
    
    
}
