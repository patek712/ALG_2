/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08.elevengame;

/**
 *
 * @author vojta.patek
 */
public class Board implements BoardInterface {

    Card[] cards;//9 karet na stole
    Deck deck;//balicek karet

    public Board(Card[] cards, Deck deck) {
        this.cards = cards;
        this.deck = deck;
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }

    @Override
    public String getCardDescriptionAt(int index) {
        return cards[index].getSuit() + cards[index].getRank();
    }

    public Card[] getCards() {
        return cards;
    }

    public Deck getDeck() {
        return deck;
    }

    @Override
    public boolean isAnotherPlayPossible() {
        int nJQK = 0;
        int nEmpty = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {
                nEmpty++;
            } else {
                if (cards[i].getnPoints() == 0) {
                    nJQK++;
                }
                for (int j = i + 1; j < cards.length; j++) {
                    if (i < cards.length - 1 && cards[j] != null && cards[i].getnPoints() + cards[j].getnPoints() == 11) {
                        return true;
                    }
                }
            }
        }
        return nJQK > 2;
    }

    @Override
    public boolean hasWon() {
        return deck.getDeckSize() == 0;
    }

    @Override
    public boolean playAndReplace(String[] selectedCardsPositions) {
        int nPoints = 0;
        int[] selCards = new int[selectedCardsPositions.length];
        for (int i = 0; i < selectedCardsPositions.length; i++) {
            selCards[i] = Integer.parseInt(selectedCardsPositions[i]) - 1;
        }
        if (control(selCards)) {
            for (int i : selCards) {
                nPoints += cards[i].getnPoints();
            }
        } else {
            return false;
        }
        if ((nPoints == 11 && selCards.length == 2) || (nPoints == 0 && selCards.length == 3)) {
            for (int i : selCards) {
                cards[i] = deck.giveCard();
            }
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Eleven game";
    }

    @Override
    public int nCards() {
        return cards.length;
    }

    public static Board start() {
        Deck deck = Deck.makeDeck();
        deck.shuffle();
        Card[] cards = new Card[9];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.giveCard();

        }
        return new Board(cards, deck);
    }

    private boolean control(int[] selCards) {
        for (int i : selCards) {
            if (i < 0 || i > 8) {
                return false;
            }
        }
        return true;
    }
}
