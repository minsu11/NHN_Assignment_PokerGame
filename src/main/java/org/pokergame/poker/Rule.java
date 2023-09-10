package org.pokergame.poker;

public class Rule<T> {
    private Table table;
    private int victoryPeople = 0;
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
    }

    public Table getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "" + table;
    }

    public int getVictoryPeople() {
        return victoryPeople;
    }

    public int compare(int compareNum1, int compareNum2, int compareNum3, int highPlayer, int selfPlayer, int num) {
        if (this.rankNum == compareNum1 && this.cardNum == compareNum2 && this.suitNum < compareNum3) {
            compareBoolean(num, compareNum3, false);
            return highPlayer;
        } else if (this.suitNum == compareNum3) {
            compareBoolean(num, this.suitNum, true);
        }
        return selfPlayer;
    }

    public void loopRank(User[] users) {
        for (int i = 0; i < users.length; i++) { // parameter rank
            this.victoryPeople = compare(this.rankNum, this.cardNum, users[i].getRank().getRank(), i, this.victoryPeople, 0);
        }

        this.rankNum = this.suitNum;
        this.suitNum = Suit.C.getNumber();
    }

    public void loopCardNumber(User[] users) {
        for (int i = 0; i < users.length; i++) { // parameter rank
            if (this.rankNum == 4) {
                this.victoryPeople = compare(users[i].getRank().getRank(), this.cardNum,
                        users[i].getRankCard().get(0).getValue(), i, this.victoryPeople, 1);
            } else {
                this.victoryPeople = compare(users[i].getRank().getRank(), this.cardNum,
                        users[i].getRankCard().get(users[i].getRankCard().size() - 1).getValue(), i, this.victoryPeople, 1);
            }
        }

        this.cardNum = this.suitNum;
        this.suitNum = Suit.C.getNumber();
    }


    public void loopSuitNumber(User[] users) {
        for (int i = 0; i < users.length; i++) { // parameter rank
            this.victoryPeople = compare(users[i].getRank().getRank(),
                    users[i].getRankCard().get(users[i].getRankCard().size() - 1).getValue(), users[i].getRankCard().get(users[i].getRankCard().size() - 1).getSuit().getNumber(), i, this.victoryPeople, 2);
        }
    }

    public void victory(User[] users) {
        loopRank(users);
        if (!rankCompare) {
            return;
        }
        loopCardNumber(users);
        if (!numCompare) {
            return;
        }
        loopSuitNumber(users);

    }

    public void compareBoolean(int num, int valueInt, boolean valueBoolean) {
        this.suitNum = valueInt;
        if (num == 0) {
            this.rankCompare = valueBoolean;
        } else if (num == 1) {
            this.numCompare = valueBoolean;
        } else if (num > 2) {
            throw new IllegalArgumentException("해당하는 규칙은 없습니다.");
        }
    }

}
