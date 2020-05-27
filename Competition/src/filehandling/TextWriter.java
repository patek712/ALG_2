/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Runner;
import filehandling.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author vojta
 */
public class TextWriter extends Writer {
    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException{
        File resultFile = new File(dataDirectory, resultFilepath);
        //try with resources - automaticky zavře soubor i když nastane chyba
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, true)))) { //append true
            //PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp1250"), true); //nasteveni kódovaní
            pw.println("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                pw.print(n + ". ");
                pw.println(runner.toString());
                n++;
            }
        }
    }
    
}
