package com.pm.deckofcards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Deck of Cards
 */
public class DeckOfCards implements Serializable {

    private List<Card> cards = new ArrayList<>();

    public DeckOfCards() {
        initStandardDeck();
    }

    public int size() {
        return this.cards.size();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    /**
     * Deal one card from the deck.
     * <p>
     * The implementation returns the 1st card from the deck.
     * The card is removed from the deck.
     * Return null when the deck is empty.
     *
     * @return the first card in the deck
     */
    public synchronized Card dealOneCard() {
        Card card = null;
        if (!cards.isEmpty()) {
            card = this.cards.get(0); // return the first card
            this.cards.remove(0);
        }
        return card;
    }

    /**
     * Shuffle the deck.
     * All the cards in the deck are randomly permuted.
     */
    public synchronized void shuffle() {
        // randomly shuffle the deck

        // create a secondary deck for the shuffled cards
        ArrayList<Card> shuffled = new ArrayList<>();

        while (!this.cards.isEmpty()) {
            // Very strongly inspired from https://stackoverflow.com/questions/58844033/shuffling-deck-of-cards-using-card-object

            // Get a card randomly from the deck by the index
            //Math.random()*size will give a double between 0 and size of in order.
            //Round this down and convert to an int, and you have a random index!
            int randomIndex = (int) (Math.floor(Math.random() * this.cards.size()));

            Card toShuffle = cards.get(randomIndex);
            shuffled.add(toShuffle);
            this.cards.remove(randomIndex); // remove from current
        }

        this.cards = shuffled; // the shuffled deck is now the deck

    }


    /**
     * Initialize a standard 52 card deck containing one of each suit and rank.
     */
    synchronized void initStandardDeck() {
        // flush the current deck is not empty
        if (!this.cards.isEmpty()) {
            this.cards.clear();
        }
        // Create a card of each suit and rank in the deck.
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
        //System.out.println(String.format("A fresh deck with %d  cards!", this.cards.size()));
    }
}
