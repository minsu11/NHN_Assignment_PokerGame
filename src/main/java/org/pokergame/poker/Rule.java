package org.pokergame.poker;

public class Rule<T> {
    private Table table;
    private int people;
    private boolean numCompare = false;
    private boolean rankCompare = false;
    private int rankNum = Rank.NOPAIR.getRank();
    private int cardNum = 0;
    private int suitNum = Suit.C.getNumber();


    public Rule(int people) {
        if (people < 0) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
        this.table = new Table();
        this.table.createUser(people);
        this.people = people;

    }


    public Table getTable() {
        return table;
    }

    public int rankCompare(int compareNum, int idx, int self) {
        if (rankNum < compareNum) {
            rankNum = compareNum;
            rankCompare = false;
            return idx;
        } else {
            rankCompare = true;
        }
        return self;
    }


    public int numCompare(int compareNum, int compareNum2, int idx, int self) {
        if (this.rankNum == compareNum && cardNum < compareNum2) {
            cardNum = compareNum2;
            numCompare = false;
            return idx;
        } else if (cardNum == compareNum2) {
            numCompare = true;
        }

        return self;
    }


    public int loopRank(User[] users) {

        int result = 0;
        for (int i = 0; i < people; i++) { // parameter rank
            result = numCompare(rankNum, users[i].getRank().getRank(), i, result);
        }
        return result;
    }


    public int victory(User[] users) {
        int victoryPeople = loopRank(users);
        if (!rankCompare) {
            return victoryPeople;
        }
        for (int i = 0; i < people; i++) { // parameter rank, User
            victoryPeople = numCompare(users[i].getRank().getRank(),
                    users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber(), i, victoryPeople);

        }// 3중
        if (!numCompare) {
            return victoryPeople;
        }
        for (int i = 0; i < people; i++) {
            if (this.rankNum == users[i].getRank().getRank() && cardNum == users[i].getRankCard().get(users[i].getRankCard().size() - 1).getCardNumber() && users[i].getRankCard().size() > 0 && suitNum < users[i].getRankCard().get(users[i].getRankCard().size() - 1).getSuit().getNumber()) {
                suitNum = users[i].getRankCard().get(users[i].getRankCard().size() - 1).getSuit().getNumber();
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
