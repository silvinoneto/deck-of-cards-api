package com.pm.deckofcards;

public enum CardRank {

    ACE("Ace", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("`10`", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13);

    public final String rank;
    public final int value;

    CardRank(String rank, int value) {
        this.rank = rank;
        this.value = value;
    }

}
