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
public class CmdEditor implements CmdInterface {
    private boolean isRunning;
    private File actualDir;
    private Command command;
    
    public CmdEditor(){
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }

    @Override
    public boolean isRunning() {
        return isRunning; 
    }

    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        Proces p = command.execute(actualDir);
        actualDir = p.getActualDir();
        //execute
        //isRunning = false;
        if (actualDir == null) {
            isRunning = false;
        }
        return p.getMessage();
    }
    
}
