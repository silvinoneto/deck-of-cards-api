package com.pm.deckofcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CardTest {

    @Test
    void testEquals() {
        Card c1 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card c2 = new Card(CardSuit.CLUBS, CardRank.ACE);
        assertEquals(c1, c2, "cards should be equals");
    }

    @Test
    void testNotEquals() {
        Card c1 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card c2 = new Card(CardSuit.DIAMONDS, CardRank.EIGHT);
        assertNotEquals(c1, c2, "cards should not be equals");
    }


    @Test
    void testHashCodeOn2EqualCards() {
        // 2 cards of the same type should have the same hash code
        Card c1 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card c2 = new Card(CardSuit.CLUBS, CardRank.ACE);
        assertEquals(c1.hashCode(), c2.hashCode(), "Cards of the same suit and rank should have the same hash code");
    }

    @Test
    void testHashCodeOn2DifferentCards() {
        // cards with different
        Card c1 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card c2 = new Card(CardSuit.CLUBS, CardRank.EIGHT);
        assertNotEquals(c1.hashCode(), c2.hashCode(), "Expect 2 different cards to have the same hash code.");
    }

    @Test
    void testToString() {
        // cards with different
        Card c1 = new Card(CardSuit.HEARTS, CardRank.KING);
        assertEquals("Card{suit=HEARTS, rank=KING}", c1.toString());

        Card c2 = new Card(CardSuit.CLUBS, CardRank.EIGHT);
        assertEquals("Card{suit=CLUBS, rank=EIGHT}", c2.toString());
    }

}