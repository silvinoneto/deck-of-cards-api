package com.pm.deckofcards;

public enum CardSuit {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    public final String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }
}
