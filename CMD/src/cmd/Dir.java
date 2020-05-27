/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author vojta
 */
public class Dir extends Command {

  
    @Override
    public Proces execute(File actualDir) {
        File[] files;
        if(params.length == 1){
            files = actualDir.listFiles();
            return new Proces(actualDir, dirToString(files));
        } else if (params.length == 2) {
            if (params[1].equals("-o")) {
                files = actualDir.listFiles();
                Arrays.sort(files);
                return new Proces(actualDir, dirToString(files));
            } else {
                return new Proces(actualDir, "Nevalidni příkaz\n");
            }
        } else if (params.length == 3) {
            if (params[1].equals("-e")) {
                String extension = params[2];
                FileFilter f = (File pathname) -> pathname.getName().endsWith(extension);
                files = actualDir.listFiles(f);
                return new Proces(actualDir, dirToString(files));
            } else if (params[1].equals("-s")) {
                int size = Integer.parseInt(params[2]);
                FileFilter ff = (File pathname) -> pathname.length()>size;
                files = actualDir.listFiles(ff);
                return new Proces(actualDir, dirToString(files));
            } else{
                return new Proces(actualDir, "Nevalidní příkaz\n");
            }
        } else{
            return new Proces(actualDir, "Nevalidní příkaz\n");
        }
        
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if(file.isDirectory()){
                sb.append(String.format("%s\n", file.getName()));
            } else {
                sb.append(String.format("%-20s%6d%\n", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }
    
}
