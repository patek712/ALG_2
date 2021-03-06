/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Runner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vojta
 */
public abstract class Reader {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    
    public abstract ArrayList<Runner> getList(String filename, ArrayList<Runner> runners) throws IOException;
    
}
