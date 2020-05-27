/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Objekt reprezentujici data a odkaz na soubor
 *
 * @author Vojtěch Pátek
 * @version 2.1 25/05/2020
 * @param pocasiData - ArrayList typu Pocasi, obsahujici data
 * @param file - String obsahujici odkaz na soubor s daty
 */
public class Data {

    private static ArrayList<Pocasi> pocasiData;
    private String file;

    public Data(String file) {
        pocasiData = new ArrayList<>();
        this.file = file;
    }

    public void pridejPocasi(String place, double temperature, double precipitation, String clouds, double wind, LocalDate date) {
        Pocasi p = new Pocasi(place, temperature, precipitation, clouds, wind, date);
        pocasiData.add(p);
    }

    @Override
    public String toString() {
        return "Data{" + "pocasiData=" + pocasiData + '}';
    }

    /**
     * Metoda pro ukladani dat do souboru pomoci BufferedWriteru
     *
     * @throws IOException
     */
    public void uloz() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Pocasi p : pocasiData) {
                String[] hodnoty = {p.getPlace(), String.valueOf(p.getTemperature()), String.valueOf(p.getPrecipitation()), p.getClouds(), String.valueOf(p.getWind()), String.valueOf(p.getDate())};
                String radek = String.join(";", hodnoty);
                bw.append(radek);
                bw.append("\n");
            }
            bw.flush();

        }

    }

    /**
     * Metoda pro nacitani dat ze souboru pomoci BufferedWritteru
     *
     * @throws IOException
     */
    public void nacti() throws IOException {
        pocasiData.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] rozdeleno = s.split(";");
                String place = rozdeleno[0];
                double temperature = Double.parseDouble(rozdeleno[1]);
                double precipitation = Double.parseDouble(rozdeleno[2]);
                String clouds = rozdeleno[3];
                double wind = Double.parseDouble(rozdeleno[4]);
                LocalDate date = LocalDate.parse(rozdeleno[5]);
                pridejPocasi(place, temperature, precipitation, clouds, wind, date);

            }
        }
    }

    /**
     * Tovarni metoda pro nacitani dat z jinych trid
     *
     * @return vraci data jako ArrayList
     */
    public static ArrayList<Pocasi> loadDataAsArrayList() {
        return (ArrayList<Pocasi>) pocasiData.clone();
    }

}
