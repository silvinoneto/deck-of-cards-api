package com.pm.deckofcards;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable {
    CardSuit suit;
    CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.setSuit(Objects.requireNonNull(suit));
        this.setRank(Objects.requireNonNull(rank));
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}
