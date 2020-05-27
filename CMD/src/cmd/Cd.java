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
public class Cd extends Command {

    @Override
    public Proces execute(File actualDir) {
        File file;
        if (params.length == 2) {
            if ("..".equals(params[1])) {
                file = new File(actualDir.getParent());
            } else {
                try {
                    file = new File(actualDir.getAbsolutePath() + "\\" + params[1]);
                } catch (Exception e) {
                    throw new RuntimeException("Slozka nenalezena.");
                }
            }
            return new Proces(file, "ok");
        } else {
            return new Proces(actualDir, "Neplatny vstup");
        }
    }

}
