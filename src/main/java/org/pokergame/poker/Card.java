package org.pokergame.poker;

public class Card implements Comparable<Card> {
    private int cardNumber;
    private Suit suit;
    private int value;

    public int getValue() {
        return value;
    }

    public Card(Suit suit, int cardNumber, int value) {
        if (cardNumber < 1 && cardNumber > 13) {
            throw new IllegalArgumentException("cardNumber < 0 or cardNumber > 13");
        }
        this.cardNumber = cardNumber;
        this.suit = suit;
        this.value = value;
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
        if (this.getValue() == o.getValue()) {
            return o.getSuit().ordinal() - this.getSuit().ordinal();
        } else {
            return this.getValue() - o.getValue();
        }
    }

}
