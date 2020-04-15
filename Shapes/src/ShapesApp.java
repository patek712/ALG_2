
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vojta.patek
 */
public class ShapesApp {

    
    
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Shape> shapes = new ArrayList<>();
    
    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    clearObjects();
                    break;
                case 2:
                    addSquare();
                    break;
                case 3:
                    addRectangle();
                    break;
                case 4:
                    addCircle();
                    break;
                case 5:
                    printObjects();
                    break;
                case 6:
                    computeArea();
                    break;
                case 7:
                    findWithMaxArea();
                    break;
                case 8:
                    sortByArea();
                    break;
             
                default:
                    System.out.println("Chybna volba");
            }
        } while (choice != 0);

    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("1. Nova sada");
        System.out.println("2. Pridej ctverec");
        System.out.println("3. Pridej obdelnik");
        System.out.println("4. Pridej kruh");
        System.out.println("5. Vypis geometricke utvary");
        System.out.println("6. Vypocti celkovou plochu");
        System.out.println("7. Vypis utvar s najvetsi plochou");
        System.out.println("8. Setřiď útvary podle plochy");
        System.out.println("0. Konec programu");
    }
    
    //TODO
    private static int readChoice() {
        System.out.println("Zvolte, co chcete udělat:");
        int choice = sc.nextInt();
        return choice;
    }
    
    //TODO umozni zadat novou sadu utvaru
    private static void clearObjects() {
        shapes.clear();
    }
    
    //TODO Square IS A Rectangle
    private static void addSquare() {
        System.out.println("Zadejte stranu čtverce:");
        double a = sc.nextDouble();
        shapes.add(new Square(a,a));  
    }
    
    //TODO
    private static void addRectangle() {
        System.out.println("Zadejte stranu a:");
        double a = sc.nextDouble();
        System.out.println("Zadejte stranu b:");
        double b = sc.nextDouble();
        shapes.add(new Rectangle(a,b));
    }
    
    //TODO
    private static void addCircle() {
        System.out.println("Zadejte poloměr kruhu:");
        double r = sc.nextDouble();
        shapes.add(Circle.getInstanceR(r));
    }
    
    //TODO typ, rozmery, obsah o vsech
    private static void printObjects() {
        for(Shape shape : shapes) {
            System.out.println(shape);
        }
    }
    
    //TODO vsech dohromady
    private static void computeArea() {
        double s = 0;
        for (Shape shape : shapes) {
            s += shape.computeArea();
        }
        System.out.println(s);
    }
    
    //TODO info o objekte s max area
    private static void findWithMaxArea() {
        int ind = 0;
        double area = 0;
        for (int i = 0; i < shapes.size(); i++){
            if(shapes.get(i).computeArea() > area) {
                ind = i;
                area = shapes.get(i).computeArea();
            }
        }
        System.out.println(shapes.get(ind));
    }
    
    //TODO setridit podle plochy
    private static void sortByArea() {
        Collections.sort(shapes);
        for(Shape shape : shapes) {
            System.out.println(shape);
        }
        
           
        }
         
            
        
        
    }
    
    

    
    

