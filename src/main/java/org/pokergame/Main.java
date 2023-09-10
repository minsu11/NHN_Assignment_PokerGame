package org.pokergame;

import org.pokergame.poker.Game;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        for (int k = 0; k < 100; k++) {
            Game game = new Game(4);
            game.start();
            for (int i = 0; i < 4; i++) {
                System.out.println(game.getRule().getTable().getUser(i));
            }

            System.out.println("\n\n");
        }
//        User user = new User();
//        Dealer dealer = new Dealer();
//        CardSetting cardSetting = new CardSetting();
//        cardSetting.cardSetting();
//        for (int i = 0; i < 3; i++) {
//            dealer.handingOutCard(user);
//
//        }
//        user.rankCheck();
//        System.out.println(user);
    }
}
