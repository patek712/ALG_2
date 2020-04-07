
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vojta
 */
public class FractionsCalculator {

    /**
     * @param args the command line arguments
     */
    
    public static Fraction Plus(Fraction a, Fraction b){
      
        return new Fraction((a.getNum())*(b.getDen()) + (b.getNum())*(a.getDen()) , (a.getDen())*(b.getDen())).simplify(); 
    }
    
    public static Fraction Minus(Fraction a, Fraction b){
        return new Fraction(((a.getNum())*(b.getDen()) - (b.getNum())*(a.getDen())) , (a.getDen())*(b.getDen())).simplify(); 
    }
    
    public static Fraction Multiply(Fraction a, Fraction b){
        return new Fraction((a.getNum())*(b.getNum()),(a.getDen())*(b.getDen())).simplify();
    }
    
    public static Fraction Divide(Fraction a, Fraction b){
        return new Fraction((a.getNum())*(b.getDen()),(a.getDen())*(b.getNum())).simplify();
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vítejte v programu FractionsCalculator");
        System.out.println("--------------------------------------");
        System.out.println("Zadejte zlomek: ");
        Fraction a = new Fraction(sc.nextInt(),sc.nextInt());
        System.out.println(a.toString());
        System.out.println("Zadejte druhý zlomek: ");
        Fraction b = new Fraction(sc.nextInt(),sc.nextInt());
        System.out.println(b.toString());
        System.out.println("Vyberte operaci stiknutím tlačítka: +,-,*,/");
        String choice = sc.next();
        if(choice.equals("+")){
            System.out.println((Plus(a,b)).toString());
        } else if(choice.equals("-")){
            System.out.println((Minus(a,b).toString()));
        } else if(choice.equals("*")){
            System.out.println((Multiply(a,b)).toString());
        } else if(choice.equals("/")){
            System.out.println(Divide(a,b).toString());
        } else {
            System.out.println("Neplatná volba operace");
        }
    }
    
}
