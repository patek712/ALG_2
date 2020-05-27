/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.time.LocalDate;
import utils.MeteorologyInterface;

/**
 * Class reprezentujici objekt Pocasi. Implementuje MeteorologyInterface
 *
 * @author Vojtěch Pátek
 * @version 2.1 25/05/2020
 * @param place - String reprezentujici misto
 * @param temperature - double reprezentujici teplotu
 * @param precipitation - double reptezentujici srazky
 * @param clouds - String reprezentujici oblacnost
 * @param wind - double reprezentujici rychlost vetru
 * @param date - LocalDate - datum
 */
public class Pocasi implements MeteorologyInterface {

    private String place;
    private double temperature;
    private double precipitation;
    private String clouds;
    private double wind;
    private LocalDate date;

    public Pocasi(String place, double temperature, double precipitation, String clouds, double wind, LocalDate date) {
        this.place = place;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.clouds = clouds;
        this.wind = wind;
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public String getClouds() {
        return clouds;
    }

    public double getWind() {
        return wind;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20.2f %-20.2f %-20s %-20.2f %-20s", place, temperature, precipitation, clouds, wind, date);
    }

    @Override
    public boolean compareByPrecipitation(MeteorologyInterface o) {
        return this.precipitation > ((Pocasi) o).precipitation;
    }

    @Override
    public boolean compareByTemperature(MeteorologyInterface o) {
        return this.temperature > ((Pocasi) o).temperature;
    }

    @Override
    public String getPocasi() {
        StringBuilder pocasi = new StringBuilder();
        pocasi.append(toString());
        pocasi.append("\n");
        return pocasi.toString();

    }

}
