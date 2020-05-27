/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ui.Data;
import ui.Pocasi;

/**
 * uzivatelske rozhrani pro manipulaci s daty
 *
 * @author Vojtěch Pátek
 * @version 2.1 25/05/2020
 * @param data - objekt typu Data, kam nahravame data + sparovani se souborem
 * @param dataFiltered - ArrayList obsahujici objekty typu Pocasi, ktery
 * pouzivame pro trideni a filtrovani, abychom neprepisovali data v puvodni
 * databazi.
 */
public class MeteorologyApp {

    public static Data data = new Data("D:\\NetBeans\\Projects\\ALP2\\Semestrální_práce\\CZ_MeteorologyApp\\data\\pocasi.csv");
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Pocasi> dataFiltered;

    /**
     * main obsahuje pouze výběr metod pro manipulaci s daty
     */
    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    uploadData();
                    break;
                case 2:
                    addData();
                    break;
                case 3:
                    readData();
                    break;
                case 4:
                    sortByPrecipitation();
                    break;
                case 5:
                    sortByTemperature();
                    break;
                case 6:
                    filterByPlace();
                    break;
                case 7:
                    deleteData();
                    break;
                case 8:
                    sortByDate();
                    break;
                case 9:
                    sendDataEmail();
                    break;
                default:
                    System.out.println("Neplatna volba");
            }
        } while (choice != 0);

    }

    /**
     * Metoda pro vypsani hlavniho menu na standardni vystup
     */
    private static void displayMenu() {
        System.out.println("*****************************************************************************************************************************");
        System.out.println("");
        System.out.println("1. Načíst data ze souboru");
        System.out.println("2. Přidat data");
        System.out.println("3. Zobrazit data(zruší filtry)");
        System.out.println("4. Setřídit podle srážek");
        System.out.println("5. Setřídit podle teploty");
        System.out.println("6. Filtrovat podle místa");
        System.out.println("7. Vymazat data");
        System.out.println("8. Setřídit podle datumu");
        System.out.println("9. Poslat data na e-mail");
        System.out.println("0. Konec programu");
        System.out.println("*****************************************************************************************************************************");
    }

    /**
     * Metoda pro vyber z hlavniho menu
     *
     * @return vraci hodnotu int odpovidajici cisle v menu
     */
    private static int readChoice() {
        System.out.println("Zvolte, co chcete udělat:");
        int choice = sc.nextInt();
        System.out.println("*****************************************************************************************************************************");
        return choice;
    }

    /**
     * Metoda pro nacitani dat ze souboru
     */
    private static void uploadData() {
        try {
            data.nacti();
        } catch (IOException ex) {
            throw new IllegalArgumentException("nepodařilo se načíst");
        }
        dataFiltered = Data.loadDataAsArrayList();

    }

    /**
     * Metoda pro pridani dat do databaze
     *
     * @throws Metoda vyhazuje vyjimky pro neplatne vstupy dat.
     */
    private static void addData() {
        System.out.println("Zadejte místo:");
        String p = sc.next();
        System.out.println("Zadejte teplotu (stupně celsia) :");
        double t = sc.nextDouble();
        System.out.println("Zadejte srážky (mm) :");
        double pr = sc.nextDouble();
        try {
            if (pr < 0) {
                throw new IOException("Neplatný vstup!");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Neplatný vstup! ", e);
        }
        System.out.println("Zadejte oblačnost (oblacno,polojasno, jasno) :");
        String o = sc.next();
        try {
            if (o.equals("oblacno")) {

            } else if (o.equals("polojasno")) {

            } else if (o.equals("jasno")) {

            } else {
                throw new IOException("Neplatný vstup!");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Neplatný vstup! ", e);
        }
        System.out.println("Zadejte rychlost větru (m/s):");
        double v = sc.nextDouble();
        try {
            if (v < 0) {
                throw new IOException("Neplatný vstup!");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Neplatný vstup! ", e);
        }
        System.out.println("Zadejte datum (d/MM/yyyy) :");
        String date = sc.next();
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/MM/yyyy"));
        data.pridejPocasi(p, t, pr, o, v, localDate);
        try {
            data.uloz();
        } catch (IOException ex) {
            throw new IllegalArgumentException("nepodařilo se načíst");
        }
        dataFiltered = Data.loadDataAsArrayList();

    }

    /**
     * Metoda pro zobrazeni vsech dat v databazi na standardni vystup
     */
    private static void readData() {
        dataFiltered = Data.loadDataAsArrayList();
        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "místo", "teplota", "srážky", "oblačnost", "rychlost větru", "datum");
        for (int i = 0; i < (Data.loadDataAsArrayList()).size(); i++) {
            System.out.println((Data.loadDataAsArrayList()).get(i).getPocasi());
            //System.out.format("%-12s",(Data.loadDataAsArrayList()).get(i).getPocasi());
        }

    }

    /**
     * Metoda pro trideni dat podle srazek(pomoci comparator interface) a jejich
     * vypis na standardni vystup
     */
    private static void sortByPrecipitation() {
        Collections.sort(dataFiltered, Comparator.comparingDouble(Pocasi::getPrecipitation));
        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "místo", "teplota", "srážky", "oblačnost", "rychlost větru", "datum");
        for (int i = 0; i < (dataFiltered.size()); i++) {
            System.out.println((dataFiltered.get(i)).getPocasi());
        }

    }

    /**
     * Metoda pro trideni dat podle teploty(pomoci comparator interface) a
     * jejich vypis na standardni vystup
     */
    private static void sortByTemperature() {
        Collections.sort(dataFiltered, Comparator.comparingDouble(Pocasi::getTemperature));
        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "místo", "teplota", "srážky", "oblačnost", "rychlost větru", "datum");
        for (int i = 0; i < (dataFiltered.size()); i++) {
            System.out.println((dataFiltered.get(i)).getPocasi());
        }
    }

    /**
     * Metoda pro vyhledani dat podle mista a jejich vypis na standardni vystup
     */
    private static void filterByPlace() {
        ArrayList<Pocasi> dataByPlace = new ArrayList<Pocasi>();
        System.out.println("Zadejte místo:");
        String place = sc.next();
        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "místo", "teplota", "srážky", "oblačnost", "rychlost větru", "datum");
        for (int i = 0; i < dataFiltered.size(); i++) {
            if (((dataFiltered.get(i)).getPlace()).equals(place)) {
                dataByPlace.add(dataFiltered.get(i));
            }
        }
        //vyfiltrovana data ulozime do dataFiltered, abychom je dále mohli tridit napr. podle teploty
        dataFiltered = dataByPlace;
        for (int i = 0; i < (dataByPlace.size()); i++) {
            System.out.println((dataByPlace.get(i)).getPocasi());
        }
    }

    /**
     * Metoda pro znovunačteni souboru s daty -> vymazani dat s aktualniho
     * ArrayListu
     */
    private static void deleteData() {
        data = new Data("D:\\NetBeans\\Projects\\ALP2\\Semestrální_práce\\CZ_MeteorologyApp\\data\\pocasi.csv");
    }

    /**
     * Metoda pro trideni dat podle datumu(pomoci comparator interface) a jejich
     * vypis na standardni vystup
     */
    private static void sortByDate() {
        Collections.sort(dataFiltered, Comparator.comparing(Pocasi::getDate));
        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "místo", "teplota", "srážky", "oblačnost", "rychlost větru", "datum");
        for (int i = 0; i < (dataFiltered.size()); i++) {
            System.out.println((dataFiltered.get(i)).getPocasi());
        }
    }

    /**
     * Metoda pro odeslani data na emailovou adresu zadanou ze standardniho
     * vstupu, jejiz format je kontrolovan pomoci regularniho vyrazu.
     *
     * @param adresa - obsahuje String reprezentujici emailovou adresu
     * @param p - Pattern obsahujici formu, se kterou porovnavame adresu
     * @param m - Matcher, ktery nam porovnava zadanou adresu s Patternem p a
     * vraci hodnotu boolean
     */
    private static void sendDataEmail() {
        System.out.println("Zadejte vaši emailovou adresu(test@format.cz):");
        String adresa = sc.next();
        Pattern p = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
        Matcher m = p.matcher(adresa);
        if (m.find() == false) {
            System.out.println("Neplatná adresa!");
        }
        utils.JavaMail.SendMail(adresa);
    }

}
