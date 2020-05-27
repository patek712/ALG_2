/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08.elevengame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reprezentuje balicek karet
 * @author vojta.patek
 */
public class Deck {
    private List<Card> deckCards;
    private int deckSize;

    public Deck(List<Card> deckCards, int deckSize) {
        this.deckCards = deckCards;
        this.deckSize = deckSize;
    }


    public void shuffle() {
        Collections.shuffle(deckCards);
    }

    int getDeckSize() {
        return deckSize;
    }
    
    public Card giveCard() {
        Card card = deckCards.get(0);
        deckCards.remove(card);
        deckSize--;
        return card;
    }
    
    public static Deck makeDeck() {
        List<Card> cards = new ArrayList();
        String[] suits = {"hearts", "clubs","diamonds","spades" };
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit,rank);
                cards.add(card);
                
            }  
        }
        return new Deck(cards, cards.size());
    }
    
    
}
