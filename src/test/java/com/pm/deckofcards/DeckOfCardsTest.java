package com.pm.deckofcards;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    @Test
    void testSize() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52, deck.size());
    }

    @Test
    void getCards() {
        DeckOfCards deck = new DeckOfCards();
        List<Card> cards = deck.getCards();
//        System.out.println(String.format("The deck has %d cards. The deck: %s", cards.size(), cards));
        assertEquals(cards.size(), deck.size());
        assertEquals(cards.get(5), deck.getCards().get(5));
    }

    @Test
    void testDealOneCard() {
        DeckOfCards deck = new DeckOfCards();
        int initDeckSize = deck.size();
        Card firstCard = deck.getCards().get(0);
        Card dealtCard = deck.dealOneCard();

        assertEquals(firstCard, dealtCard, "The dealt card should be the first one in the deck");
        assertEquals(initDeckSize - 1, deck.size(), "The deck should have one less card");
    }

    @Test
    void testDealOneCardUntilDeckEmpty() {
        DeckOfCards deck = new DeckOfCards();
        int initDeckSize = deck.size();
        int qtyDealtCards = 0;
        // count how many call
        while (!deck.getCards().isEmpty()) {
            Card dealt = deck.dealOneCard();
            assertNotNull(dealt, "Dealt card is initialized");
            qtyDealtCards++; //  count the amount of cards dealt
        }

        assertEquals(initDeckSize, qtyDealtCards, "Expected to have dealt" + initDeckSize + " cards.");

        // deal a card on an empty deck
        Card dealtCard = deck.dealOneCard();
        assertNull(dealtCard, "Expect a null value when dealing on an empty deck");
    }

    @Test
    void testShuffle() {
        DeckOfCards deck = new DeckOfCards();

        String pristineDeck = deck.getCards().toString();

        deck.shuffle();

        String shuffledDeck = deck.getCards().toString();

        System.out.println("pristine= " + pristineDeck);
        System.out.println("shuffled= " + shuffledDeck);

        // the shuffled deck is in a different order
        assertNotEquals(pristineDeck, shuffledDeck);
    }

    @Test
    void init() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52, deck.size());
        // modify the deck
        deck.dealOneCard();
        deck.dealOneCard();
        deck.dealOneCard();

        assertEquals(49, deck.size());

        deck.initStandardDeck(); // refresh the deck

        assertEquals(52, deck.size());
        // the deck is not shuffled so the order is predictable
        assertEquals(CardSuit.CLUBS, deck.getCards().get(0).getSuit());
        assertEquals(CardRank.ACE, deck.getCards().get(0).getRank());
    }
}