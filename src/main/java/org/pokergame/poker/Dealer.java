package org.pokergame.poker;

public class Dealer {
    private CardSetting cardSetting = new CardSetting();

    public Dealer() {
        cardSetting.cardSetting();
    }

    public void handingOutCard(User user) {
        user.add(cardSetting);
    }

}
