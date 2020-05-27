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
public class Tdir extends Command {

    @Override
    public Proces execute(File actualDir) {
        return new Proces(actualDir, getCommonRoot(actualDir,0));
    }

    private String getCommonRoot(File parent, int layer) {
        String commonRoot = "";
        File[] files = parent.listFiles();
        for (File file : files) {
            for (int i = 0; i < layer; i++) {
                commonRoot += " ";
            }
            commonRoot += ("-" + file.getName() + "\n");
            if (file.isDirectory()) {
                commonRoot += getCommonRoot(file, layer + 1);
            }
        }
        return commonRoot;
    }
    
}
