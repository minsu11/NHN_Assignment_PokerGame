package org.pokergame.poker;

import java.util.Arrays;

public class Table {
    private User[] users;
    private int people;
    private Dealer dealer = new Dealer();


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


    public User[] getUsers() {
        return users;
    }

    public User getUser(int i) {
        return users[i];
    }

    public void createUser(int people) {
        for (int i = 0; i < people; i++) {
            this.users[i] = new User(); // 각 개인의 user 생성
        }
    }


//    public int victory() {
//        return rule.victory(this.people, users);
//    }

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
        return "" + Arrays.toString(users);
    }

}
