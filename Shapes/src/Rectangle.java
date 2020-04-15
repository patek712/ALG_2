/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * immutable object
 * @author vojta
 */
public class Rectangle extends Shape {
    // data
    private double a;
    private double b;
    private double area; //vypocitana - muzeme udelat u nemennych promennych

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getArea() {
        return area;
    }
    
    @Override
    public double computeArea() {
        return area;
    }
    
    
    private double area(){
        return a*b;
    }

    @Override
    public String toString() {
        //return "Rectangle{" + "a=" + a + ", b=" + b + '}';
        return super.toString() + String.format(" a = %.2f, b = %.2f", a, b);
    }
    
    //methods

    

    
    
}
