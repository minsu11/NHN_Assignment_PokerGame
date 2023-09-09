package org.pokergame.poker;

public class Game {
    private Table table;

    public Game(int num) {
        table = new Table(num);
    }

    public void start() {
        int victoryPeople = 0;
        this.table.cardProgress();
        this.table.userRank();
        victoryPeople = this.table.victory();
        System.out.println("이긴사람 : 플레이어" + (victoryPeople + 1));
        System.out.println();
    }

    public Table getTable() {
        return table;
    }
}
