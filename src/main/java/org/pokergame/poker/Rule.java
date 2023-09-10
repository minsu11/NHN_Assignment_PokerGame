package org.pokergame.poker;

public class Rule<T> {
    private Table table;

    public Rule(int people) {
        if (people < 0) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
        this.table = new Table();
        this.table.createUser(people);

    }


    public Table getTable() {
        return table;
    }

    public int victory(int people, User[] users) {
        int victoryPeople = 0;
        boolean numCompare = false;
        boolean rankCompare = false;

        Rank rankPeople = Rank.NOPAIR;
        // getRank return type int
        for (int i = 0; i < people; i++) { // parameter rank
            if (rankPeople.getRank() < users[i].getRank().getRank()) {
                // int < int
                rankPeople = users[i].getRank();
                victoryPeople = i;
                rankCompare = false;
            } else if (rankPeople == users[i].getRank()) {
                rankCompare = true;
            }
        } // 2중
        if (!rankCompare) {
            return victoryPeople;
        }
        int cardNum = 0;
        for (int i = 0; i < people; i++) { // parameter rank, User
            if (rankPeople == users[i].getRank() && users[i].getRankCard().size() > 0 && cardNum < users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber() && rankPeople != Rank.TWOPAIR) {
                cardNum = users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber();
                victoryPeople = i;
                numCompare = false;
            } else if (cardNum == users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber()) {
                numCompare = true;
            }

        }// 3중
        if (!numCompare) {
            return victoryPeople;
        }
        Suit suit = Suit.C;

        for (int i = 0; i < people; i++) {
            if (rankPeople == users[i].getRank() && cardNum == users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber() && users[i].getRankCard().size() > 0 && suit.getNumber() < users[i].getRankCard().get(users[i].getRankCard().size() - 1).getSuit().getNumber()) {
                suit = users[i].getRankCard().get(users[i].getRankCard().size() - 1).getSuit();
                victoryPeople = i;

            }
        }

        return victoryPeople;
    }

    @Override
    public String toString() {
        return "" + table;
    }
}
