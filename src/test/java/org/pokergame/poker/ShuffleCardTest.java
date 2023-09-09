package org.pokergame.poker;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class ShuffleCardTest extends TestCase {

    public void testCardSetting() {
        List<Card> cardList = new ArrayList<>();
        CardSetting shuffleCard = new CardSetting();
        shuffleCard.cardSetting();
        System.out.println(shuffleCard);
    }

    public void testFillCard() {
    }
}