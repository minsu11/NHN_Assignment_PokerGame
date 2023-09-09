package org.pokergame.poker;

public class Game {
    private Table table;
    private int num;

    public Game(int num) {
        this.num = num;
        table = new Table(num);
    }

    public void start() {
        int victoryPeople = 0;
        this.table.cardProgress();
        this.table.userRank();
        victoryPeople = table.victory();
        System.out.println("이긴사람 : 플레이어" + (victoryPeople + 1));
        System.out.println();
    }

    public Table getTable() {
        return table;
    }
}
