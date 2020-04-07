/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vojtěch Pátek
 */
public class Fraction {
   //data  
   private int num;
   private int den;
   
   //constructor
   public Fraction(int num, int den) {
       if (den == 0) {
           throw new IllegalArgumentException("Denominator must not be 0!");
       }
       this.num = num;
       this.den = den;
   }

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

    @Override
    public String toString() {
        return "{"+ num + "/" + den + '}';
    }
    
    private int euclid(){
        int u = this.num;
        int w = this.den;
        int r = 0;
        while (w != 0){
        r = u % w;
        u = w;
        w = r;
        }
        return u;
     
    }
    
    public Fraction simplify(){
        Fraction help = new Fraction(this.num,this.den);
        return new Fraction(this.num/help.euclid(),this.den/help.euclid());
    }

    
    

   
   
   
}
