/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.ArrayList;

/**
 *
 * @author vojta.patek
 */
public abstract class Client {

    private String name;
    private ArrayList<Account> accounts = new ArrayList();

    public Client(String name) {
        this.name = name;
    }
    
    public void AddAcount(double ammount) {
        this.accounts.add(new Account(ammount));
    }
    
    public double SumOfAllMoney() {
        double sum = 0;
        for (Account account : accounts) {
            sum += account.getCoin();
        }
        return sum;
    }
    
    public abstract String ClientName();

    
}
