package org.pokergame.poker;

public enum Suit {
    S("♠︎", 4),
    H("♥︎", 3),
    D("♦︎", 2),
    C("♣︎", 1);

    private final int number;
    private final String suit;


    Suit(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }
}
