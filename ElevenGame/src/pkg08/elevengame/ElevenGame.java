/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08.elevengame;

import java.util.Scanner;

/**
 *
 * @author vojta.patek
 */
public class ElevenGame {

    public static Scanner sc = new Scanner(System.in);
    public static BoardInterface board;

    public static void main(String[] args) {
        Board board = Board.start();
        System.out.println("********* " + board.getName() + "**********");
        displayCards(board);
        displayDeck(board);
        while (board.isAnotherPlayPossible()) {;
            System.out.println("Vyber karty:");
            String[] selectedCardsPositions = sc.nextLine().split(" +");
            if (!board.playAndReplace(selectedCardsPositions)) {
                System.out.println("Nevalidni tah!");
            } else {
                displayCards(board);
                displayDeck(board);
            }

        }
        if(board.hasWon()){
            System.out.println("Gratuluji");
        } else {
            System.out.println("Nelze hrát");
        }
    }

    private static void displayCards(BoardInterface board) {
        for (int i = 0; i < board.nCards(); i++) {
            System.out.format("%1d. %20s ", i + 1, board.getCardDescriptionAt(i));
            if ((i + 1) % 3 == 0) {
                System.out.println("");
            }

        }
    }

    private static void displayDeck(BoardInterface board) {
        System.out.println("v balicku je" + board.getDeckSize() + " karet");
    }

}
