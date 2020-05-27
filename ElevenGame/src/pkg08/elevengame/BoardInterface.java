/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08.elevengame;

/**
 *
 * @author vojta
 */
public interface BoardInterface {
    public String getName();
    
    public boolean isAnotherPlayPossible();

    public boolean hasWon();

    public boolean playAndReplace(String[] selectedCardsPositions);

    public int nCards();

    public int getDeckSize();
    
    public String getCardDescriptionAt(int index);
    
}
