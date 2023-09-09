package org.pokergame.poker;

import java.util.Arrays;

public class Table {
    private User[] users;
    private int people;
    private Dealer dealer = new Dealer();

    public User getUsers(int n) {
        return users[n];
    }

    public Table(int people) {
        this.people = people;
        this.users = new User[people]; // User 배열 만큼 선언
        for (int i = 0; i < people; i++) {
            this.users[i] = new User(); // 각 개인의 user 생성
        }
    }

    public void userRank() {
        for (int i = 0; i < people; i++) {
            users[i].rankCheck();
        }
    }

    //    public int victory() {
//        int victoryPeople = 0;
//        boolean numCompare = false;
//        boolean rankCompare = false;
//
//        Rank rankPeople = Rank.NOPAIR;
//        for (int i = 0; i < this.people; i++) {
//            if (rankPeople.getRank() < users[i].getRank().getRank()) {
//                rankPeople = users[i].getRank();
//                victoryPeople = i;
//                rankCompare = false;
//            } else if (rankPeople == users[i].getRank()) {
//                rankCompare = true;
//            }
//        } // 2중
//        if (!rankCompare) {
//            return victoryPeople;
//        }
//        int cardNum = 0;
//        for (int i = 0; i < this.people; i++) {
//            if (rankPeople == users[i].getRank() && users[i].getRankCard().size() > 0 && cardNum < users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber() && rankPeople != Rank.TWOPAIR) {
//                cardNum = users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber();
//                victoryPeople = i;
//                numCompare = false;
//            }
//
//        }// 3중
//        if (!numCompare) {
//            return victoryPeople;
//        }
//        Suit suit = Suit.C;
//        for (int i = 0; i < this.people; i++) {
//            if (rankPeople == users[i].getRank() && cardNum == users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber() && users[i].getRankCard().size() > 0 && suit.getNumber() < users[i].getRankCard().get(users[i].getRankCard().size() - 1).getSuit().getNumber()) {
//                suit = users[i].getRankCard().get(users[i].getRankCard().size() - 1).getSuit();
//                victoryPeople = i;
//
//            }
//        }
//
//        return victoryPeople;
//    }
    public int victory() {
        return Rule.victory(this.people, users);
    }

    public void cardProgress() { // 유저에게 5장 카드를 나눠줌
        for (int i = 0; i < 5; i++) {
            userTurn();
        }
        userSort();
    }

    public void userSort() {
        for (int i = 0; i < people; i++) {
            users[i].sort();
        }
    }

    public void userTurn() {
        // 셔플된 카드를 턴마다 user에게 주기
        for (int i = 0; i < people; i++) {
            this.dealer.handingOutCard(users[i]);
        }
    }


    @Override
    public String toString() {
        return "users=" + Arrays.toString(users);
    }

}
