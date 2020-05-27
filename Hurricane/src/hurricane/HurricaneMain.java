/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurricane;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vojta
 */
public class HurricaneMain {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static HurricanesData hurricanes = new HurricanesData("hurricanedata.txt");

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    loadData();
                    break;
                case 2:
                    getHurricaneByPeriod();
                    break;
                case 3:
                    getCategoryAndSpeed();
                    break;
                case 4:
                    sortBySpeed();
                    break;
                default:
                    System.out.println("Neplatná volba");
            }
        } while (choice != 0);
        
    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("1. Načíst data ze souboru");
        System.out.println("2. Informace o hurikánech v zadaném období");
        System.out.println("3. Zobrazit kategorii a rychlost");
        System.out.println("4. Setřídit podle rychlosti");
        System.out.println("0. Konec programu");
    }

    private static void loadData() {
        try {
            hurricanes.load();
        } catch (IOException ex) {
            throw new IllegalArgumentException("nepodařilo se načíst");
        }
    }

    private static void getHurricaneByPeriod() {
        System.out.println("Zadejte období:");
        int y1 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println(hurricanes.getHurricanesByPeriod(y1, y2));
        
    }

    private static void getCategoryAndSpeed() {
        System.out.println("Zadejte hledaný hurikán:");
        String name = sc.next();
        System.out.println(hurricanes.getCategoryAndSpeed(name));
    }

    private static void sortBySpeed() {
        hurricanes.sortBySpeed();
    }

    private static int readChoice() {
        System.out.println("Zvolte, co chcete udělat:");
        int choice = sc.nextInt();
        return choice;
    }
}
