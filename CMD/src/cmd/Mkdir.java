/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author vojta
 */
public class Mkdir extends Command{

    @Override
    public Proces execute(File actualDir) {
         if (params.length == 2) {
            File file = new File(actualDir.getAbsolutePath() + "\\" + params[1]);
            file.mkdir();
            return new Proces(actualDir, "Soubor vytvořen\n");

        } else {
            return new Proces(actualDir, "Nevalidní příkaz\n");
        }
        
    }
    
}
