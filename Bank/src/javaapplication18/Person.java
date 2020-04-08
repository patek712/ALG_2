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
public class Person extends Client {
    private String name;
    
    public Person(String name) {
        super(name);
        this.name = name;
    }


    @Override
    public String ClientName() {
        String end = name.substring(name.length()-3);
        if("ova".equals(end)){
            return "paní " + name;
        } else {
            return "pan " + name;
        }
    }
    
    
    
}
