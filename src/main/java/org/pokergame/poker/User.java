package org.pokergame.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private List<Card> handCard = new ArrayList<>();
    private CardSetting cardSetting = new CardSetting();
    private Rank rank = Rank.NOPAIR;
    private List<Card> rankCard = new ArrayList<>();


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

    @Override
    public String toString() {
        return "주어진 패: " + handCard +
                "\n";
    }

    public void rankCheck(int player) {
        int straight = 0;
        int end = handCard.get(handCard.size() - 1).getValue();
        for (int i = 0; i <= handCard.size() - 1; i++) {
            if (i < handCard.size() - 1 && handCard.get(i).getValue() == handCard.get(i + 1).getValue() && this.rank == Rank.NOPAIR) {
                this.rank = Rank.ONEPAIR;
                this.rankCard.add(handCard.get(i));
                this.rankCard.add(handCard.get(i + 1));
            } else if (i < handCard.size() - 1 && this.rank == Rank.ONEPAIR && handCard.get(i).getValue() == handCard.get(i + 1).getValue() && handCard.get(i).getValue() == handCard.get(i - 1).getValue()) {
                this.rank = Rank.TRIPLE;
                this.rankCard.add(handCard.get(i + 1));
            } else if (i < handCard.size() - 1 && this.rank == Rank.ONEPAIR && i > 0 && handCard.get(i).getValue() == handCard.get(i + 1).getValue() && handCard.get(i).getValue() != handCard.get(i - 1).getValue()) {
                this.rank = Rank.TWOPAIR;
                this.rankCard.add(handCard.get(i));
                this.rankCard.add(handCard.get(i + 1));
            } else if (end == 14 || (handCard.get(0).getValue() + i) <= 14 && handCard.get(i).getValue() == (handCard.get(0).getValue() + i)) {
                straight++;
            }

        }
        if (straight == 5) {
            this.rank = Rank.STRAIGHT;
            if (handCard.get(0).getValue() == 2) {
                this.rank = Rank.BACKSTRAIGHT;
            } else if (handCard.get(0).getValue() == 10) {
                this.rank = Rank.MOUNTAIE;
            }
            for (int i = 0; i < handCard.size(); i++) {
                this.rankCard.add(handCard.get(i));
            }
        } else if (this.rank == Rank.NOPAIR) {
            this.rankCard.add(handCard.get(handCard.size() - 1));
        }

    }


    public void sort() {
        Collections.sort(handCard);
    }

}
