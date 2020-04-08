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
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList();
        clients.add(new Person("Pekar"));
        clients.add(new Person("Svecova"));
        clients.add(new Company("Skoda"));
        clients.get(0).AddAcount(1000);
        clients.get(0).AddAcount(500);
        clients.get(1).AddAcount(1200);
        clients.get(2).AddAcount(120);
        for (Client client : clients) {
            System.out.println(client.ClientName() + ": " + client.SumOfAllMoney() + " Kč");
        }
        
    }
    
}
