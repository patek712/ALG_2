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
public class Exit extends Command {

    @Override
    public Proces execute(File actualDir) {
        return new Proces(null,"Konec\n");
    }
    
}
