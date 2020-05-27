/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 * Interface implementovany v obejktu Pocasi. Obsahuje metody, ktere se
 * pouzivaji v hlavni aplikaci.
 *
 * @author Vojtěch Pátek
 * @version 2.1 25/05/2020
 * @param compareByPrecipitation - metoda pro porovnani dvou objektu typu Pocasi
 * podle srazek
 * @param compareByTemperature - metoda pro porovnani dvou objektu typu Pocasi
 * podle teploty
 * @param getPocasi - metoda pro vypis dat z objektu pocasi pomoci
 * StringBuilderu. Vraci data jako String.
 */
public interface MeteorologyInterface {

    boolean compareByPrecipitation(MeteorologyInterface o);

    boolean compareByTemperature(MeteorologyInterface o);

    String getPocasi();
}
