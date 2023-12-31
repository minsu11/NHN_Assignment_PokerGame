package org.pokergame.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 셔플된 카드만 준비
public class CardSetting {
    private List<Card> cardList = new ArrayList<>();

    public void cardSetting() { // 셔플된 카드 세팅
        fillCard(Suit.S);
        fillCard(Suit.H);
        fillCard(Suit.D);
        fillCard(Suit.C);

        Collections.shuffle(cardList);


    }

    public void fillCard(Suit suit) {
        cardList.add(new Card(suit, 1, 14));
        for (int i = 2; i < 14; i++) {
            cardList.add(new Card(suit, i, i));
        }
    }

    public void delete() {
        cardList.remove(0);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    @Override
    public String toString() {
        return "ShuffleCard{" +
                "cardList=" + cardList +
                '}';
    }
}
