/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynoms;

/**
 *
 * @author vojta
 */
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vojta
 */
public class Polynom {

    //data
    //5x3 + 3x2 + 6 -> [6 0 3 5]
    private double[] coef;

    //constructors
    //[6 0 3 5]
    //[5 3 0 6]
    private Polynom(double[] coef) {
        double[] coefTemp = new double[coef.length]; //defenzivní kopie - aby se uživatel nedostal k hodnotám pole
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coef;
    }

    //tovární metoda(factory method)
    public static Polynom getInstanceReverted(double... coef) { //[6 0 3 5]
        return new Polynom(coef);
    }

    public static Polynom getInstance(double... coef) { //[5 3 0 6]
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coefTemp.length; i++) {
            coefTemp[coefTemp.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);
    }

    //metody
    //DÚ1: metoda, kde pro polynom počítám řešení pro zadané x a polynom rozepsat pomocí Horner. schéma
    public double computeVal(double x) {
        double[] coefTemp = coef;
        double res = coefTemp[0];
        for (int i = 1; i < coefTemp.length; i++) {
            res = res * x + coefTemp[i];
        }
        return res;
    }

    //getter
    public double getCoefAt(int exponent) {
        return coef[exponent];
    }

    public double[] getAllCoef() {
        return Arrays.copyOf(coef, coef.length);
    }

    public int getDegree() {
        return coef.length - 1;
    }

    public int getLength() {
        return coef.length;
    }

    @Override
    public String toString() {
        //return "Polynom{coef=" + Arrays.toString(coef) + "}";
        String coeficients = Arrays.toString(coef);
        return "Polynom{" + "coef = " + coeficients + '}';
    }

    //DÚ2.: matematicky správný výpis 5x^3 + ...
    public String toStringMath() {
        String mathPol = "";
        for (int i = 0; i < coef.length - 1; i++) {
            if (coef[i] != 0) {
                mathPol = mathPol + " " + coef[i] + "x^" + (coef.length - 1 - i) + " +";
            }
        }
        mathPol = mathPol + " " + coef[coef.length - 1];
        return mathPol;
    }

    //derivace
    //5x^3 -> 15x^2
    public Polynom derivate() {
        double[] coefD = new double[coef.length - 1];
        for (int i = 0; i < coefD.length; i++) {
            coefD[i] = coef[i] * (coef.length - 1 - i);
        }
        return new Polynom(coefD);
    }

    //bonusova uloha: integral na zadaném rozsahu a,b
    public double integrate(int a,int b) {
       double[] coefI = new double[coef.length];
       for (int i = 0; i < coefI.length; i++) {
           coefI[i] = coef[i]/(coef.length - i);
       }
       Polynom integral = new Polynom(coefI);
       double result = integral.computeVal(b) - integral.computeVal(a);
       return result;
    }
    
    public static void main(String[] args) {
        double[] a = {6, 1, 3, 5};
        Polynom p1 = Polynom.getInstance(a);
        /*System.out.println(p1.toString());
        System.out.println(p1.getCoefAt(3));
        System.out.println(p1.derivate());
        System.out.println(p1.computeVal(3));*/
        System.out.println(p1.toStringMath());
        
        System.out.println(p1.integrate(1, 2));
    }

}
