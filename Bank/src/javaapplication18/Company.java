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
public class Company extends Client {
    
    private String name;
    
    public Company(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String ClientName() {
        return "firma " + name;
    }
    
}
