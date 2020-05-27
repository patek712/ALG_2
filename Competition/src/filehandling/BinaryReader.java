/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Runner;
import filehandling.Writer.dataDirectory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author vojta
 */
public class BinaryReader extends Reader {
     @Override
    public ArrayList<Runner> getList(String filename, ArrayList<Runner> runners) throws IOException {
        if (filename.contains("start")) {
            File sfile = new File(dataDirectory,filename);
            try (DataInputStream dis = new DataInputStream(new FileInputStream(sfile))) {
                boolean isEnd = false;
                while (!isEnd) {
                    try {
                        int number = dis.readInt();
                        String firstname = dis.readUTF();
                        String lastname = dis.readUTF();
                        String startTime = dis.readUTF();
                        Runner r = new Runner (number, firstname, lastname);
                        r.setStartTime(startTime);
                        runners.add(r);
                    } catch (EOFException e) {
                        isEnd = true;
                    }
                }
            }
        } else {
            File ffile = new File(dataDirectory,filename);
            try (DataInputStream dis = new DataInputStream(new FileInputStream(ffile))) {
                boolean isEnd = false;
                while (!isEnd) {
                    try {
                        int number = dis.readInt();
                        String finishTime = dis.readUTF();
                        Runner r = findRunner(number,runners);
                        r.setFinishTime(finishTime);
                    } catch (EOFException e) {
                        isEnd = true;
                    }
                }
            }
        }
        return runners;
    }
    
    private Runner findRunner(int number, ArrayList<Runner>runners) {
        for (Runner runner : runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl na startu.");
    }
   
    
}
