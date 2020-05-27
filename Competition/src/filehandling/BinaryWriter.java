/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Runner;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author vojta
 */
public class BinaryWriter extends Writer {
    @Override
    public void saveResults(String resultFilename, List<Runner> runners) throws IOException {
        File resultFile = new File(dataDirectory, resultFilename);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFile))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                dos.writeInt(n);
                //dos.writeChar('.');
                dos.writeUTF(runner.getFirstname());
                //tatkto funguje writeUTF
                int nChars = runner.getLastname().length();
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(runner.getLastname().charAt(i));
                }
                //
                dos.writeLong(runner.runningTime().toNanoOfDay());
                n++;
            }
        }
    }

    
    
}
