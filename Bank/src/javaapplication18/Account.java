/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

/**
 *
 * @author vojta.patek
 */
public class Account {
    //data
    private double coin;

    public Account(double coin) {
        this.coin = coin;
    }

    public double getCoin() {
        return coin;
    }

    @Override
    public String toString() {
        return "Account{" + "coin=" + coin + '}';
    }
    
    public boolean vklad(double ammount){
        coin += ammount;
        return true;
    }
    
    public boolean vyber(double ammount){
        if(coin > 0){
        coin -= ammount;
        return true;
        } else {
            System.out.println("Není dostatečný zůstatek");
            return false;
        }
    }
}
