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
public class Help extends Command {

    @Override
    public Proces execute(File actualDir) {
        
        String help = "HELP\n" + String.format("%-7s %s\n", "help", "Display help")
                + String.format("%-7s %s\n", "help", "Display help")
                + String.format("%-7s %s\n", "dir", "Display list of files and folders")
                + String.format("%-7s %s%n", "dir [-o]", "Display an ordered list of files and folders")
                + String.format("%-7s %s%n", "dir [-e] [file extension]", "Display a list of files and folders with a specified extension")
                + String.format("%-7s %s%n", "dir [-s] [size]", "Display a list of files and folders bigger than a specified size")
                + String.format("%-7s %s%n", "cd ..", "Change directory - move to the folder one level higher")
                + String.format("%-7s %s%n", "cd [folder name]", "Change directory - move to a specific folder")
                + String.format("%-7s %s%n", "mkdir [folder name]", "Create new folder")
                + String.format("%-7s %s%n", "rename [nameFrom] [nameTo]", "Rename folder or file")
                + String.format("%-7s %s%n", "exit", "End CMD")
                + String.format("%-7s %s%n", "tdir", "Display tree of files");
        return new Proces(actualDir, help);
    }
}
