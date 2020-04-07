/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynoms;

import java.util.Scanner;

/**
 * library clas
 *
 * @author vojta
 */
public class Polynoms {

    private Polynoms() { //aby se nemohl vytvorit objekt

    }

    public static Polynom sum(Polynom a, Polynom b) {
        boolean isBigger = a.getDegree() > b.getDegree();
        Polynom max = isBigger ? a : b;
        Polynom min = isBigger ? b : a;

        double[] sumCoef = new double[max.getDegree() + 1];
        for (int i = 0; i < max.getDegree() + 1; i++) {
            sumCoef[i] = max.getCoefAt(i);

        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sumCoef[i] = sumCoef[i] + min.getCoefAt(i);

        }
        //Polynom res = Polynom.getInstanceReverted(coef);
        return null;
    }

    //DÚ 3.: součin polynomů
    public static Polynom multiply(Polynom a, Polynom b) {
        double[] res = new double[a.getLength() + b.getLength() - 1];
        for (int i = 0; i < a.getLength(); i++) {
            for (int j = 0; j < b.getLength(); j++) {
                res[i + j] += a.getCoefAt(i) * b.getCoefAt(j);

            }
        }
        Polynom result = Polynom.getInstance(res);
        return result;
    }

    public static void main(String[] args) {
        Polynom p1 = Polynom.getInstance(5, 3, 1, 6);
        Polynom p2 = Polynom.getInstance(6, 3, 1);
        p1.derivate();
        System.out.println(p1.toStringMath());
        System.out.println(p2.toStringMath());
        double y = p1.computeVal(3);
        System.out.println(y);
        Polynom c = multiply(p1, p2);
        System.out.println(c.toStringMath());

    }

}
