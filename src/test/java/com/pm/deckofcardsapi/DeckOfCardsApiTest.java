package com.pm.deckofcardsapi;

import com.pm.deckofcards.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsApiTest {

    DeckOfCardsApi testedApi = new DeckOfCardsApi();

    @Test
    void sizeOfDeckWhenNotCreated() {
        assertNull(this.testedApi.size(), "Expect a null size when the deck is not initially created");
    }

    @Test
    void sizeOfDeckWhenCreated() {
        this.testedApi.create();
        assertEquals(52, this.testedApi.size(), "Expect a deck of 52 cards");
    }

    @Test
    void sizeOfDeckAfterDealingACard() {
        this.testedApi.create();
        this.testedApi.dealOneCard();
        assertEquals(51, this.testedApi.size(), "Expect a deck of 51 cards after dealing the first card");
    }

    @Test
    void showWhenDeckNotCreated() {
        assertEquals(new ArrayList<>(), this.testedApi.show(), "Expect an empty deck of cards");
    }

    @Test
    void showWhenDeckCreated() {
        this.testedApi.create();
        assertEquals(52, this.testedApi.show().size(), "Expect to return a deck of 52 cards");
    }

    @Test
    void createNewDeck() {
        assertNull(this.testedApi.size(), "Expect a null size when the deck is not initially created");
        this.testedApi.create();
        assertEquals(52, this.testedApi.size(), "Expect a deck of 52 cards after creation");
    }

    @Test
    void shuffleDeck() {
        this.testedApi.create();
        String newDeck = this.testedApi.show().toString();

        this.testedApi.shuffle();
        String shuffledDeck = this.testedApi.show().toString();

        // the shuffled deck must be different than the previous one.
        assertNotEquals(newDeck, shuffledDeck, "Expecting both decks to be different");
    }

    @Test
    void dealOneCardWhenDeckNotInitialized() {
        assertNull(this.testedApi.dealOneCard(), "Expect null when deck is not initialized");
    }

    @Test
    void dealOneCardWhenDeckIsInitialized() {
        this.testedApi.create();
        assertNotNull(this.testedApi.dealOneCard(), "We received a valid card");
    }

    @Test
    void dealOneCardWhenDeckIsEmpty() {
        this.testedApi.create();
        while (!this.testedApi.show().isEmpty()) {
            this.testedApi.dealOneCard();

            //theDeck = this.testedApi.show();
        }

        // deal another time when the deck is empty
        assertEquals(0, this.testedApi.size(), "Expect to have a deck size of 0");
        Card beyondTheDeck = this.testedApi.dealOneCard();
        assertNull(beyondTheDeck, "Expect to have a null value when the deck is empty");
    }

}