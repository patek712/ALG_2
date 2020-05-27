/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08.elevengame;

/**
 * Reprezentuje kartu
 * @author vojta.patek
 */
public class Card {
    private String suit;//suit
    private String rank;//rank
    private int nPoints;//A-1, J Q A - 0

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.nPoints = getValueOf(rank);
    }

   
    

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getnPoints() {
        return nPoints;
    }

    private int getValueOf(String rank) {
         switch(rank){
            case "A": return 1;
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            default: return 0;
         }
        
    }
    
}
