/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

/**
 *
 * @author vojta
 */
public class Parser {

    public static Command parse(String line) { //dir -e .java
        String[] p = line.split(" +"); //p[0] dir; p[1] -e p[2] .java
        //TODO prazdny prikaz
        char first = Character.toUpperCase(p[0].charAt(0)); //D
        String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1);
        try {
            Class c = Class.forName(name);
            Command command = (Command) c.newInstance();
            command.setParams(p);
            return command;
        } catch (Exception e){
            throw new RuntimeException("Nepodařilo se prikaz naparsovat");
        }
    }
}
