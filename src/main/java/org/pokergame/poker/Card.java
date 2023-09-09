package org.pokergame.poker;

public class Card implements Comparable<Card> {
    private int cardNumber;
    private Suit suit;

    public Card(Suit suit, int cardNumber) {
        this.cardNumber = cardNumber;
        this.suit = suit;
    }


    public int getCardNumber() {
        return cardNumber;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit.getSuit() + cardNumber;
    }

    @Override
    public int compareTo(Card o) {
        if (this.getCardNumber() == o.getCardNumber()) {
            return o.getSuit().ordinal() - this.getSuit().ordinal();
        } else {
            return this.getCardNumber() - o.getCardNumber();
        }
    }
}
