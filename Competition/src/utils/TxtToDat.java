/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.Runner;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vojta
 */
public class TxtToDat {
     public static void txtToDat(String filename) throws IOException {
        if (filename.contains("start")) {
            ArrayList<Runner> runners = new ArrayList<>();
            File startFile = new File(dataDirectory,filename);
            try (BufferedReader inStart = new BufferedReader(new FileReader(startFile))) {
                String line;
                while ((line = inStart.readLine()) != null) {
                    String[] parts = line.split("[ ]+");
                    int number = Integer.parseInt(parts[0]);
                    String firstname = parts[1];
                    String lastname = parts[2];
                    String startTime = parts[3];
                    Runner r = new Runner(number, firstname, lastname);
                    r.setStartTime(startTime);
                    runners.add(r);
                }
            }
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("start.dat"))) {
                for (Runner runner : runners) {
                    dos.writeInt(runner.getNumber());
                    dos.writeUTF(runner.getFirstname());
                    dos.writeUTF(runner.getLastname());
                    dos.writeUTF(runner.getStartTimeString());
                }
            }
        } else {
            ArrayList<RunnerFinish> runnersFinish = new ArrayList<>();
            File finishFile = new File(dataDirectory,filename);
            try (BufferedReader inFinish = new BufferedReader(new FileReader(finishFile))) {
                String line;
                while ((line = inFinish.readLine()) != null) { //102 10:02:00:000
                    String[] parts = line.split("[ ]+");
                    int number = Integer.parseInt(parts[0]);
                    String finishTime = parts[1];
                    RunnerFinish rf = new RunnerFinish(number);
                    rf.setFinishTime(finishTime);
                    runnersFinish.add(rf);
                }
            }
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("finish.dat"))) {
                for (RunnerFinish runner : runnersFinish) {
                    dos.writeInt(runner.getNumber());
                    dos.writeUTF(runner.getFinishTimeString());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            txtToDat("start.txt");
            txtToDat("finish.txt");
        } catch (IOException ex) {
            System.out.println("Takovy soubor neexistuje.");
        }
        
    }
    
}
