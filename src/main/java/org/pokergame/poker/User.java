package org.pokergame.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private List<Card> handCard = new ArrayList<>();
    private CardSetting cardSetting = new CardSetting();
    private Rank rank;
    private List<Card> rankCard = new ArrayList<>();


    public User() {
        this.rank = Rank.NOPAIR;
    }

    public Rank getRank() {
        return rank;
    }

    public List<Card> getRankCard() {
        return rankCard;
    }

    public List<Card> getHandCard() {
        return handCard;
    }

    public void add(CardSetting cardSetting) {
        handCard.add(cardSetting.getCardList().get(0));
        cardSetting.delete();

    }

    public void rankCheck() {
        for (int i = 0; i < handCard.size() - 1; i++) {
            if (handCard.get(i).getCardNumber() == handCard.get(i + 1).getCardNumber() && this.rank == Rank.NOPAIR) {
                this.rank = Rank.ONEPAIR;
                this.rankCard.add(handCard.get(i));
                this.rankCard.add(handCard.get(i + 1));
            } else if (this.rank == Rank.ONEPAIR && handCard.get(i).getCardNumber() == handCard.get(i + 1).getCardNumber() && handCard.get(i).getCardNumber() == handCard.get(i - 1).getCardNumber()) {
                this.rank = Rank.TRIPLE;
                this.rankCard.add(handCard.get(i + 1));
            } else if (this.rank == Rank.ONEPAIR && i > 0 && handCard.get(i).getCardNumber() == handCard.get(i + 1).getCardNumber() && handCard.get(i).getCardNumber() != handCard.get(i - 1).getCardNumber()) {
                this.rank = Rank.TWOPAIR;
                this.rankCard.add(handCard.get(i));
                this.rankCard.add(handCard.get(i + 1));
            }
        }
        if (this.rank == Rank.NOPAIR) {
            this.rankCard.add(handCard.get(handCard.size() - 1));
        }

        System.out.println(this.rank);
        System.out.println("-----\n");
        System.out.println(this.rankCard + "\n");
    }


    @Override
    public String toString() {
        return "User{" +
                "cardList=" + handCard +
                '}';
    }

    public void sort() {
        Collections.sort(handCard);
    }

}
